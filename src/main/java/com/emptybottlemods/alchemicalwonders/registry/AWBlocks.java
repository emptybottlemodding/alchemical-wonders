package com.emptybottlemods.alchemicalwonders.registry;

import com.emptybottlemods.alchemicalwonders.AlchemicalWonders;
import com.emptybottlemods.alchemicalwonders.blocks.FiredampBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AWBlocks
{
    public static final Material FIREDAMP_MATERIAL = (new Material.Builder(MapColor.CLEAR)).allowsMovement().notSolid().replaceable().liquid().build();
    public static final FiredampBlock FIREDAMP = new FiredampBlock(FabricBlockSettings.of(FIREDAMP_MATERIAL).strength(100000f));
    public static void init()
    {
        Registry.register(Registry.BLOCK, new Identifier(AlchemicalWonders.MODID, "firedamp"), FIREDAMP);
        Registry.register(Registry.ITEM, new Identifier(AlchemicalWonders.MODID, "firedamp"), new BlockItem(FIREDAMP, new FabricItemSettings().group(ItemGroup.MISC)));
    }
}
