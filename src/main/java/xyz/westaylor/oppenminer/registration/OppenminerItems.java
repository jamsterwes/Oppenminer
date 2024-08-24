package xyz.westaylor.oppenminer.registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.datagen.annotations.ItemNameAndTab;
import xyz.westaylor.oppenminer.missiles.MissileItem;
import xyz.westaylor.oppenminer.registries.CreativeModeTabsEnum;

public class OppenminerItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OppenminerMod.MODID);

    // == Atomic Ingredients ==
    @ItemNameAndTab(name="Plutonium Sphere", tab=CreativeModeTabsEnum.INGREDIENTS)
    public static final RegistryObject<Item> PLUTONIUM_SPHERE_ITEM = ITEMS.register("plutonium_sphere", () -> new Item(new Item.Properties().stacksTo(1)));

    @ItemNameAndTab(name="Explosive Lens", tab=CreativeModeTabsEnum.INGREDIENTS)
    public static final RegistryObject<Item> EXPLOSIVE_LENS_ITEM = ITEMS.register("explosive_lens", () -> new Item(new Item.Properties().stacksTo(8)));

    // == Hydrogen Ingredients ==
    @ItemNameAndTab(name="Li-Dt Fuel Dust", tab=CreativeModeTabsEnum.INGREDIENTS)
    public static final RegistryObject<Item> DUST_LI_DT_FUEL_ITEM = ITEMS.register("dust_li_dt_fuel", () -> new Item(new Item.Properties()));
    
    @ItemNameAndTab(name="Li-Dt Fuel Ingot", tab=CreativeModeTabsEnum.INGREDIENTS)
    public static final RegistryObject<Item> INGOT_LI_DT_FUEL_ITEM = ITEMS.register("ingot_li_dt_fuel", () -> new Item(new Item.Properties()));
    
    @ItemNameAndTab(name="Fusion Assembly", tab=CreativeModeTabsEnum.INGREDIENTS)
    public static final RegistryObject<Item> FUSION_ASSEMBLY_ITEM = ITEMS.register("fusion_assembly", () -> new Item(new Item.Properties().stacksTo(1)));

    // == Missile Ingredients ==
    @ItemNameAndTab(name="Ballistic Shell", tab=CreativeModeTabsEnum.INGREDIENTS)
    public static final RegistryObject<Item> BALLISTIC_SHELL_ITEM = ITEMS.register("ballistic_shell", () -> new Item(new Item.Properties().stacksTo(9)));

    // == Missiles ==
    @ItemNameAndTab(name="Ballistic Missile (TNT)", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryObject<MissileItem> BALLISTIC_MISSILE_TNT_ITEM = ITEMS.register("ballistic_missile_tnt", () -> new MissileItem(OppenminerBlocks.INTERNAL_TNT_BLOCK.block(), new Item.Properties().stacksTo(9)));
    
    @ItemNameAndTab(name="Ballistic Missile (High-Power TNT)", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryObject<MissileItem> BALLISTIC_MISSILE_HE_ITEM = ITEMS.register("ballistic_missile_he", () -> new MissileItem(OppenminerBlocks.EXPLOSIVE_HE_BLOCK.block(), new Item.Properties().stacksTo(9)));
    
    @ItemNameAndTab(name="Ballistic Missile (Atomic Bomb)", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryObject<MissileItem> BALLISTIC_MISSILE_ATOMIC_ITEM = ITEMS.register("ballistic_missile_atomic", () -> new MissileItem(OppenminerBlocks.EXPLOSIVE_ATOMIC_BLOCK.block(), new Item.Properties().stacksTo(9)));
    
    @ItemNameAndTab(name="Ballistic Missile (Hydrogen Bomb)", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryObject<MissileItem> BALLISTIC_MISSILE_HYDROGEN_ITEM = ITEMS.register("ballistic_missile_hydrogen", () -> new MissileItem(OppenminerBlocks.EXPLOSIVE_HYDROGEN_BLOCK.block(), new Item.Properties().stacksTo(9)));

    // Called by OppenminerMod initialization
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
