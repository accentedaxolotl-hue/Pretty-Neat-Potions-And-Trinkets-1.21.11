package net.mustacheodr4t.lepton.integration.ohmega;

import com.swacky.ohmega.api.IAccessory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.phys.Vec3;
import net.mustacheodr4t.lepton.utility.helper.TooltipHelper;

import java.util.function.Consumer;

public class ChainedSteelBallItem extends Item implements IAccessory {

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

    public ChainedSteelBallItem(Properties properties) { super(properties); }

    @Override
    public void tick(Player player, ItemStack stack) {

        if (player.getAbilities().flying) return;

        Vec3 motion = player.getDeltaMovement();
        double gravity = -0.08D;
        double maxFallSpeed = -0.3D;
        double newY = Math.max(motion.y + gravity, maxFallSpeed);

        if (!(player.onGround())) {
            player.setDeltaMovement(
                    motion.x,
                    newY,
                    motion.z
            );

            player.fallDistance += 0.05F;
        }
        if (!player.hasEffect(MobEffects.RESISTANCE)) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.RESISTANCE,
                    30,
                    1,
                    true,
                    false
            ));
        }
    }

    @Override public boolean canEquip(Player player, ItemStack stack) { return true; }
    }