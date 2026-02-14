package net.mustacheodr4t.lepton.entities;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mustacheodr4t.lepton.Lepton;
import net.mustacheodr4t.lepton.entities.custom.*;

public class ModEntities {
        public static final DeferredRegister<EntityType<?>> ENTITIES =
                DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Lepton.MODID);

        public static final RegistryObject<EntityType<FishyWaterPotionEntity>>
                fishyWaterPotion = ENTITIES.register("fishywaterpotion",
                        () -> EntityType.Builder.<FishyWaterPotionEntity>of(
                                        FishyWaterPotionEntity::new,
                                        MobCategory.MISC
                                )
                                .sized(0.08F, 0.15F)
                                .clientTrackingRange(4)
                                .updateInterval(18)
                                .build(
                                        ResourceKey.create
                                                (Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Lepton.MODID, "fishywaterpotion"))
                                )
        );

        public static final RegistryObject<EntityType<CatnipPotionEntity>>
            catnipPotionEntity = ENTITIES.register("catnippotionentity",
            () -> EntityType.Builder.<CatnipPotionEntity>of(
                            CatnipPotionEntity::new,
                            MobCategory.MISC
                    )
                    .sized(0.08F, 0.15F)
                    .updateInterval(18)
                    .build(
                            ResourceKey.create
                                    (Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Lepton.MODID, "catnippotionentity"))
                    )
                 );

    public static final RegistryObject<EntityType<LuckPotionEntity>>
            luckPotionEntity = ENTITIES.register("luckpotionentity",
            () -> EntityType.Builder.<LuckPotionEntity>of(
                            LuckPotionEntity::new,
                            MobCategory.MISC
                    )
                    .sized(0.08F, 0.15F)
                    .clientTrackingRange(4)
                    .updateInterval(18)
                    .build(
                            ResourceKey.create
                                    (Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Lepton.MODID, "luckpotionentity"))
                    )
    );

    public static final RegistryObject<EntityType<LesserLuckPotionEntity>>
            lesserLuckPotionEntity = ENTITIES.register("lesserluckpotionentity",
            () -> EntityType.Builder.<LesserLuckPotionEntity>of(
                            LesserLuckPotionEntity::new,
                            MobCategory.MISC
                    )
                    .sized(0.08F, 0.15F)
                    .clientTrackingRange(4)
                    .updateInterval(18)
                    .build(
                            ResourceKey.create
                                    (Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Lepton.MODID, "lesserluckpotionentity"))
                    )
    );


    public static final RegistryObject<EntityType<GreaterLuckPotionEntity>>
            greaterLuckPotionEntity = ENTITIES.register("greaterluckpotionentity",
            () -> EntityType.Builder.<GreaterLuckPotionEntity>of(
                            GreaterLuckPotionEntity::new,
                            MobCategory.MISC
                    )
                    .sized(0.08F, 0.15F)
                    .clientTrackingRange(4)
                    .updateInterval(18)
                    .build(
                            ResourceKey.create
                            (Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Lepton.MODID, "greaterluckpotionentity"))
                    )
    );


    public static void register(BusGroup modEventBus) {
            ENTITIES.register(modEventBus);
        }
}