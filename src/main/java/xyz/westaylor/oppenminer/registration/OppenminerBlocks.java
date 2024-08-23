package xyz.westaylor.oppenminer.registration;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.datagen.BlockNameAndTab;
import xyz.westaylor.oppenminer.explosives.CustomExplosiveBlock;
import xyz.westaylor.oppenminer.registries.CreativeModeTabsEnum;
import xyz.westaylor.oppenminer.registries.RegistryBlockItem;

public class OppenminerBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OppenminerMod.MODID);

    // == Explosive Blocks ==
    @BlockNameAndTab(name="High-Power TNT", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryBlockItem<CustomExplosiveBlock> EXPLOSIVE_HE_BLOCK = registerBlock("explosive_he", 
        () -> new CustomExplosiveBlock(4, false, false), 
        new Item.Properties());

    @BlockNameAndTab(name="Atomic Bomb", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryBlockItem<CustomExplosiveBlock> EXPLOSIVE_ATOMIC_BLOCK = registerBlock("explosive_atomic", 
        () -> new CustomExplosiveBlock(32, true, true), 
        new Item.Properties());
    
    @BlockNameAndTab(name="Hydrogen Bomb", tab=CreativeModeTabsEnum.COMBAT)
    public static final RegistryBlockItem<CustomExplosiveBlock> EXPLOSIVE_HYDROGEN_BLOCK = registerBlock("explosive_hydrogen", 
        () -> new CustomExplosiveBlock(64, true, false), 
        new Item.Properties());

    // Used to create a block and block item
    private static <BlockType extends Block> RegistryBlockItem<BlockType> registerBlock(String name, Supplier<BlockType> block, Item.Properties blockItemProperties) {
        // Register the block
        RegistryObject<BlockType> registeredBlock = BLOCKS.register(name, block);

        // Register the block item
        RegistryObject<Item> registeredItem = OppenminerItems.ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), blockItemProperties));

        return new RegistryBlockItem<BlockType>(registeredBlock, registeredItem);
    }

    // Called by OppenminerMod initialization
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
