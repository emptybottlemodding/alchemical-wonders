package com.emptybottlemods.alchemicalwonders;

import com.emptybottlemods.alchemicalwonders.registry.AWBlocks;
import com.emptybottlemods.alchemicalwonders.registry.AWFluids;
import com.emptybottlemods.alchemicalwonders.registry.AWItems;
import net.fabricmc.api.ModInitializer;

public class AlchemicalWonders implements ModInitializer {
    public static String MODID = "alchemicalwonders";
    public static final String MODID_ALT = MODID + "_alt";

    @Override
    public void onInitialize()
    {
        AWItems.init();
        AWFluids.init();
        AWBlocks.init();
    }
}
