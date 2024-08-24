package xyz.westaylor.oppenminer.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.vehicles.SubmarineEntity;
import xyz.westaylor.oppenminer.client.model.SubmarineModel;

public class SubmarineRenderer extends LivingEntityRenderer<SubmarineEntity, SubmarineModel<SubmarineEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(OppenminerMod.MODID, "textures/entity/submarine_entity.png");

    public SubmarineRenderer(Context ctx) {
        super(ctx, new SubmarineModel<SubmarineEntity>(ctx.bakeLayer(SubmarineModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(SubmarineEntity entity) {
        // Return the texture for the submarine
        return TEXTURE;
    }

    @Override
    protected void scale(SubmarineEntity entity, PoseStack poseStack, float partialTick) {
        float scale = 4.0f;
        poseStack.scale(scale, scale, scale);
    }
    
}
