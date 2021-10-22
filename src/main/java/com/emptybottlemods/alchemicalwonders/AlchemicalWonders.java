package com.emptybottlemods.alchemicalwonders;

import com.emptybottlemods.alchemicalwonders.registry.AWBlocks;
import com.emptybottlemods.alchemicalwonders.registry.AWItems;
import net.fabricmc.api.ModInitializer;

public class AlchemicalWonders implements ModInitializer {
    public static String MODID = "alchemicalwonders";
    @Override
    public void onInitialize()
    {
        AWItems.init();
        AWBlocks.init();
    }
}
