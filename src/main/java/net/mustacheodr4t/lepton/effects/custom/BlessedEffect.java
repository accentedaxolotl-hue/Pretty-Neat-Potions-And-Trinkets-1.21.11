package net.mustacheodr4t.lepton.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.mustacheodr4t.lepton.effects.ModEffects;

public class BlessedEffect extends MobEffect {
    public BlessedEffect() { super(MobEffectCategory.BENEFICIAL, 0xFBB703);
        }

    @Override
    public void onEffectAdded(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) return;

        if (entity instanceof Player player) {
            blessedEffect(player);
        }
    }

    private void blessedEffect(Player player){
        {
            if (player.hasEffect(MobEffects.WEAKNESS)) return;
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1));
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600));
        }
    }
}