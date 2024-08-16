package xyz.westaylor.oppenminer.missiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import xyz.westaylor.oppenminer.explosives.CustomExplosiveBlock;

public class MissileEntity extends Snowball {
    private CustomExplosiveBlock explosive;
    private Player parent = null;

    public MissileEntity(Level world, LivingEntity parent, CustomExplosiveBlock explosive) {
        super(world, parent);

        this.explosive = explosive;
        this.parent = (parent instanceof Player) ? (Player)parent : null;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHit) {
        explode(entityHit.getEntity().blockPosition());
    }

    @Override
    protected void onHit(HitResult hit) {
        discard();
        explode(new BlockPos(
            (int)hit.getLocation().x,
            (int)hit.getLocation().y,
            (int)hit.getLocation().z
        ));
    }

    private void explode(BlockPos pos) {
        explosive.placeBomb(level(), pos, parent, 0);
    }
}
