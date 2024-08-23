package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.registration.OppenminerBlocks;

import java.util.Map;
import java.util.stream.Collectors;

public class TutLootTables extends VanillaBlockLoot {

    @Override
    protected void generate() {
        dropSelf(OppenminerBlocks.EXPLOSIVE_ATOMIC_BLOCK.block());
        dropSelf(OppenminerBlocks.EXPLOSIVE_HE_BLOCK.block());
        dropSelf(OppenminerBlocks.EXPLOSIVE_HYDROGEN_BLOCK.block());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(OppenminerMod.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}