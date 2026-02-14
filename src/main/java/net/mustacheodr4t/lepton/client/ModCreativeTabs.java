package net.mustacheodr4t.lepton.client;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mustacheodr4t.lepton.Lepton;
import net.mustacheodr4t.lepton.items.ModItems;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Lepton.MODID);

    public static final RegistryObject<CreativeModeTab>
            PotionsTab = TABS.register("custompotionstab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("title.lepton.potionstab"))
                            .icon(() -> new ItemStack(ModItems.luckPotion.get()))
                            .displayItems((parameters, output) -> {

                                output.accept(ModItems.bottleOfFishyWater.get());
                                output.accept(ModItems.lesserLuckPotion.get());
                                output.accept(ModItems.luckPotion.get());
                                output.accept(ModItems.greaterLuckPotion.get());
                                output.accept(ModItems.catnipPotion.get());
                                output.accept(ModItems.blessedPotion.get());
                                output.accept(ModItems.hauntedPotion.get());

                                output.accept(ModItems.splashBottleOfFishyWater.get());
                                output.accept(ModItems.splashLesserLuckPotion.get());
                                output.accept(ModItems.splashLuckPotion.get());
                                output.accept(ModItems.splashGreaterLuckPotion.get());
                                output.accept(ModItems.splashCatnipPotion.get());

                            })
                            .build()
            );
    public static final RegistryObject<CreativeModeTab>
            TrinketsTab = TABS.register("customtrinketstab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("title.lepton.trinketsstab"))
                    .icon(() -> new ItemStack(ModItems.goldenHorseshoeItem.get()))
                    .displayItems((parameters, output) -> {

                        output.accept(ModItems.goldenHorseshoeItem.get());
                        output.accept(ModItems.catnipCharmItem.get());
                        output.accept(ModItems.leadBootsItem.get());
                        output.accept(ModItems.reinforcedChestplate.get());
                        output.accept(ModItems.chainedSteelBall.get());

                    })
                    .build()
    );
}