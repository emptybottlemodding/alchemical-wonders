package com.emptybottlemods.alchemicalwonders.blocks;

import com.emptybottlemods.alchemicalwonders.registry.AWBlocks;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class FiredampBlock extends AirBlock
{
    public FiredampBlock(Settings settings) {
        super(Settings.of(AWBlocks.FIREDAMP_MATERIAL).nonOpaque());
        setDefaultState(getStateManager().getDefaultState().with(IGNITED, false));
    }

    public static final BooleanProperty IGNITED = BooleanProperty.of("ignited");

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(IGNITED);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify)
    {
        if (!world.getBlockState(pos).get(IGNITED))
        {
            Direction direction;
            for (Direction i : DIRECTIONS)
            {
                BlockState blockState = world.getBlockState(pos.offset(i));
                if (blockState.getBlock() instanceof TorchBlock)
                {
                    world.setBlockState(pos, state.with(IGNITED, true));
                    this.neighborUpdate(state, world, pos, block, fromPos, notify);
                }
                if (blockState.contains(IGNITED))
                {
                    if (blockState.get(IGNITED)) {
                        world.setBlockState(pos, state.with(IGNITED, true));
                        this.neighborUpdate(state, world, pos, block, fromPos, notify);
                    }
                }
            }
        } else {

            world.removeBlock(pos,false);
        }
    }
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {

    }

}
