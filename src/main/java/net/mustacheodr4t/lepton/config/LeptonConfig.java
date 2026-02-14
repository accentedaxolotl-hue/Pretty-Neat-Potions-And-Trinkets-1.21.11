package net.mustacheodr4t.lepton.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class LeptonConfig {

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    static {
        Pair<Common, ForgeConfigSpec> commonPair =
                new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = commonPair.getLeft();
        COMMON_SPEC = commonPair.getRight();

        Pair<Server, ForgeConfigSpec> serverPair =
                new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER = serverPair.getLeft();
        SERVER_SPEC = serverPair.getRight();
    }

    public static class Common {
        public final ForgeConfigSpec.IntValue lesserLuckDuration;
        public final ForgeConfigSpec.IntValue normalLuckDuration;
        public final ForgeConfigSpec.IntValue greaterLuckDuration;
        public final ForgeConfigSpec.IntValue splashLesserLuckDuration;
        public final ForgeConfigSpec.IntValue splashNormalLuckDuration;
        public final ForgeConfigSpec.IntValue splashGreaterLuckDuration;

        public final ForgeConfigSpec.IntValue trinket_check_interval;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("luck_potions");

            lesserLuckDuration = builder
                    .comment("Duration (ticks) for Luck potions")
                    .defineInRange("lesser_duration", 600, 20, 72000);

            normalLuckDuration = builder
                    .defineInRange("normal_duration", 1800, 20, 72000);

            greaterLuckDuration = builder
                    .defineInRange("greater_duration", 1800, 20, 72000);

            splashLesserLuckDuration = builder
                    .comment("Duration (ticks) for Splash Luck potion")
                    .defineInRange("splash_lesser_duration", 300, 20, 72000);

            splashNormalLuckDuration = builder
                    .defineInRange("splash_normal_duration", 900, 20, 72000);

            splashGreaterLuckDuration = builder
                    .defineInRange("splash_greater_duration", 900, 20, 72000);

            builder.pop();

            builder.push("curios_trinkets");

            trinket_check_interval = builder
                    .comment("Duration (ticks) for Tnt checking")
                    .defineInRange("trinket_check_interval", 20, 20, 72000);

            builder.pop();
        }
    }

    public static class Server {
        public final ForgeConfigSpec.BooleanValue enableCatnipCreeperAvoidance;
        public final ForgeConfigSpec.BooleanValue enablePotionMobAvoidance;

        public final ForgeConfigSpec.IntValue mobAvoidValue;

        Server(ForgeConfigSpec.Builder builder) {
            builder.push("mob_behavior");

            enableCatnipCreeperAvoidance = builder
                    .comment("If creepers avoid players with Catnip")
                    .define("catnip_creeper_avoidance", true);

            enablePotionMobAvoidance = builder
                    .comment("If blessed or haunted players are avoided by certain entities.")
                    .define("potion_mob_avoidance", true);

            mobAvoidValue = builder
                    .comment("The radius in which mobs avoid blessed, haunted, or catnip players.")
                    .defineInRange("mob_avoid_value", 4, 1, 99);

            builder.pop();
        }
    }
}