package net.mustacheodr4t.lepton.items.custom.drinkable;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.mustacheodr4t.lepton.items.base.PotionBase;
import net.mustacheodr4t.lepton.utility.effect.LuckApplier;
import net.mustacheodr4t.lepton.utility.effect.LuckTier;

public class GreaterLuckPotionItem extends PotionBase {
    public GreaterLuckPotionItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Player player, Level level) {
        LuckApplier.apply(player, LuckTier.GREATER);
    }
}