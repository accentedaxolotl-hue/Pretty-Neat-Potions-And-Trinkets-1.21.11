package net.mustacheodr4t.lepton.items.custom.drinkable;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.mustacheodr4t.lepton.effects.ModEffects;
import net.mustacheodr4t.lepton.items.base.PotionBase;

public class BlessedPotionItem extends PotionBase {
    public BlessedPotionItem(Properties properties) { super(properties); }

    @Override
    protected void applyEffect(Player player, Level level) {
        player.addEffect(
                new MobEffectInstance(ModEffects.blessedEffect.getHolder().get(), 1800)
        );
    }
}