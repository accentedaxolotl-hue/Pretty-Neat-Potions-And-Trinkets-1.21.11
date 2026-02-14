package net.mustacheodr4t.lepton.entities.base;

import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;

public abstract class ThrowableEntityBase extends ThrowableItemProjectile {
    protected ThrowableEntityBase(
            EntityType<? extends ThrowableItemProjectile> type,
            Level level
    ) {
        super(type, level);
    }

    protected ThrowableEntityBase(
            EntityType<? extends ThrowableItemProjectile> type,
            LivingEntity owner,
            Level level
    ) {
        super(type, level);
        this.setOwner(owner);
    }

        @Override
    protected double getDefaultGravity() {
        return 0.13F;
    }

    @Override
    public void tick() {
        super.tick();
        this.setDeltaMovement(
                this.getDeltaMovement().multiply(0.95D, 0.95D, 0.95D)
        );
    }

    @Override
    protected void onHit(HitResult result) {
        if (!this.level().isClientSide()){

        AABB area = this.getBoundingBox().inflate(1.0D);
        applyEffect(area);

        this.level().playSound(
                null,
                this.getX(),
                this.getY(),
                this.getZ(),
                SoundEvents.SPLASH_POTION_BREAK,
                SoundSource.PLAYERS,
                1.0F,
                1.0F
        );

             if (level() instanceof ServerLevel serverLevel) {
                 serverLevel.sendParticles(
                     ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, potionColor()),
                     false,
                     false,
                     this.getX(),
                     this.getY(),
                     this.getZ(),
                     30,
                     0.2D,
                     0.2D,
                     0.2D,
                     0.2D
             );
             }
         }
        this.discard();
    }

    protected abstract void applyEffect(AABB area);
    protected abstract int potionColor();
}