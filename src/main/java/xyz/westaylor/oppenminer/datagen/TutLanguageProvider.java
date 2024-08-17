package xyz.westaylor.oppenminer.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import xyz.westaylor.oppenminer.OppenMinerMod;
import xyz.westaylor.oppenminer.Registration;

public class TutLanguageProvider extends LanguageProvider {

    public TutLanguageProvider(PackOutput output, String locale) {
        super(output, OppenMinerMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Registration.PLUTONIUM_SPHERE_ITEM.get(), "Plutonium Sphere");
        add(Registration.EXPLOSIVE_LENS_ITEM.get(), "Explosive Lens");
        add(Registration.LI_DT_FUEL_ITEM.get(), "Li-Dt Fuel Dust");
        add(Registration.INGOT_LI_DT_FUEL_ITEM.get(), "Li-Dt Fuel Ingot");
        add(Registration.FUSION_ASSEMBLY_ITEM.get(), "Fusion Assembly");
        add(Registration.HIGH_EXPLOSIVE_BLOCK.get(), "High Explosive");
        add(Registration.IMPLOSION_BOMB_BLOCK.get(), "Fission Bomb");
        add(Registration.HYDROGEN_BOMB_BLOCK.get(), "Fusion Bomb");
        add(Registration.BALLISTIC_SHELL_ITEM.get(), "Ballistic Shell");
        add(Registration.BALLISTIC_TNT_MISSILE_ITEM.get(), "Ballistic Missile (TNT)");
        add(Registration.BALLISTIC_IMPLOSION_MISSILE_ITEM.get(), "Ballistic Missile (Fission)");
        add(Registration.BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM.get(), "Ballistic Missile (High Explosive)");
        add(Registration.BALLISTIC_HYDROGEN_MISSILE_ITEM.get(), "Ballistic Missile (Fusion)");
    }
}