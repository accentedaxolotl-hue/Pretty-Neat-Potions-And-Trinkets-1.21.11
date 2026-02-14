package net.mustacheodr4t.lepton.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mustacheodr4t.lepton.Lepton;
import net.mustacheodr4t.lepton.effects.custom.*;

public class ModEffects {
    public static final DeferredRegister<MobEffect>
            EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Lepton.MODID);

    public static final RegistryObject<MobEffect>
            fishyEffect = EFFECTS.register("fishyeffect",
            () -> new FishyEffect());

    public static final RegistryObject<MobEffect>
            catnipEffect = EFFECTS.register("catnipeffect",
            () -> new CatnipEffect());

    public static final RegistryObject<MobEffect>
            blessedEffect = EFFECTS.register("blessedeffect",
            () -> new BlessedEffect());

    public static final RegistryObject<MobEffect>
            hauntedEffect = EFFECTS.register("hauntedeffect",
            () -> new HauntedEffect());

    public static void register(BusGroup modEventBus) {
        EFFECTS.register(modEventBus);
    }
}