package xyz.westaylor.oppenminer.datagen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import xyz.westaylor.oppenminer.registries.CreativeModeTabsEnum;

@Retention(RetentionPolicy.RUNTIME)
public @interface BlockNameAndTab {
    String name();
    CreativeModeTabsEnum tab();
}