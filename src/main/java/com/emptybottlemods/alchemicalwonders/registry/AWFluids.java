package com.emptybottlemods.alchemicalwonders.registry;

import com.emptybottlemods.alchemicalwonders.fluids.FiredampFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.emptybottlemods.alchemicalwonders.AlchemicalWonders.MODID;

public class AWFluids {

    public static FlowableFluid STILL_FIREDAMP;
    public static FlowableFluid FLOWING_FIREDAMP;
    public static BucketItem FIREDAMP_BUCKET;

    public static void init () {
        STILL_FIREDAMP = Registry.register(Registry.FLUID, new Identifier(MODID, "firedamp"), new FiredampFluid.Still());
        FLOWING_FIREDAMP = Registry.register(Registry.FLUID, new Identifier(MODID, "flowing_firedamp"), new FiredampFluid.Flowing());
        FIREDAMP_BUCKET = Registry.register(Registry.ITEM, new Identifier(MODID, "firedamp_bucket"),
                new BucketItem(STILL_FIREDAMP, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
