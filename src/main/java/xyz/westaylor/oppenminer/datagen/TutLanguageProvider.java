package xyz.westaylor.oppenminer.datagen;

import java.lang.reflect.Field;

import com.mojang.logging.LogUtils;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.datagen.annotations.BlockNameAndTab;
import xyz.westaylor.oppenminer.datagen.annotations.ItemNameAndTab;
import xyz.westaylor.oppenminer.registration.OppenminerBlocks;
import xyz.westaylor.oppenminer.registration.OppenminerItems;
import xyz.westaylor.oppenminer.registries.RegistryBlockItem;

public class TutLanguageProvider extends LanguageProvider {

    public TutLanguageProvider(PackOutput output, String locale) {
        super(output, OppenminerMod.MODID, locale);
    }

    protected void parseBlockItemAnnotations(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            LogUtils.getLogger().info("FIELD: " + field.getName());
            try {
                // Check for BlockNameAndTab annotation
                if (field.isAnnotationPresent(BlockNameAndTab.class)) {
                    LogUtils.getLogger().info("BlockNameAndTab: " + field.getName());
                    // Get annotation
                    BlockNameAndTab annotation = field.getAnnotation(BlockNameAndTab.class);
                    String name = annotation.name();

                    // Get the instance of the field
                    RegistryBlockItem<?> registryBlockItem = (RegistryBlockItem<?>) field.get(null);

                    // Add the block item translation
                    add(registryBlockItem.block(), name);
                    LogUtils.getLogger().info("LANGUAGE: Registered Block: " + name);

                }
            } catch (IllegalAccessException e) {
                LogUtils.getLogger().error("Failed to access field: " + field.getName(), e);
            } catch (ClassCastException e) {
                LogUtils.getLogger().error("Failed to cast field: " + field.getName(), e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected void parseItemAnnotations(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            LogUtils.getLogger().info("FIELD: " + field.getName());
            try {
                // Check for ItemNameAndTab annotation
                if (field.isAnnotationPresent(ItemNameAndTab.class)) {
                    // Get annotation
                    ItemNameAndTab annotation = field.getAnnotation(ItemNameAndTab.class);
                    String name = annotation.name();

                    // Get the instance of the field
                    RegistryObject<Item> registryItem = (RegistryObject<Item>) field.get(null);

                    // Add the item translation
                    add(registryItem.get(), name);
                    LogUtils.getLogger().info("LANGUAGE: Registered Item: " + name);
                }
            } catch (IllegalAccessException e) {
                LogUtils.getLogger().error("Failed to access field: " + field.getName(), e);
            } catch (ClassCastException e) {
                LogUtils.getLogger().error("Failed to cast field: " + field.getName(), e);
            }
        }
    }

    @Override
    protected void addTranslations() {
        // Reflect over OppenminerBlocks
        parseBlockItemAnnotations(OppenminerBlocks.class);
        parseItemAnnotations(OppenminerItems.class);

        // add(Registration.PLUTONIUM_SPHERE_ITEM.get(), "Plutonium Sphere");
        // add(Registration.EXPLOSIVE_LENS_ITEM.get(), "Explosive Lens");
        // add(Registration.LI_DT_FUEL_ITEM.get(), "Li-Dt Fuel Dust");
        // add(Registration.INGOT_LI_DT_FUEL_ITEM.get(), "Li-Dt Fuel Ingot");
        // add(Registration.FUSION_ASSEMBLY_ITEM.get(), "Fusion Assembly");
        // add(Registration.HIGH_EXPLOSIVE_BLOCK.get(), "High Explosive");
        // add(Registration.IMPLOSION_BOMB_BLOCK.get(), "Fission Bomb");
        // add(Registration.HYDROGEN_BOMB_BLOCK.get(), "Fusion Bomb");
        // add(Registration.BALLISTIC_SHELL_ITEM.get(), "Ballistic Shell");
        // add(Registration.BALLISTIC_TNT_MISSILE_ITEM.get(), "Ballistic Missile (TNT)");
        // add(Registration.BALLISTIC_IMPLOSION_MISSILE_ITEM.get(), "Ballistic Missile (Fission)");
        // add(Registration.BALLISTIC_HIGH_EXPLOSIVE_MISSILE_ITEM.get(), "Ballistic Missile (High Explosive)");
        // add(Registration.BALLISTIC_HYDROGEN_MISSILE_ITEM.get(), "Ballistic Missile (Fusion)");
    }
}