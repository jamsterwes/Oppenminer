package xyz.westaylor.oppenminer.registration;

import java.lang.reflect.Field;

import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.datagen.annotations.BlockNameAndTab;
import xyz.westaylor.oppenminer.datagen.annotations.ItemNameAndTab;
import xyz.westaylor.oppenminer.registries.CreativeModeTabsEnum;
import xyz.westaylor.oppenminer.registries.RegistryBlockItem;

public class OppenminerCreativeTabs {
    @SuppressWarnings("unchecked")
    private static void registerThisTab(BuildCreativeModeTabContentsEvent event, CreativeModeTabsEnum tabEnum, Field[] fields) {
        for (Field field : fields) {
            try {
                // Check for BlockNameAndTab annotation
                if (field.isAnnotationPresent(BlockNameAndTab.class)) {
                    LogUtils.getLogger().info("BlockNameAndTab: " + field.getName());
                    // Get annotation
                    BlockNameAndTab annotation = field.getAnnotation(BlockNameAndTab.class);
                    if (annotation.tab() != tabEnum) continue;

                    // Get the instance of the field
                    RegistryBlockItem<?> registryBlockItem = (RegistryBlockItem<?>) field.get(null);
                    
                    // Add BlockItem to tab
                    event.accept(registryBlockItem.item());
                } else if (field.isAnnotationPresent(ItemNameAndTab.class)) {
                    LogUtils.getLogger().info("BlockNameAndTab: " + field.getName());
                    // Get annotation
                    ItemNameAndTab annotation = field.getAnnotation(ItemNameAndTab.class);
                    if (annotation.tab() != tabEnum) continue;

                    // Get the instance of the field
                    RegistryObject<Item> registryItem = (RegistryObject<Item>) field.get(null);
                    
                    // Add BlockItem to tab
                    event.accept(registryItem);
                }
            } catch (IllegalAccessException e) {
                LogUtils.getLogger().error("Failed to access field: " + field.getName(), e);
            } catch (ClassCastException e) {
                LogUtils.getLogger().error("Failed to cast field: " + field.getName(), e);
            }
        }
    }

    private static void registerThisTab(BuildCreativeModeTabContentsEvent event, CreativeModeTabsEnum tabEnum) {
        // Loop through blocks & items
        Field[] blockFields = OppenminerBlocks.class.getDeclaredFields();
        Field[] itemFields = OppenminerItems.class.getDeclaredFields();
        registerThisTab(event, tabEnum, blockFields);
        registerThisTab(event, tabEnum, itemFields);
    }

    public static void register(BuildCreativeModeTabContentsEvent event) {
        // Add tabs
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            registerThisTab(event, CreativeModeTabsEnum.BUILDING_BLOCKS);
        } else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            registerThisTab(event, CreativeModeTabsEnum.COLORED_BLOCKS);
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            registerThisTab(event, CreativeModeTabsEnum.COMBAT);
        } else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            registerThisTab(event, CreativeModeTabsEnum.FOOD_AND_DRINKS);
        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            registerThisTab(event, CreativeModeTabsEnum.FUNCTIONAL_BLOCKS);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            registerThisTab(event, CreativeModeTabsEnum.INGREDIENTS);
        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            registerThisTab(event, CreativeModeTabsEnum.NATURAL_BLOCKS);
        } else if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            registerThisTab(event, CreativeModeTabsEnum.OP_BLOCKS);
        } else if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            registerThisTab(event, CreativeModeTabsEnum.REDSTONE_BLOCKS);
        }  else if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            registerThisTab(event, CreativeModeTabsEnum.SPAWN_EGGS);
        }  else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            registerThisTab(event, CreativeModeTabsEnum.TOOLS_AND_UTILITIES);
        } 
    }
}
