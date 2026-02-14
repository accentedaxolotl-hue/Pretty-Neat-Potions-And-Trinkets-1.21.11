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

public class LuckPotionEntity extends ThrowableEntityBase {
    public LuckPotionEntity(Level level, LivingEntity owner) {
        super(ModEntities.luckPotionEntity.get(), owner, level);
    }

    public LuckPotionEntity(EntityType<? extends LuckPotionEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.splashLuckPotion.get();
    }

    @Override
    protected void applyEffect(AABB area) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
            if (living instanceof Player player) {
                LuckApplier.applySplash(player, LuckEntityTier.NORMAL_SPLASH);
            }
        }
    }

    @Override
    protected int potionColor() {
        return 0x59C106;
    }
}