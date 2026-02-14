package net.mustacheodr4t.lepton.entities.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.mustacheodr4t.lepton.entities.ModEntities;
import net.mustacheodr4t.lepton.entities.base.ThrowableEntityBase;
import net.mustacheodr4t.lepton.items.ModItems;
import net.mustacheodr4t.lepton.utility.effect.LuckApplier;
import net.mustacheodr4t.lepton.utility.effect.LuckEntityTier;

public class GreaterLuckPotionEntity extends ThrowableEntityBase {
    public GreaterLuckPotionEntity(Level level, LivingEntity owner) {
        super(ModEntities.greaterLuckPotionEntity.get(), owner, level);
    }

    public GreaterLuckPotionEntity(EntityType<? extends GreaterLuckPotionEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.splashGreaterLuckPotion.get();
    }

    @Override
    protected void applyEffect(AABB area) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
            if (living instanceof Player player) {
                LuckApplier.applySplash(player, LuckEntityTier.GREATER_SPLASH);
            }
        }
    }

    @Override
    protected int potionColor() {
        return 0x59C106;
    }
}