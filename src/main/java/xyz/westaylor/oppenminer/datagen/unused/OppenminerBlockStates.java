package xyz.westaylor.oppenminer.datagen.unused;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.westaylor.oppenminer.OppenminerMod;

public class OppenminerBlockStates extends BlockStateProvider {

    public OppenminerBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OppenminerMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }
}