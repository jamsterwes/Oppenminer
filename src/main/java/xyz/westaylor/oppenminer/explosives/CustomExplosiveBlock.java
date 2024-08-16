package xyz.westaylor.oppenminer.explosives;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class CustomExplosiveBlock extends Block {
    private final float explosionPower;
    private final boolean setsFire;
    private final boolean radioactive;

    public CustomExplosiveBlock(float explosionPower, boolean setsFire, boolean radioactive) {
        super(Properties.of()
                .strength(3.5F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL));
        this.explosionPower = explosionPower;
        this.setsFire = setsFire;
        this.radioactive = radioactive;
    }

    public void placeBomb(Level level, BlockPos pos, Player player, int fuseTicks) {
        CustomExplosiveEntity explosive = new CustomExplosiveEntity(level, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, player);
        explosive.setFuse(fuseTicks);
        explosive.setExplosionPower(explosionPower);
        explosive.setSetsFire(setsFire);
        explosive.setRadioactive(radioactive);
        level.addFreshEntity(explosive);
    }

    public void placeBomb(Level level, BlockPos pos, Player player, double xOff, double yOff, double zOff) {
        CustomExplosiveEntity explosive = new CustomExplosiveEntity(level, (double)pos.getX() + 0.5D + xOff, (double)pos.getY() + yOff, (double)pos.getZ() + 0.5D + zOff, player);
        explosive.setFuse(20);
        explosive.setExplosionPower(explosionPower);
        explosive.setSetsFire(setsFire);
        explosive.setRadioactive(radioactive);
        level.addFreshEntity(explosive);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide) {
            placeBomb(level, pos, player, 0.0, 0.0, 0.0);

            // Delete this block (p_46955 = drop item?)
            level.destroyBlock(pos, false, player);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
