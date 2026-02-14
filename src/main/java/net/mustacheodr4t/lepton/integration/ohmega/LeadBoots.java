package net.mustacheodr4t.lepton.integration.ohmega;

import com.swacky.ohmega.api.IAccessory;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.mustacheodr4t.lepton.config.LeptonConfig;
import net.mustacheodr4t.lepton.utility.helper.TooltipHelper;

import java.util.function.Consumer;

public class LeadBoots extends Item implements IAccessory {

    public LeadBoots(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            Item.TooltipContext context,
            TooltipDisplay display,
            Consumer<Component> tooltip,
            TooltipFlag flag
    ) {
        TooltipHelper.addTooltip(stack, context, display, tooltip, flag);
    }

    private int checkInterval() { return LeptonConfig.COMMON.trinket_check_interval.get();
    }

    private boolean hasTNT(Player player) {
        for (ItemStack stack : player.getInventory()) {
            if (stack.is(Items.TNT)) {
                return true;
            }
        }
        return false;
    }

    private boolean consumeTNT(Player player, int amount) {
        for (ItemStack stack : player.getInventory()) {
            if (stack.is(Items.TNT) && stack.getCount() >= amount) {
                stack.shrink(amount);
                return true;
            }
        }
        return false;
    }

    private void spawnExplosionEffects(Player player) {
        if (!player.level().isClientSide()){

            if (player.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(
                        ParticleTypes.EXPLOSION_EMITTER,
                        player.getX(),
                        player.getY() + 0.5,
                        player.getZ(),
                        1,
                        0, 0, 0, 0
                );
            }

        player.level().playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.GENERIC_EXPLODE,
                SoundSource.PLAYERS,
                0.8F,
                1.2F
        );

        player.setDeltaMovement(
                player.getDeltaMovement().add(0, 1.0, 0)
        );

        player.hurtMarked = true;
    }
    }

    @Override
    public void tick(Player player, ItemStack stack) {

        if (player.level().isClientSide()) return;

        if (!player.hasEffect(MobEffects.SLOWNESS)) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.SLOWNESS,
                    5000,
                    0,
                    true,
                    false
            ));
        }

        if (hasTNT(player) && (!(player.hasEffect(MobEffects.JUMP_BOOST)))) {

            spawnExplosionEffects(player);

            player.addEffect(new MobEffectInstance(
                    MobEffects.JUMP_BOOST,
                    900,
                    4,
                    true,
                    false
            ));

            if (player.tickCount % checkInterval() == 0){ consumeTNT(player, 1); }
        }
    }

    @Override
    public boolean canEquip(Player player, ItemStack stack) {
        return true;
    }
}