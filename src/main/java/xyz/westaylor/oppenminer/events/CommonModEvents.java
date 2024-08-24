package xyz.westaylor.oppenminer.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.registration.OppenminerEntityTypes;
import xyz.westaylor.oppenminer.vehicles.SubmarineEntity;

@Mod.EventBusSubscriber(modid = OppenminerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(OppenminerEntityTypes.SUBMARINE_ENTITY_TYPE.get(), SubmarineEntity.createLivingAttributes().build());
    }
}
