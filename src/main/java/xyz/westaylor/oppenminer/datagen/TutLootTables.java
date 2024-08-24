package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.westaylor.oppenminer.OppenminerMod;

import java.util.Map;
import java.util.stream.Collectors;

public class TutLootTables extends VanillaBlockLoot {

    @Override
    protected void generate() {
        // TODO: change this
        Iterable<Block> knownBlocks = getKnownBlocks();
        for (Block block : knownBlocks) {
            dropSelf(block);
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(OppenminerMod.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}