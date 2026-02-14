package net.mustacheodr4t.lepton;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mustacheodr4t.lepton.client.ModCreativeTabs;
import net.mustacheodr4t.lepton.config.LeptonConfig;
import net.mustacheodr4t.lepton.effects.ModEffects;
import net.mustacheodr4t.lepton.entities.ModEntities;
import net.mustacheodr4t.lepton.items.ModItems;

@Mod(Lepton.MODID)
public class Lepton {
    public static final String MODID = "lepton";

    public Lepton(FMLJavaModLoadingContext context) {

        var modBusGroup = context.getModBusGroup();

        ModItems.ITEMS.register(modBusGroup);
        ModEffects.EFFECTS.register(modBusGroup);
        ModEntities.ENTITIES.register(modBusGroup);
        ModCreativeTabs.TABS.register(modBusGroup);

        context.registerConfig(
                ModConfig.Type.COMMON,
                LeptonConfig.COMMON_SPEC
        );
        context.registerConfig(
                ModConfig.Type.SERVER,
                LeptonConfig.SERVER_SPEC
        );

        }
}