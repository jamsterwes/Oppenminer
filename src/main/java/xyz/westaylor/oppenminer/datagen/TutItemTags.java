package xyz.westaylor.oppenminer.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.westaylor.oppenminer.OppenminerMod;

import java.util.concurrent.CompletableFuture;

public class TutItemTags extends ItemTagsProvider {

    public TutItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, blockTags.contentsGetter(), OppenminerMod.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}