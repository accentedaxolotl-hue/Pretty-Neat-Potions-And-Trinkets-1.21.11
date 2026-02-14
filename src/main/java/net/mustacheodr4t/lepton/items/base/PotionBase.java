package net.mustacheodr4t.lepton.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.mustacheodr4t.lepton.utility.helper.InventoryHelper;
import net.mustacheodr4t.lepton.utility.helper.TooltipHelper;

import java.util.function.Consumer;

public abstract class PotionBase extends Item {
    protected PotionBase(Properties properties) {
        super(properties);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public InteractionResult use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
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

    @Override
    public ItemStack finishUsingItem(
            ItemStack stack,
            Level level,
            LivingEntity entity
    ) {
        if (entity instanceof Player player) {

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                InventoryHelper.getOrDrop(player, new ItemStack(Items.GLASS_BOTTLE));
            }

            if (!level.isClientSide()) {
                applyEffect(player, level);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
        }
        return stack;
    }
    protected abstract void applyEffect(Player player, Level level);
}