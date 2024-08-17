package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.westaylor.oppenminer.OppenMinerMod;
import xyz.westaylor.oppenminer.Registration;

public class TutBlockStates extends BlockStateProvider {

    public TutBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OppenMinerMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.HYDROGEN_BOMB_BLOCK.get());
    }
}