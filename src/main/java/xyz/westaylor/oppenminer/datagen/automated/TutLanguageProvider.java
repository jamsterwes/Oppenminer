package xyz.westaylor.oppenminer.datagen.automated;

import com.mojang.logging.LogUtils;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.datagen.annotations.BlockNameAndTab;
import xyz.westaylor.oppenminer.datagen.annotations.ItemNameAndTab;
import xyz.westaylor.oppenminer.lib.AnnotatedFieldFinder;
import xyz.westaylor.oppenminer.registration.OppenminerBlocks;
import xyz.westaylor.oppenminer.registration.OppenminerItems;
import xyz.westaylor.oppenminer.registries.RegistryBlockItem;

public class TutLanguageProvider extends LanguageProvider {

    public TutLanguageProvider(PackOutput output, String locale) {
        super(output, OppenminerMod.MODID, locale);
    }

    protected void parseBlockItemAnnotations(Class<?> clazz) {
        // Iterate through blocks and register their human-readable names
        AnnotatedFieldFinder.iterateFields(clazz, BlockNameAndTab.class, (BlockNameAndTab data, RegistryBlockItem<?> blockItem) -> {
            add(blockItem.block(), data.name());
            LogUtils.getLogger().info("LANGUAGE: Registered Block: " + data.name());
        });
    }

    protected void parseItemAnnotations(Class<?> clazz) {
        // Iterate through items and register their human-readable names
        AnnotatedFieldFinder.iterateFields(clazz, ItemNameAndTab.class, (ItemNameAndTab data, RegistryObject<Item> item) -> {
            add(item.get(), data.name());
            LogUtils.getLogger().info("LANGUAGE: Registered Item: " + data.name());
        });
    }

    @Override
    protected void addTranslations() {
        // Reflect over OppenminerBlocks
        parseBlockItemAnnotations(OppenminerBlocks.class);

        // Reflect over OppenminerItems
        parseItemAnnotations(OppenminerItems.class);
    }
}