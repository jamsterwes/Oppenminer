package xyz.westaylor.oppenminer.missiles;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.westaylor.oppenminer.explosives.CustomExplosiveBlock;

public class MissileItem extends Item {
    private CustomExplosiveBlock explosive;

    public MissileItem(CustomExplosiveBlock explosive, Item.Properties props) {
        super(props.stacksTo(1));
        this.explosive = explosive;
    }

    // Throw
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        // Get held missile ItemStack
        ItemStack itemStack = user.getItemInHand(hand);

        // Spawn missile entity
        MissileEntity missile = new MissileEntity(world, user, explosive);
        // user, Xrot, Yrot, Zrot, speed, inaccuracy
        missile.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 5.0F, 0.0F);
        world.addFreshEntity(missile);

        // Consume missile
        return InteractionResultHolder.consume(itemStack);
    }
}
