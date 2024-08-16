package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.westaylor.oppenminer.OppenMinerMod;
import xyz.westaylor.oppenminer.Registration;

import java.util.Map;
import java.util.stream.Collectors;

public class TutLootTables extends VanillaBlockLoot {

    @Override
    protected void generate() {
        dropSelf(Registration.HIGH_EXPLOSIVE_BLOCK.get());
        dropSelf(Registration.IMPLOSION_BOMB_BLOCK.get());
        dropSelf(Registration.HYDROGEN_BOMB_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(OppenMinerMod.MODID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}