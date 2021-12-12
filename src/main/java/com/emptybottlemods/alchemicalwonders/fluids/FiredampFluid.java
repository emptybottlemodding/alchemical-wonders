package com.emptybottlemods.alchemicalwonders.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import static com.emptybottlemods.alchemicalwonders.registry.AWBlocks.FIREDAMP_FLUID_BLOCK;
import static com.emptybottlemods.alchemicalwonders.registry.AWFluids.*;

public abstract class FiredampFluid extends FlowableFluid {

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    public Fluid getFlowing() {
        return FLOWING_FIREDAMP;
    }

    @Override
    public Fluid getStill() {
        return STILL_FIREDAMP;
    }

    @Override
    protected boolean isInfinite() {
        return true;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.hasBlockEntity()) {
            final BlockEntity blockEntity = world.getBlockEntity(pos);
            Block.dropStacks(state, world, pos, blockEntity);
        }
    }


    @Override
    protected int getFlowSpeed(WorldView world) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public Item getBucketItem() {
        return FIREDAMP_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return !matchesType(fluid);
    }

    @Override
    public int getTickRate(WorldView world) {
        return 10;
    }

    @Override
    protected float getBlastResistance() {
        return 0;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return FIREDAMP_FLUID_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    public static class Flowing extends FiredampFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }

    public static class Still extends FiredampFluid {
        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }
}
