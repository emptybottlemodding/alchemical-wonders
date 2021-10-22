package com.emptybottlemods.alchemicalwonders.blocks;

import com.emptybottlemods.alchemicalwonders.registry.AWBlocks;
import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

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
            BlockState downstate = world.getBlockState(pos.down());
            BlockState eaststate = world.getBlockState(pos.east());
            BlockState weststate = world.getBlockState(pos.west());
            BlockState northstate = world.getBlockState(pos.north());
            BlockState southstate = world.getBlockState(pos.south());
            BlockState upstate = world.getBlockState(pos.up());

            if (northstate.getBlock() instanceof TorchBlock)
            {
                world.setBlockState(pos, state.with(IGNITED, true));
                this.neighborUpdate(state, world, pos, block, fromPos, notify);
            } else
            {
                if (eaststate.getBlock() instanceof TorchBlock)
                {
                    world.setBlockState(pos, state.with(IGNITED, true));
                    this.neighborUpdate(state, world, pos, block, fromPos, notify);
                } else
                {
                    if (weststate.getBlock() instanceof TorchBlock)
                    {
                        world.setBlockState(pos, state.with(IGNITED, true));
                        this.neighborUpdate(state, world, pos, block, fromPos, notify);
                    } else
                    {
                        if (downstate.getBlock() instanceof TorchBlock)
                        {
                            world.setBlockState(pos, state.with(IGNITED, true));
                            this.neighborUpdate(state, world, pos, block, fromPos, notify);
                        } else
                        {
                            if (southstate.getBlock() instanceof TorchBlock)
                            {
                                world.setBlockState(pos, state.with(IGNITED, true));
                                this.neighborUpdate(state, world, pos, block, fromPos, notify);
                            } else
                            {
                                if (upstate.getBlock() instanceof TorchBlock)
                                {
                                    world.setBlockState(pos, state.with(IGNITED, true));
                                    this.neighborUpdate(state, world, pos, block, fromPos, notify);
                                }
                            }
                        }
                    }
                }
            }

            //Ignited Firedamp

            if (northstate.contains(IGNITED))
            {
                if (northstate.get(IGNITED)) {
                    world.setBlockState(pos, state.with(IGNITED, true));
                    this.neighborUpdate(state, world, pos, block, fromPos, notify);
                }
            } else
            {
                if (eaststate.contains(IGNITED))
                {
                    if (eaststate.get(IGNITED)) {
                        world.setBlockState(pos, state.with(IGNITED, true));
                        this.neighborUpdate(state, world, pos, block, fromPos, notify);
                    }
                } else
                {
                    if (weststate.contains(IGNITED))
                    {
                        if (weststate.get(IGNITED)) {
                            world.setBlockState(pos, state.with(IGNITED, true));
                            this.neighborUpdate(state, world, pos, block, fromPos, notify);
                        }
                    } else
                    {
                        if (downstate.contains(IGNITED))
                        {
                            if (downstate.get(IGNITED)) {
                                world.setBlockState(pos, state.with(IGNITED, true));
                                this.neighborUpdate(state, world, pos, block, fromPos, notify);
                            }
                        } else
                        {
                            if (southstate.contains(IGNITED))
                            {
                                if (southstate.get(IGNITED)) {
                                    world.setBlockState(pos, state.with(IGNITED, true));
                                    this.neighborUpdate(state, world, pos, block, fromPos, notify);
                                }
                            } else
                            {
                                if (upstate.contains(IGNITED)) {
                                    if (upstate.get(IGNITED)) {
                                        world.setBlockState(pos, state.with(IGNITED, true));
                                        this.neighborUpdate(state, world, pos, block, fromPos, notify);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}
