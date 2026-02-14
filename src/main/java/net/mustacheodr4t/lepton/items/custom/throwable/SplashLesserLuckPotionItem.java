package net.mustacheodr4t.lepton.items.custom.throwable;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.mustacheodr4t.lepton.entities.custom.LesserLuckPotionEntity;
import net.mustacheodr4t.lepton.items.base.ThrowableBase;

public class SplashLesserLuckPotionItem extends ThrowableBase {
    public SplashLesserLuckPotionItem(Properties properties) { super(properties); }

    @Override
    protected ThrowableItemProjectile createProjectile(Level level, Player player) {
        return new LesserLuckPotionEntity(level, player);
    }
}