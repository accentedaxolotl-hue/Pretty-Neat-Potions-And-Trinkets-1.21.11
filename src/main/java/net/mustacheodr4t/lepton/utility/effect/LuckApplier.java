package net.mustacheodr4t.lepton.utility.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public final class LuckApplier {
    private LuckApplier() {}

    public static void apply(Player player, LuckTier tier) {
        player.addEffect(new MobEffectInstance(
                MobEffects.LUCK,
                tier.duration.getAsInt(),
                tier.amplifier
        ));
    }

    public static void applySplash(Player player, LuckEntityTier tier) {
        player.addEffect(new MobEffectInstance(
                MobEffects.LUCK,
                tier.duration.getAsInt(),
                tier.amplifier
        ));
    }
}