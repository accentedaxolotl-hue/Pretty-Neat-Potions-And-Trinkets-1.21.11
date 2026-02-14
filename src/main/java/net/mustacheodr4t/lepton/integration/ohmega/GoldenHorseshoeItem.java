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
import net.mustacheodr4t.lepton.utility.helper.TooltipHelper;

import java.util.function.Consumer;

public class GoldenHorseshoeItem extends Item implements IAccessory {

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

    public GoldenHorseshoeItem(Properties properties) {super(properties);
    }

    @Override
    public void tick(Player player, ItemStack stack) {

        if (player.level().isClientSide()) return;

        if (!player.hasEffect(MobEffects.SLOW_FALLING)) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.SLOW_FALLING,
                        30,
                        0,
                        true,
                        false
                ));
        }
    }

    @Override public boolean canEquip(Player player, ItemStack stack) { return true; }
}