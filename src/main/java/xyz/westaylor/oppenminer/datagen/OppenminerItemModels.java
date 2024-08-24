package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.registration.OppenminerBlocks;
import xyz.westaylor.oppenminer.registration.OppenminerItems;

public class OppenminerItemModels extends ItemModelProvider {

    public OppenminerItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OppenminerMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Block Items
        withExistingParent(OppenminerBlocks.EXPLOSIVE_HE_BLOCK.block.getId().getPath(), modLoc("block/explosive_he"));
        withExistingParent(OppenminerBlocks.EXPLOSIVE_ATOMIC_BLOCK.block.getId().getPath(), modLoc("block/explosive_atomic"));
        withExistingParent(OppenminerBlocks.EXPLOSIVE_HYDROGEN_BLOCK.block.getId().getPath(), modLoc("block/explosive_hydrogen"));

        // Regular Items
        basicItem(OppenminerItems.PLUTONIUM_SPHERE_ITEM.get());
        basicItem(OppenminerItems.EXPLOSIVE_LENS_ITEM.get());
        basicItem(OppenminerItems.DUST_LI_DT_FUEL_ITEM.get());
        basicItem(OppenminerItems.INGOT_LI_DT_FUEL_ITEM.get());
        basicItem(OppenminerItems.FUSION_ASSEMBLY_ITEM.get());
        basicItem(OppenminerItems.BALLISTIC_SHELL_ITEM.get());
        basicItem(OppenminerItems.BALLISTIC_MISSILE_TNT_ITEM.get());
        basicItem(OppenminerItems.BALLISTIC_MISSILE_HE_ITEM.get());
        basicItem(OppenminerItems.BALLISTIC_MISSILE_ATOMIC_ITEM.get());
        basicItem(OppenminerItems.BALLISTIC_MISSILE_HYDROGEN_ITEM.get());
    }
}