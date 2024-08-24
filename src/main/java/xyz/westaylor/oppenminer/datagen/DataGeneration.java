package xyz.westaylor.oppenminer.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import xyz.westaylor.oppenminer.datagen.automated.OppenminerLanguageProvider;
import xyz.westaylor.oppenminer.datagen.automated.OppenminerLootTables;
import xyz.westaylor.oppenminer.datagen.unused.OppenminerBlockStates;
import xyz.westaylor.oppenminer.datagen.unused.OppenminerBlockTags;
import xyz.westaylor.oppenminer.datagen.unused.OppenminerItemTags;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataGeneration {

    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new OppenminerBlockStates(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new OppenminerItemModels(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new OppenminerLanguageProvider(packOutput, "en_us"));

        OppenminerBlockTags blockTags = new OppenminerBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new OppenminerItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new OppenminerRecipes(packOutput));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(OppenminerLootTables::new, LootContextParamSets.BLOCK))));
    }
}