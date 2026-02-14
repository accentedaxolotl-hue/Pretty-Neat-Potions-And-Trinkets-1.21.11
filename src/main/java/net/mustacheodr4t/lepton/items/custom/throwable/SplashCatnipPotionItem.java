package net.mustacheodr4t.lepton.items.custom.throwable;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.mustacheodr4t.lepton.entities.custom.CatnipPotionEntity;
import net.mustacheodr4t.lepton.items.base.ThrowableBase;

public class SplashCatnipPotionItem extends ThrowableBase {
    public SplashCatnipPotionItem(Properties properties) {
        super(properties);
    }

    @Override
    protected ThrowableItemProjectile createProjectile(Level level, Player player) {
        return new CatnipPotionEntity(level, player);
    }
}