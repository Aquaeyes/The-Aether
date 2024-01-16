package com.aetherteam.aether.api;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.api.registers.MoaType;
import com.aetherteam.aether.item.AetherItems;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AetherMoaTypes {
    public static final ResourceKey<Registry<MoaType>> MOA_TYPE_REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(Aether.MODID, "moa_type"));
    public static final LazyRegistrar<MoaType> MOA_TYPES = LazyRegistrar.create(MOA_TYPE_REGISTRY_KEY, Aether.MODID);
    public static final Registry<MoaType> MOA_TYPE_REGISTRY = FabricRegistryBuilder.createSimple(MOA_TYPE_REGISTRY_KEY).buildAndRegister();

    public static final RegistryObject<MoaType> BLUE = MOA_TYPES.register("blue", () -> new MoaType(new MoaType.Properties().egg(AetherItems.BLUE_MOA_EGG).maxJumps(3).speed(0.155F).spawnChance(100).texture("textures/entity/mobs/moa/blue_moa.png")));
    public static final RegistryObject<MoaType> WHITE = MOA_TYPES.register("white", () -> new MoaType(new MoaType.Properties().egg(AetherItems.WHITE_MOA_EGG).maxJumps(4).speed(0.155F).spawnChance(50).texture("textures/entity/mobs/moa/white_moa.png")));
    public static final RegistryObject<MoaType> BLACK = MOA_TYPES.register("black", () -> new MoaType(new MoaType.Properties().egg(AetherItems.BLACK_MOA_EGG).maxJumps(8).speed(0.155F).spawnChance(25).texture("textures/entity/mobs/moa/black_moa.png").saddleTexture("textures/entity/mobs/moa/black_moa_saddle.png")));

    @Nullable
    public static MoaType get(String id) {
        return MOA_TYPE_REGISTRY.get(new ResourceLocation(id));
    }

    /**
     * Gets a random {@link MoaType} with a weighted chance. This is used when spawning Moas in the world.<br>
     * A {@link SimpleWeightedRandomList} is built with all the {@link MoaType}s and their spawn chance weights, and one is randomly picked out of the list.
     * @param random The {@link RandomSource} to use.
     * @return The {@link MoaType}.
     */
    public static MoaType getWeightedChance(RandomSource random) {
        SimpleWeightedRandomList.Builder<MoaType> weightedListBuilder = SimpleWeightedRandomList.builder();
        MOA_TYPE_REGISTRY.forEach((moaType) -> weightedListBuilder.add(moaType, moaType.getSpawnChance()));
        SimpleWeightedRandomList<MoaType> weightedList = weightedListBuilder.build();
        Optional<MoaType> moaType = weightedList.getRandomValue(random);
        return moaType.orElseGet(BLUE);
    }
}
