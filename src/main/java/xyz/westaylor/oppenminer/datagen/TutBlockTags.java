package xyz.westaylor.oppenminer.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.westaylor.oppenminer.OppenminerMod;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class TutBlockTags extends BlockTagsProvider {

    public TutBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OppenminerMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}