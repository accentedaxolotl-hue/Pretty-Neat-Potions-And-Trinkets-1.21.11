package net.mustacheodr4t.lepton.items.base;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public abstract class ThrowableBase extends Item {
    protected ThrowableBase(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            ThrowableItemProjectile entity = createProjectile(level, player);

            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.SPLASH_POTION_THROW,
                    SoundSource.PLAYERS,
                    0.5F,
                    0.8F + level.random.nextFloat() * 0.4F
            );

            entity.setItem(stack);

            entity.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot(),
                    0.0F,
                    1.5F,
                    1.0F
            );

            level.addFreshEntity(entity);
        }

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResult.SUCCESS;
    }
    protected abstract ThrowableItemProjectile createProjectile(Level level, Player player);
}