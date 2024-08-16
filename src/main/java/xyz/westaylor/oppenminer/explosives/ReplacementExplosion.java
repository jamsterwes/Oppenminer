package xyz.westaylor.oppenminer.explosives;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import com.google.common.collect.Lists;

import java.util.List;

public class ReplacementExplosion {

    private static boolean canReplace(BlockState state, float replacementChance) {
        return !state.isAir() && !state.is(Blocks.LAVA) && !state.is(Blocks.WATER) && Math.random() <= replacementChance;
    }

    private static boolean canRemove(BlockState state, float testRadiusSquared, float radius, float removeChanceLastTwo) {
        boolean isLastTwoLayers = Math.sqrt(testRadiusSquared) > (radius - 2.0f);
        double removeChance = isLastTwoLayers ? removeChanceLastTwo : 1.0f;
        return !state.isAir() && !state.is(Blocks.BEDROCK) && !state.is(Blocks.WATER) && !state.is(Blocks.LAVA) && Math.random() <= removeChance;
    }

    public static void explode(Vec3i center, int radius, ServerLevel world, BlockState replacementBlock, float replacementChance) {
        float radiusSquared = radius * radius;

        // Define the bounding box for the explosion area
        BoundingBox boundingBox = new BoundingBox(
                -radius + center.getX(), -radius + center.getY(), -radius + center.getZ(),
                radius + center.getX(), radius + center.getY(), radius + center.getZ()
        );

        // List to track positions where blocks are modified
        List<BlockPos> modifiedBlocks = Lists.newArrayList();

        // Iterate through each block position within the bounding box
        for (BlockPos pos : BlockPos.betweenClosed(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(),
                boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ())) {
            // Calculate the squared distance from the center
            Vec3i offset = pos.subtract(center);
            float testRadiusSquared = offset.getX() * offset.getX() + offset.getY() * offset.getY() + offset.getZ() * offset.getZ();

            // If the position is within the explosion radius
            if (testRadiusSquared <= radiusSquared) {
                if (canRemove(world.getBlockState(pos), testRadiusSquared, radius, 0.95F)) {
                    if (replacementBlock == null || !canReplace(world.getBlockState(pos), replacementChance)) {
                        // Delete the block
                        world.removeBlock(pos, false);
                    } else {
                        // Replace the block with the new block state
                        world.removeBlock(pos, false);
                        world.setBlock(pos, replacementBlock, 0);
                    }

                    // Track modified block positions
                    modifiedBlocks.add(pos.immutable());
                }
            }
        }

        // Update blocks in a batch to trigger neighbor updates efficiently
        for (BlockPos blockPos : modifiedBlocks) {
            Block block = world.getBlockState(blockPos).getBlock();
            world.blockUpdated(blockPos, block);
        }
    }
}