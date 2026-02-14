package net.mustacheodr4t.lepton.integration.ohmega;

import com.swacky.ohmega.api.IAccessory;
import com.swacky.ohmega.common.accessorytype.AccessoryType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.mustacheodr4t.lepton.effects.ModEffects;
import net.mustacheodr4t.lepton.utility.helper.TooltipHelper;

import java.util.function.Consumer;

import static net.mustacheodr4t.lepton.Lepton.MODID;

public class CatnipCharmItem extends Item implements IAccessory {

        AccessoryType catnipType = new AccessoryType.Builder().build(MODID, "catnipcharm");

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

        public CatnipCharmItem(Properties properties) {
                super(properties);
        }

        @Override
        public void tick(Player player, ItemStack stack) {
                if (player.level().isClientSide()) return;
                if (!player.hasEffect(ModEffects.catnipEffect.getHolder().get())) {
                                player.addEffect(new MobEffectInstance(
                                        ModEffects.catnipEffect.getHolder().get(),
                                        60,
                                        0,
                                        true,
                                        false
                                ));
                }
        }
        @Override public boolean canEquip(Player player, ItemStack stack) { return true; }
}