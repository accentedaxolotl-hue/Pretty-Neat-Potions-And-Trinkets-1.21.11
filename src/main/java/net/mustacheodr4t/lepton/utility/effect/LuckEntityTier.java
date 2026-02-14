package net.mustacheodr4t.lepton.utility.effect;

import net.mustacheodr4t.lepton.config.LeptonConfig;

import java.util.function.IntSupplier;

public enum LuckEntityTier {

        LESSER_SPLASH(() -> LeptonConfig.COMMON.splashLesserLuckDuration.get(), 0),
        NORMAL_SPLASH(() -> LeptonConfig.COMMON.splashNormalLuckDuration.get(), 0),
        GREATER_SPLASH(() -> LeptonConfig.COMMON.splashGreaterLuckDuration.get(), 1);

        public final IntSupplier duration;
        public final int amplifier;

        LuckEntityTier(IntSupplier duration, int amplifier) {
            this.duration = duration;
            this.amplifier = amplifier;
        }
}