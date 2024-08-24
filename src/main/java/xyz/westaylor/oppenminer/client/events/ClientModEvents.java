package xyz.westaylor.oppenminer.client.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.client.model.SubmarineModel;
import xyz.westaylor.oppenminer.client.renderer.SubmarineRenderer;
import xyz.westaylor.oppenminer.registration.OppenminerEntityTypes;

@Mod.EventBusSubscriber(modid = OppenminerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(OppenminerEntityTypes.SUBMARINE_ENTITY_TYPE.get(), SubmarineRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SubmarineModel.LAYER_LOCATION, SubmarineModel::createBodyLayer);
    }
}