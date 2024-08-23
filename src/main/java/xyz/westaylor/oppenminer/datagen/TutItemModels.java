package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.Registration;

public class TutItemModels extends ItemModelProvider {

    public TutItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OppenminerMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // // Block Items
        // withExistingParent(Registration.HIGH_EXPLOSIVE_BLOCK.getId().getPath(), modLoc("block/high_explosive"));
        // withExistingParent(Registration.IMPLOSION_BOMB_BLOCK.getId().getPath(), modLoc("block/implosion_bomb"));
        // withExistingParent(Registration.HYDROGEN_BOMB_BLOCK.getId().getPath(), modLoc("block/hydrogen_bomb"));

        // // Regular Items
        // basicItem(Registration.PLUTONIUM_SPHERE_ITEM.get());
        // basicItem(Registration.EXPLOSIVE_LENS_ITEM.get());
        // basicItem(Registration.LI_DT_FUEL_ITEM.get());
        // basicItem(Registration.INGOT_LI_DT_FUEL_ITEM.get());
        // basicItem(Registration.FUSION_ASSEMBLY_ITEM.get());
        // basicItem(Registration.BALLISTIC_SHELL_ITEM.get());
        // basicItem(Registration.BALLISTIC_TNT_MISSILE_ITEM.get());
        // basicItem(Registration.BALLISTIC_IMPLOSION_MISSILE_ITEM.get());
        // basicItem(Registration.BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM.get());
        // basicItem(Registration.BALLISTIC_HYDROGEN_MISSILE_ITEM.get());
    }
}