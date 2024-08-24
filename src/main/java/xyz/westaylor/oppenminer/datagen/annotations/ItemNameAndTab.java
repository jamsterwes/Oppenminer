package xyz.westaylor.oppenminer.datagen.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import xyz.westaylor.oppenminer.registries.CreativeModeTabsEnum;

@Retention(RetentionPolicy.RUNTIME)
public @interface ItemNameAndTab {
    String name();
    CreativeModeTabsEnum tab();
}