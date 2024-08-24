package xyz.westaylor.oppenminer.registration;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.datagen.annotations.BlockNameAndTab;
import xyz.westaylor.oppenminer.datagen.annotations.ItemNameAndTab;
import xyz.westaylor.oppenminer.lib.AnnotatedFieldFinder;
import xyz.westaylor.oppenminer.lib.EnumToMember;
import xyz.westaylor.oppenminer.registries.CreativeModeTabsEnum;
import xyz.westaylor.oppenminer.registries.RegistryBlockItem;

public class OppenminerCreativeTabs {

    private static void registerThisTab(BuildCreativeModeTabContentsEvent event, CreativeModeTabsEnum tabEnum) {
        // Iterate through blocks with this creative tab:
        AnnotatedFieldFinder.iterateFields(OppenminerBlocks.class, BlockNameAndTab.class, (BlockNameAndTab data, RegistryBlockItem<?> blockItem) -> {
            if (data.tab() == tabEnum) {
                event.accept(blockItem.item());
            }
        });

        // Iterate through blocks with this creative tab:
        AnnotatedFieldFinder.iterateFields(OppenminerItems.class, ItemNameAndTab.class, (ItemNameAndTab data, RegistryObject<Item> item) -> {
            if (data.tab() == tabEnum) {
                event.accept(item.get());
            }
        });
    }

    public static void register(BuildCreativeModeTabContentsEvent event) {
        // Use CreativeModeTabsEnum to loop through all tabs
        EnumToMember.stepwise(CreativeModeTabsEnum.class, CreativeModeTabs.class, (CreativeModeTabsEnum tabEnum, ResourceKey<CreativeModeTab> tabValue) -> {
            if (event.getTabKey() == tabValue) registerThisTab(event, tabEnum);
        });
    }
}
