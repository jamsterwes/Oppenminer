package xyz.westaylor.oppenminer.registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.westaylor.oppenminer.OppenminerMod;

public class OppenminerItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OppenminerMod.MODID);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
