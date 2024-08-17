package xyz.westaylor.oppenminer;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.explosives.CustomExplosiveBlock;
import xyz.westaylor.oppenminer.missiles.MissileItem;

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OppenMinerMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OppenMinerMod.MODID);

    // Plutonium Sphere
    public static final RegistryObject<Item> PLUTONIUM_SPHERE_ITEM = ITEMS.register("plutonium_sphere", () -> new Item(new Item.Properties().stacksTo(1).requiredFeatures()));

    // Explosive Lens
    public static final RegistryObject<Item> EXPLOSIVE_LENS_ITEM = ITEMS.register("explosive_lens", () -> new Item(new Item.Properties().stacksTo(8).requiredFeatures()));

    // High Explosive
    public static final RegistryObject<CustomExplosiveBlock> HIGH_EXPLOSIVE_BLOCK = BLOCKS.register("high_explosive", () -> new CustomExplosiveBlock(8.0f, false, false));
    public static final RegistryObject<Item> HIGH_EXPLOSIVE_BLOCK_ITEM = ITEMS.register("high_explosive", () -> new BlockItem(HIGH_EXPLOSIVE_BLOCK.get(), new Item.Properties()));

    // Fission Bomb
    public static final RegistryObject<CustomExplosiveBlock> IMPLOSION_BOMB_BLOCK = BLOCKS.register("implosion_bomb", () -> new CustomExplosiveBlock(32.0f, true, true));
    public static final RegistryObject<Item> IMPLOSION_BOMB_BLOCK_ITEM = ITEMS.register("implosion_bomb", () -> new BlockItem(IMPLOSION_BOMB_BLOCK.get(), new Item.Properties()));

    // Lithium Deuteride Fuel
    public static final RegistryObject<Item> LI_DT_FUEL_ITEM = ITEMS.register("li_dt_fuel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_LI_DT_FUEL_ITEM = ITEMS.register("ingot_li_dt_fuel", () -> new Item(new Item.Properties()));

    // Fission Assembly
    public static final RegistryObject<Item> FUSION_ASSEMBLY_ITEM = ITEMS.register("fusion_assembly", () -> new Item(new Item.Properties()));

    // Hydrogen Bomb
    public static final RegistryObject<CustomExplosiveBlock> HYDROGEN_BOMB_BLOCK = BLOCKS.register("hydrogen_bomb", () -> new CustomExplosiveBlock(64.0f, true, false));
    public static final RegistryObject<Item> HYDROGEN_BOMB_BLOCK_ITEM = ITEMS.register("hydrogen_bomb", () -> new BlockItem(HYDROGEN_BOMB_BLOCK.get(), new Item.Properties()));

    // Ballistic Shell
    public static final RegistryObject<Item> BALLISTIC_SHELL_ITEM = ITEMS.register("ballistic_shell", () -> new Item(new Item.Properties()));

    // Fake TNT for ballistic missile
    public static final RegistryObject<CustomExplosiveBlock> FAKE_TNT_BLOCK = BLOCKS.register("fake_tnt", () -> new CustomExplosiveBlock(2.0f, false, false));

    // Ballistic Missile (TNT)
    public static final RegistryObject<Item> BALLISTIC_TNT_MISSILE_ITEM = ITEMS.register("ballistic_missile_tnt", () -> new MissileItem(FAKE_TNT_BLOCK.get(), new Item.Properties()));

    // Ballistic Missile (High Explosive)
    public static final RegistryObject<Item> BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM = ITEMS.register("ballistic_missile_he", () -> new MissileItem(HIGH_EXPLOSIVE_BLOCK.get(), new Item.Properties()));

    // Ballistic Missile (Fission)
    public static final RegistryObject<Item> BALLISTIC_IMPLOSION_MISSILE_ITEM = ITEMS.register("ballistic_missile_fission", () -> new MissileItem(IMPLOSION_BOMB_BLOCK.get(), new Item.Properties()));

    // Ballistic Missile (Hydrogen)
    public static final RegistryObject<Item> BALLISTIC_HYDROGEN_MISSILE_ITEM = ITEMS.register("ballistic_missile_hydrogen", () -> new MissileItem(HYDROGEN_BOMB_BLOCK.get(), new Item.Properties()));

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(HIGH_EXPLOSIVE_BLOCK_ITEM);
            event.accept(IMPLOSION_BOMB_BLOCK_ITEM);
            event.accept(HYDROGEN_BOMB_BLOCK_ITEM);
            event.accept(BALLISTIC_TNT_MISSILE_ITEM);
            event.accept(BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM);
            event.accept(BALLISTIC_IMPLOSION_MISSILE_ITEM);
            event.accept(BALLISTIC_HYDROGEN_MISSILE_ITEM);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(PLUTONIUM_SPHERE_ITEM);
            event.accept(EXPLOSIVE_LENS_ITEM);
            event.accept(BALLISTIC_SHELL_ITEM);
        }
    }
}