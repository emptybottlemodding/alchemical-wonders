package com.emptybottlemods.alchemicalwonders.client;

import com.emptybottlemods.alchemicalwonders.registry.AWBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class AlchemicalWondersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(AWBlocks.FIREDAMP, RenderLayer.getTranslucent());
    }
}
