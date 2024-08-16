package xyz.westaylor.oppenminer.explosives;

import mekanism.api.Coord4D;
import mekanism.api.radiation.IRadiationManager;
import net.minecraft.core.Vec3i;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class CustomExplosiveEntity extends PrimedTnt {
    private static final EntityDataAccessor<Float> EXPLOSION_POWER_ID = SynchedEntityData.defineId(CustomExplosiveEntity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Boolean> SETS_FIRE_ID = SynchedEntityData.defineId(CustomExplosiveEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> IS_RADIOACTIVE_ID = SynchedEntityData.defineId(CustomExplosiveEntity.class, EntityDataSerializers.BOOLEAN);

    public CustomExplosiveEntity(Level world, double x, double y, double z, @Nullable LivingEntity owner) {
        super(world, x, y, z, owner);
    }

    @Override
    protected void explode() {
        // this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), entityData.get(EXPLOSION_POWER_ID), entityData.get(SETS_FIRE_ID), Level.ExplosionInteraction.TNT);

        // Call custom explosion
        Vec3i iPos = new Vec3i((int)this.getX(), (int)this.getY(0.0625D), (int)this.getZ());
        int iRadius = entityData.get(EXPLOSION_POWER_ID).intValue();
        boolean setsFire = entityData.get(SETS_FIRE_ID);
        ReplacementExplosion.explode(iPos, iRadius, this.getServer().getLevel(this.level().dimension()), setsFire ? Blocks.FIRE.defaultBlockState() : null, 0.05f);

        // Do radiation
        if (entityData.get(IS_RADIOACTIVE_ID)) {
            IRadiationManager.INSTANCE.radiate(new Coord4D(this), 0.1f);
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(EXPLOSION_POWER_ID, 4.0f);
        entityData.define(SETS_FIRE_ID, false);
        entityData.define(IS_RADIOACTIVE_ID, false);
    }

    public void setRadioactive(boolean isRadioactive) { entityData.set(IS_RADIOACTIVE_ID, isRadioactive); }

    public void setExplosionPower(float explosionPower) {
        entityData.set(EXPLOSION_POWER_ID, explosionPower);
    }

    public void setSetsFire(boolean setsFire) {
        entityData.set(SETS_FIRE_ID, setsFire);
    }
}