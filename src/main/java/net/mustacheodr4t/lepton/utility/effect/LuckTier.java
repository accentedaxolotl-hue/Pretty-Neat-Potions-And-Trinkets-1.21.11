package net.mustacheodr4t.lepton.utility.effect;

import net.mustacheodr4t.lepton.config.LeptonConfig;

import java.util.function.IntSupplier;

public enum LuckTier {
    LESSER(() -> LeptonConfig.COMMON.lesserLuckDuration.get(), 0),
    NORMAL(() -> LeptonConfig.COMMON.normalLuckDuration.get(), 0),
    GREATER(() -> LeptonConfig.COMMON.greaterLuckDuration.get(), 1);

    public final IntSupplier duration;
    public final int amplifier;

    LuckTier(IntSupplier duration, int amplifier) {
        this.duration = duration;
        this.amplifier = amplifier;
    }
}