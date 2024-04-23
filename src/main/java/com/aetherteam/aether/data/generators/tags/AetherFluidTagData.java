package com.aetherteam.aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluids;

import java.util.concurrent.CompletableFuture;

public class AetherFluidTagData extends FluidTagsProvider {
    public AetherFluidTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(AetherTags.Fluids.ALLOWED_BUCKET_PICKUP).add(
                Fluids.WATER,
                Fluids.FLOWING_WATER);
    }
}
