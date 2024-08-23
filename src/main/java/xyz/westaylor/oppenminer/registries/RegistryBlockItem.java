package xyz.westaylor.oppenminer.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

// Used to register blocks and items together
public class RegistryBlockItem<BlockType extends Block> {
    public RegistryObject<BlockType> block;
    public RegistryObject<Item> item;

    public RegistryBlockItem(RegistryObject<BlockType> block, RegistryObject<Item> item) {
        this.block = block;
        this.item = item;
    }

    public BlockType block() {
        return this.block.get();
    }

    public Item item() {
        return this.item.get();
    }
}