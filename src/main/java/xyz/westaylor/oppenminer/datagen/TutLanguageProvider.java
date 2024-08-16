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
        add(Registration.HIGH_EXPLOSIVE_BLOCK.get(), "High Explosive");
        add(Registration.IMPLOSION_BOMB_BLOCK.get(), "Fission Bomb");
        add(Registration.HYDROGEN_BOMB_BLOCK.get(), "Fusion Bomb");
        add(Registration.BALLISTIC_IMPLOSION_MISSILE_ITEM.get(), "Ballistic Missile (Fission)");
        add(Registration.BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM.get(), "Ballistic Missile (High Explosive)");
        add(Registration.BALLISTIC_HYDROGEN_MISSILE_ITEM.get(), "Ballistic Missile (Fusion)");
    }
}