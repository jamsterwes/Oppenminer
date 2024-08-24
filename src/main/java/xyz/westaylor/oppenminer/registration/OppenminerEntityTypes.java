package xyz.westaylor.oppenminer.registration;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.westaylor.oppenminer.OppenminerMod;
import xyz.westaylor.oppenminer.datagen.annotations.EntityName;
import xyz.westaylor.oppenminer.vehicles.SubmarineEntity;

public class OppenminerEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OppenminerMod.MODID);

    @EntityName(name="Submarine")
    public static final RegistryObject<EntityType<SubmarineEntity>> SUBMARINE_ENTITY_TYPE = ENTITY_TYPES.register("submarine", () -> EntityType.Builder.of(SubmarineEntity::new, MobCategory.MISC)
        .sized(1.5f, 1.5f)
        .setTrackingRange(64)
        .setUpdateInterval(3)
        .setShouldReceiveVelocityUpdates(true)
        .build("submarine"));

    // Called by OppenminerMod initialization
    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}
