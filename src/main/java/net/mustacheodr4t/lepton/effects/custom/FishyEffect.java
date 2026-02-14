package net.mustacheodr4t.lepton.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FishyEffect extends MobEffect {
    public FishyEffect() {
        super(MobEffectCategory.HARMFUL, 0x3FA7D6);
    }

    @Override
    public void onEffectAdded(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) return;

        if (entity instanceof Player player) {
            dizzyEffect(player);
        }
    }

    private void dizzyEffect(Player player){
        {
                player.addEffect(new MobEffectInstance(MobEffects.POISON, 260));
        }
    }
}