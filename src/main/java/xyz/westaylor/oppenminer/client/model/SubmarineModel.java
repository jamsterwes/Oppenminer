package xyz.westaylor.oppenminer.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.vehicles.SubmarineEntity;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class SubmarineModel<T extends SubmarineEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(OppenminerMod.MODID, "submarine"), "main");
	private final ModelPart body_32;
	private final ModelPart endcap_24;
	private final ModelPart frontcap_24;
	private final ModelPart endcap_16;
	private final ModelPart frontcap_16;
	private final ModelPart fins;
	private final ModelPart propeller;
	private final ModelPart bb_main;

	public SubmarineModel(ModelPart root) {
		this.body_32 = root.getChild("body_32");
		this.endcap_24 = root.getChild("endcap_24");
		this.frontcap_24 = root.getChild("frontcap_24");
		this.endcap_16 = root.getChild("endcap_16");
		this.frontcap_16 = root.getChild("frontcap_16");
		this.fins = root.getChild("fins");
		this.propeller = root.getChild("propeller");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body_32 = partdefinition.addOrReplaceChild("body_32", CubeListBuilder.create().texOffs(460, 203).addBox(-4.0F, -44.0F, -50.0F, 8.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(460, 102).addBox(-4.0F, -13.0F, -50.0F, 8.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(440, 317).addBox(-7.0F, -43.0F, -50.0F, 14.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(276, 417).addBox(-9.0F, -42.0F, -50.0F, 18.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(412, 418).addBox(-7.0F, -14.0F, -50.0F, 14.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(140, 416).addBox(-9.0F, -15.0F, -50.0F, 18.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(0, 414).addBox(-10.0F, -41.0F, -50.0F, 20.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(320, 0).addBox(-11.0F, -40.0F, -50.0F, 22.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(148, 315).addBox(-12.0F, -39.0F, -50.0F, 24.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(308, 215).addBox(-13.0F, -38.0F, -50.0F, 26.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(0, 211).addBox(-14.0F, -37.0F, -50.0F, 28.0F, 2.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(160, 111).addBox(-15.0F, -35.0F, -50.0F, 30.0F, 3.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-16.0F, -32.0F, -50.0F, 32.0F, 8.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(0, 108).addBox(-15.0F, -24.0F, -50.0F, 30.0F, 3.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(164, 8).addBox(-14.0F, -21.0F, -50.0F, 28.0F, 2.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(156, 214).addBox(-13.0F, -19.0F, -50.0F, 26.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(296, 316).addBox(-11.0F, -17.0F, -50.0F, 22.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(0, 313).addBox(-12.0F, -18.0F, -50.0F, 24.0F, 1.0F, 100.0F, new CubeDeformation(0.0F))
		.texOffs(320, 101).addBox(-10.0F, -16.0F, -50.0F, 20.0F, 1.0F, 100.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 36.0F, 2.0F));

		PartDefinition endcap_24 = partdefinition.addOrReplaceChild("endcap_24", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -31.0F, 48.0F, 24.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-11.0F, -34.0F, 48.0F, 22.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-10.0F, -35.0F, 48.0F, 20.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-10.0F, -22.0F, 48.0F, 20.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-9.0F, -36.0F, 48.0F, 18.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-9.0F, -21.0F, 48.0F, 18.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 61).addBox(-8.0F, -37.0F, 48.0F, 16.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 61).addBox(-8.0F, -20.0F, 48.0F, 16.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(44, 73).addBox(-7.0F, -38.0F, 48.0F, 14.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(44, 73).addBox(-7.0F, -19.0F, 48.0F, 14.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(36, 86).addBox(-6.0F, -39.0F, 48.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(36, 86).addBox(-6.0F, -18.0F, 48.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(60, 6).addBox(-3.0F, -40.0F, 48.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(60, 6).addBox(-3.0F, -17.0F, 48.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-11.0F, -25.0F, 48.0F, 22.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 36.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition frontcap_24 = partdefinition.addOrReplaceChild("frontcap_24", CubeListBuilder.create().texOffs(6, 6).addBox(-12.0F, -31.0F, 54.0F, 24.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 24).addBox(-11.0F, -34.0F, 54.0F, 22.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 39).addBox(-10.0F, -35.0F, 54.0F, 20.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 39).addBox(-10.0F, -22.0F, 54.0F, 20.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 52).addBox(-9.0F, -36.0F, 54.0F, 18.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 52).addBox(-9.0F, -21.0F, 54.0F, 18.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 67).addBox(-8.0F, -37.0F, 54.0F, 16.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 67).addBox(-8.0F, -20.0F, 54.0F, 16.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(50, 79).addBox(-7.0F, -38.0F, 54.0F, 14.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(50, 79).addBox(-7.0F, -19.0F, 54.0F, 14.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(42, 92).addBox(-6.0F, -39.0F, 54.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(42, 92).addBox(-6.0F, -18.0F, 54.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(66, 12).addBox(-3.0F, -40.0F, 54.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(66, 12).addBox(-3.0F, -17.0F, 54.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(6, 24).addBox(-11.0F, -25.0F, 54.0F, 22.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 36.0F, 112.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition endcap_16 = partdefinition.addOrReplaceChild("endcap_16", CubeListBuilder.create().texOffs(0, 78).addBox(-8.0F, -19.0F, 50.0F, 16.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 33).addBox(-7.0F, -21.0F, 50.0F, 14.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 33).addBox(-7.0F, -13.0F, 50.0F, 14.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(56, 19).addBox(-6.0F, -11.0F, 50.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(56, 19).addBox(-6.0F, -22.0F, 50.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 108).addBox(-5.0F, -10.0F, 50.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 108).addBox(-5.0F, -23.0F, 50.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 43).addBox(-3.0F, -9.0F, 50.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 43).addBox(-3.0F, -24.0F, 50.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -10.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition frontcap_16 = partdefinition.addOrReplaceChild("frontcap_16", CubeListBuilder.create().texOffs(4, 82).addBox(-8.0F, -19.0F, 54.0F, 16.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 37).addBox(-7.0F, -21.0F, 54.0F, 14.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 37).addBox(-7.0F, -13.0F, 54.0F, 14.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 23).addBox(-6.0F, -11.0F, 54.0F, 12.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 23).addBox(-6.0F, -22.0F, 54.0F, 12.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(4, 112).addBox(-5.0F, -10.0F, 54.0F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(4, 112).addBox(-5.0F, -23.0F, 54.0F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 47).addBox(-3.0F, -9.0F, 54.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 47).addBox(-3.0F, -24.0F, 54.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 116.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition fins = partdefinition.addOrReplaceChild("fins", CubeListBuilder.create().texOffs(36, 108).addBox(-1.0F, -16.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 108).addBox(-1.0F, 8.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -64.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r1 = fins.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 108).addBox(-1.0F, 8.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 108).addBox(-1.0F, -16.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition propeller = partdefinition.addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, 2.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -72.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r2 = propeller.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(72, 52).addBox(-2.0F, 8.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = propeller.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 8.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r4 = propeller.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -12.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(44, 46).addBox(-3.0F, -43.0F, 11.0F, 6.0F, 11.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(63, 61).addBox(-1.0F, -53.0F, 22.0F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(63, 61).addBox(-1.0F, -49.0F, 15.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(63, 61).addBox(-2.0F, -50.0F, 17.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(SubmarineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body_32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		endcap_24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontcap_24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		endcap_16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontcap_16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		fins.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		propeller.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}