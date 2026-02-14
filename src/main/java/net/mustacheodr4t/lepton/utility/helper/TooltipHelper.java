package net.mustacheodr4t.lepton.utility.helper;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class TooltipHelper {
    @OnlyIn(Dist.CLIENT)
    public static void addTooltip(
            ItemStack stack,
            Item.TooltipContext context,
            TooltipDisplay display,
            Consumer<Component> tooltip,
            TooltipFlag flag
    ) {
        if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT) ||
                InputConstants.isKeyDown(Minecraft.getInstance().getWindow(), GLFW.GLFW_KEY_RIGHT_SHIFT))
        {
            int line = 1;
            String itemId = stack.getItem()
                    .getDescriptionId()
                    .replace("item.lepton.", "");

            String tooltipID = "tooltip.lepton." + itemId + ".detail";

            while (Language.getInstance().has(tooltipID + ".line" + line))
            {
                tooltip.accept(Component.translatable(
                        tooltipID + ".line" + line));
                line++;
            }
        }
        else {
            tooltip.accept(Component.translatable(
                    "tooltip.lepton.shift.held"
            ));
        }
    }
}