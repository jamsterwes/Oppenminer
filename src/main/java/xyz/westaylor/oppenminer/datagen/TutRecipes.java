package xyz.westaylor.oppenminer.datagen;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import xyz.westaylor.oppenminer.Registration;

import java.util.Objects;
import java.util.function.Consumer;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(PackOutput packOutput) {
        super(packOutput);
    }

    private static final TagKey<Item> PLUTONIUM_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "pellets/plutonium"));
    private static final TagKey<Item> URANIUM_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots/uranium"));
    private static final TagKey<Item> COPPER_INGOT_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots/copper"));

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Plutonium Sphere
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.PLUTONIUM_SPHERE_ITEM.get())
                .pattern("ppp")
                .pattern("p p")
                .pattern("ppp")
                .define('p', PLUTONIUM_INGOT_TAG)
                .unlockedBy("has_plutonium_pellet", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(PLUTONIUM_INGOT_TAG).build()))
                .save(consumer);

        // Explosive Lens
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.EXPLOSIVE_LENS_ITEM.get())
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

        // High Explosive
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.HIGH_EXPLOSIVE_BLOCK.get())
                .pattern("ttt")
                .pattern("ttt")
                .pattern("ttt")
                .define('t', Items.TNT)
                .unlockedBy("has_tnt", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.TNT).build()))
                .save(consumer);

        // Implosion Device
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.IMPLOSION_BOMB_BLOCK.get())
                .pattern("eee")
                .pattern("ese")
                .pattern("eee")
                .define('e', Registration.EXPLOSIVE_LENS_ITEM.get())
                .define('s', Registration.PLUTONIUM_SPHERE_ITEM.get())
                .unlockedBy("has_explosive_lens_and_plutonium_sphere", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Registration.EXPLOSIVE_LENS_ITEM.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.PLUTONIUM_SPHERE_ITEM.get()).build()))
                .save(consumer);
    }
}