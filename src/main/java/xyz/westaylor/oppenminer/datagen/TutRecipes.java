package xyz.westaylor.oppenminer.datagen;

import com.mojang.logging.LogUtils;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.ChemicalUtils;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.datagen.recipe.MekanismRecipeBuilder;
import mekanism.api.datagen.recipe.builder.ChemicalChemicalToChemicalRecipeBuilder;
import mekanism.api.datagen.recipe.builder.ChemicalCrystallizerRecipeBuilder;
import mekanism.api.datagen.recipe.builder.ItemStackChemicalToItemStackRecipeBuilder;
import mekanism.api.datagen.recipe.builder.PressurizedReactionRecipeBuilder;
import mekanism.api.math.FloatingLong;
import mekanism.api.recipes.ChemicalInfuserRecipe;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.FluidStackIngredient;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import xyz.westaylor.oppenminer.Registration;

import java.util.Objects;
import java.util.function.Consumer;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(PackOutput packOutput) {
        super(packOutput);
    }

    private static final TagKey<Item> PLUTONIUM_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "pellets/plutonium"));
    private static final TagKey<Item> IRON_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots/iron"));
    private static final TagKey<Item> GOLD_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots/gold"));
    private static final TagKey<Item> URANIUM_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots/uranium"));
    private static final TagKey<Item> COPPER_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots/copper"));
    private static final TagKey<Item> LITHIUM_DUST_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/lithium"));
    private static final TagKey<Gas> DEUTERIUM_GAS_TAG = TagKey.create(MekanismAPI.GAS_REGISTRY_NAME, new ResourceLocation("mekanism", "deuterium"));
    private static final TagKey<Fluid> WATER_TAG = TagKey.create(Registries.FLUID, new ResourceLocation("minecraft", "water"));

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Plutonium Sphere
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.PLUTONIUM_SPHERE_ITEM.get())
                .pattern("ppp")
                .pattern("p p")
                .pattern("ppp")
                .define('p', PLUTONIUM_INGOT_TAG)
                .unlockedBy("has_plutonium_pellet", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(PLUTONIUM_INGOT_TAG).build()))
                .save(consumer);

        // Explosive Lens
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.EXPLOSIVE_LENS_ITEM.get())
                .pattern(" c ")
                .pattern("hth")
                .pattern("tut")
                .define('h', Registration.HIGH_EXPLOSIVE_BLOCK_ITEM.get())
                .define('c', COPPER_INGOT_TAG)
                .define('t', Items.TNT)
                .define('u', URANIUM_INGOT_TAG)
                .unlockedBy("has_high_explosive", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.HIGH_EXPLOSIVE_BLOCK_ITEM.get()).build()))
                .save(consumer);

        // Fusion Assembly
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.FUSION_ASSEMBLY_ITEM.get())
                .pattern("dpd")
                .pattern("dpd")
                .pattern("dpd")
                .define('d', Registration.INGOT_LI_DT_FUEL_ITEM.get())
                .define('p', PLUTONIUM_INGOT_TAG)
                .unlockedBy("has_ingot_li_dt_fuel", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.INGOT_LI_DT_FUEL_ITEM.get()).build()))
                .save(consumer);

        // High Explosive
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.HIGH_EXPLOSIVE_BLOCK.get())
                .pattern("ttt")
                .pattern("ttt")
                .pattern("ttt")
                .define('t', Items.TNT)
                .unlockedBy("has_tnt", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.TNT).build()))
                .save(consumer);

        // Implosion Bomb
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.IMPLOSION_BOMB_BLOCK.get())
                .pattern("eee")
                .pattern("ese")
                .pattern("eee")
                .define('e', Registration.EXPLOSIVE_LENS_ITEM.get())
                .define('s', Registration.PLUTONIUM_SPHERE_ITEM.get())
                .unlockedBy("has_explosive_lens_and_plutonium_sphere", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.EXPLOSIVE_LENS_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.PLUTONIUM_SPHERE_ITEM.get()).build()))
                .save(consumer);

        // Hydrogen Bomb
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.HYDROGEN_BOMB_BLOCK.get())
                .pattern("gIg")
                .pattern("gFg")
                .pattern("ggg")
                .define('F', Registration.FUSION_ASSEMBLY_ITEM.get())
                .define('I', Registration.IMPLOSION_BOMB_BLOCK.get())
                .define('g', GOLD_INGOT_TAG)
                .unlockedBy("has_fusion_assembly_and_implosion_bomb", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.FUSION_ASSEMBLY_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.IMPLOSION_BOMB_BLOCK.get()).build()))
                .save(consumer);

        // Ballistic Shell
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.BALLISTIC_SHELL_ITEM.get())
                .pattern("IbI")
                .pattern("IbI")
                .pattern("IbI")
                .define('I', Items.IRON_BLOCK)
                .define('b', Items.BLAZE_POWDER)
                .unlockedBy("has_blaze_powder", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.BLAZE_POWDER).build()
                ))
                .save(consumer);

        // Ballistic Missile (TNT)
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.BALLISTIC_TNT_MISSILE_ITEM.get())
                .pattern(" I ")
                .pattern(" e ")
                .pattern("isi")
                .define('i', IRON_INGOT_TAG)
                .define('I', Items.IRON_BLOCK)
                .define('s', Registration.BALLISTIC_SHELL_ITEM.get())
                .define('e', Items.TNT)
                .unlockedBy("has_ballistic_shell_and_tnt", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.BALLISTIC_SHELL_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Items.TNT).build()
                ))
                .save(consumer);

        // Ballistic Missile (High Explosive)
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM.get())
                .pattern(" I ")
                .pattern(" e ")
                .pattern("isi")
                .define('i', IRON_INGOT_TAG)
                .define('I', Items.IRON_BLOCK)
                .define('s', Registration.BALLISTIC_SHELL_ITEM.get())
                .define('e', Registration.HIGH_EXPLOSIVE_BLOCK_ITEM.get())
                .unlockedBy("has_ballistic_shell_and_high_explosive", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.BALLISTIC_SHELL_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.HIGH_EXPLOSIVE_BLOCK_ITEM.get()).build()
                ))
                .save(consumer);

        // Ballistic Missile (Fission)
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.BALLISTIC_IMPLOSION_MISSILE_ITEM.get())
                .pattern(" I ")
                .pattern(" e ")
                .pattern("isi")
                .define('i', IRON_INGOT_TAG)
                .define('I', Items.IRON_BLOCK)
                .define('s', Registration.BALLISTIC_SHELL_ITEM.get())
                .define('e', Registration.IMPLOSION_BOMB_BLOCK_ITEM.get())
                .unlockedBy("has_ballistic_shell_and_fission", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.BALLISTIC_SHELL_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.IMPLOSION_BOMB_BLOCK_ITEM.get()).build()
                ))
                .save(consumer);

        // Ballistic Missile (Fusion)
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Registration.BALLISTIC_HYDROGEN_MISSILE_ITEM.get())
                .pattern(" I ")
                .pattern(" e ")
                .pattern("isi")
                .define('i', IRON_INGOT_TAG)
                .define('I', Items.IRON_BLOCK)
                .define('s', Registration.BALLISTIC_SHELL_ITEM.get())
                .define('e', Registration.HYDROGEN_BOMB_BLOCK_ITEM.get())
                .unlockedBy("has_ballistic_shell_and_fusion", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.BALLISTIC_SHELL_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.HYDROGEN_BOMB_BLOCK_ITEM.get()).build()
                ))
                .save(consumer);

        // Li-DT (PRC Recipe)
        PressurizedReactionRecipeBuilder.reaction(
                IngredientCreatorAccess.item().from(LITHIUM_DUST_TAG, 8),
                IngredientCreatorAccess.fluid().from(WATER_TAG, 1000),
                IngredientCreatorAccess.gas().from(DEUTERIUM_GAS_TAG, 1000),
                60,
                Registration.LI_DT_FUEL_ITEM.get().getDefaultInstance()
        ).build(consumer, new ResourceLocation("mekanism", "reaction/li_dt"));
    }
}