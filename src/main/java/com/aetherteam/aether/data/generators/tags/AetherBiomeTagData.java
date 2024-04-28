package com.aetherteam.aether.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

public class AetherBiomeTagData extends FabricTagProvider<Biome> {
    public AetherBiomeTagData(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Registries.BIOME, registries);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(AetherTags.Biomes.IS_AETHER).add(
                AetherBiomes.SKYROOT_MEADOW,
                AetherBiomes.SKYROOT_GROVE,
                AetherBiomes.SKYROOT_WOODLAND,
                AetherBiomes.SKYROOT_FOREST
        );
        this.tag(AetherTags.Biomes.HAS_LARGE_AERCLOUD).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.HAS_BRONZE_DUNGEON).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.HAS_SILVER_DUNGEON).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.HAS_GOLD_DUNGEON).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.HAS_RUINED_PORTAL_STANDARD).add(
                Biomes.FOREST,
                Biomes.SNOWY_TAIGA,
                Biomes.MUSHROOM_FIELDS,
                Biomes.SNOWY_PLAINS,
                Biomes.PLAINS);
        this.tag(AetherTags.Biomes.HAS_RUINED_PORTAL_DESERT).add(Biomes.DESERT);
        this.tag(AetherTags.Biomes.HAS_RUINED_PORTAL_JUNGLE).add(Biomes.JUNGLE);
        this.tag(AetherTags.Biomes.HAS_RUINED_PORTAL_SWAMP).add(Biomes.SWAMP);
        this.tag(AetherTags.Biomes.HAS_RUINED_PORTAL_MOUNTAIN).add(
                Biomes.WINDSWEPT_HILLS,
                Biomes.STONY_PEAKS);
        this.tag(AetherTags.Biomes.HAS_RUINED_PORTAL_AETHER).addTag(AetherTags.Biomes.IS_AETHER);

        this.tag(AetherTags.Biomes.MYCELIUM_CONVERSION).add(Biomes.MUSHROOM_FIELDS);
        this.tag(AetherTags.Biomes.PODZOL_CONVERSION).add(
                Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.BAMBOO_JUNGLE);
        this.tag(AetherTags.Biomes.CRIMSON_NYLIUM_CONVERSION).add(Biomes.CRIMSON_FOREST);
        this.tag(AetherTags.Biomes.WARPED_NYLIUM_CONVERSION).add(Biomes.WARPED_FOREST);

        this.tag(AetherTags.Biomes.ULTRACOLD).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.NO_WHEAT_SEEDS).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.FALL_TO_OVERWORLD).addTag(AetherTags.Biomes.IS_AETHER);
        this.tag(AetherTags.Biomes.DISPLAY_TRAVEL_TEXT).addTag(AetherTags.Biomes.IS_AETHER).forceAddTag(BiomeTags.IS_OVERWORLD).add(Biomes.THE_VOID);
        this.tag(AetherTags.Biomes.AETHER_MUSIC).addTag(AetherTags.Biomes.IS_AETHER);

        this.tag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).addTag(AetherTags.Biomes.IS_AETHER);
    }

    @Override
    protected FabricTagProvider<Biome>.FabricTagBuilder tag(TagKey<Biome> tag) {
        return getOrCreateTagBuilder(tag);
    }
}
