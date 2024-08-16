package xyz.westaylor.oppenminer.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataGeneration {

    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new TutBlockStates(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new TutItemModels(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new TutLanguageProvider(packOutput, "en_us"));

        TutBlockTags blockTags = new TutBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new TutItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new TutRecipes(packOutput));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(TutLootTables::new, LootContextParamSets.BLOCK))));
    }
}