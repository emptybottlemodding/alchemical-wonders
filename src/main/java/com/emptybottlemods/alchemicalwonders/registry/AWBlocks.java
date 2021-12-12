package com.emptybottlemods.alchemicalwonders.registry;

import com.emptybottlemods.alchemicalwonders.AlchemicalWonders;
import com.emptybottlemods.alchemicalwonders.blocks.FiredampBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.emptybottlemods.alchemicalwonders.AlchemicalWonders.MODID_ALT;
import static com.emptybottlemods.alchemicalwonders.registry.AWFluids.STILL_FIREDAMP;

public class AWBlocks
{
    public static final Material FIREDAMP_MATERIAL = (new Material.Builder(MapColor.CLEAR)).allowsMovement().notSolid().replaceable().liquid().build();
    public static final FiredampBlock FIREDAMP = new FiredampBlock(FabricBlockSettings.of(FIREDAMP_MATERIAL).strength(100000f));
    public static final FluidBlock FIREDAMP_FLUID_BLOCK = new FluidBlock(STILL_FIREDAMP, FabricBlockSettings.copy(Blocks.WATER)){};
    // duplicate of firedamp for resource comparisons
    public static final FiredampBlock FIREDAMP_ALT = new FiredampBlock(FabricBlockSettings.copy(FIREDAMP));
    public static void init()
    {
        Registry.register(Registry.BLOCK, new Identifier(AlchemicalWonders.MODID, "firedamp"), FIREDAMP);
        Registry.register(Registry.ITEM, new Identifier(AlchemicalWonders.MODID, "firedamp"), new BlockItem(FIREDAMP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier(MODID_ALT, "firedamp"), FIREDAMP_ALT);
        Registry.register(Registry.ITEM, new Identifier(MODID_ALT, "firedamp"), new BlockItem(FIREDAMP_ALT, new FabricItemSettings().group(ItemGroup.MISC)));
    }
}
