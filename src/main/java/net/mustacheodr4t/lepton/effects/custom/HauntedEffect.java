package net.mustacheodr4t.lepton.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.mustacheodr4t.lepton.effects.ModEffects;

public class HauntedEffect extends MobEffect {
    public HauntedEffect() { super(MobEffectCategory.HARMFUL, 0x000000);
        }

    @Override
    public void onEffectAdded(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) return;

        if (entity instanceof Player player) {
            hauntedEffect(player);
        }
    }

    private void hauntedEffect(Player player){
        {
            if (player.hasEffect(MobEffects.SLOWNESS)) return;
            player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 300, 1));
            player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 600));
        }
    }
}