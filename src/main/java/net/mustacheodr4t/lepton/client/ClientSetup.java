package net.mustacheodr4t.lepton.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mustacheodr4t.lepton.Lepton;
import net.mustacheodr4t.lepton.entities.ModEntities;

@Mod.EventBusSubscriber(
        modid = Lepton.MODID,
        value = Dist.CLIENT
)
public class ClientSetup {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        EntityRenderers.register(
                ModEntities.fishyWaterPotion.get(),
                ThrownItemRenderer::new
        );

        EntityRenderers.register(
                ModEntities.lesserLuckPotionEntity.get(),
                ThrownItemRenderer::new
        );
        EntityRenderers.register(
                ModEntities.greaterLuckPotionEntity.get(),
                ThrownItemRenderer::new
        );
        EntityRenderers.register(
                ModEntities.luckPotionEntity.get(),
                ThrownItemRenderer::new
        );
        EntityRenderers.register(
                ModEntities.catnipPotionEntity.get(),
                ThrownItemRenderer::new
        );
    }
}