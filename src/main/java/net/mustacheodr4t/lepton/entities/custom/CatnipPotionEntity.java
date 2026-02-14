package net.mustacheodr4t.lepton.entities.custom;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.mustacheodr4t.lepton.effects.ModEffects;
import net.mustacheodr4t.lepton.entities.ModEntities;
import net.mustacheodr4t.lepton.entities.base.ThrowableEntityBase;
import net.mustacheodr4t.lepton.items.ModItems;

public class CatnipPotionEntity extends ThrowableEntityBase {
    public CatnipPotionEntity(Level level, LivingEntity owner) {
        super(ModEntities.catnipPotionEntity.get(), owner, level);
    }

    public CatnipPotionEntity(EntityType<? extends CatnipPotionEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.splashCatnipPotion.get();
    }

    @Override
    protected void applyEffect(AABB area) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
            if (living instanceof Player player) {
                player.addEffect(new MobEffectInstance(
                        ModEffects.catnipEffect.getHolder().get(), 900
                ));
            }
        }
    }

    @Override
    protected int potionColor() {
        return 0xFBB701;
    }
}