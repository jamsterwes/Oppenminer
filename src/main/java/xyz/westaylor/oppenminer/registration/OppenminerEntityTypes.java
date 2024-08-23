package xyz.westaylor.oppenminer.registration;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.westaylor.oppenminer.OppenminerMod;

public class OppenminerEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OppenminerMod.MODID);
}
