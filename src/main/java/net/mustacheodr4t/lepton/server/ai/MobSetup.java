package net.mustacheodr4t.lepton.server.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mustacheodr4t.lepton.Lepton;
import net.mustacheodr4t.lepton.config.LeptonConfig;
import net.mustacheodr4t.lepton.effects.ModEffects;

import static net.mustacheodr4t.lepton.config.LeptonConfig.SERVER;

@Mod.EventBusSubscriber(modid = Lepton.MODID)
public class MobSetup {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;
        if (!(event.getEntity() instanceof PathfinderMob mob)) return;

            if (mob instanceof Creeper && LeptonConfig.SERVER.enableCatnipCreeperAvoidance.get()) {
                mob.goalSelector.addGoal(
                        2,
                        new AvoidEntityGoal<>(
                                mob,
                                Player.class,
                                SERVER.mobAvoidValue.get(),
                                1.0D,
                                1.2D,
                                player -> player.hasEffect(ModEffects.catnipEffect.getHolder().get())
                        )
                );
            }

        if (LeptonConfig.SERVER.enablePotionMobAvoidance.get()) {

            if (mob instanceof Skeleton || mob instanceof Zombie) {
                mob.goalSelector.addGoal(
                        2,
                        new AvoidEntityGoal<>(
                                mob,
                                Player.class,
                                SERVER.mobAvoidValue.get(),
                                0D,
                                0D,
                                player -> player.hasEffect(ModEffects.blessedEffect.getHolder().get())
                        )
                );
            }

            if (mob instanceof Villager || mob instanceof Animal) {
                mob.goalSelector.addGoal(
                        2,
                        new AvoidEntityGoal<>(
                                mob,
                                Player.class,
                                SERVER.mobAvoidValue.get(),
                                0D,
                                0D,
                                player -> player.hasEffect(ModEffects.hauntedEffect.getHolder().get())
                        )
                );
            }

            if (mob instanceof IronGolem golem) {
                golem.targetSelector.addGoal(
                        2,
                        new NearestAttackableTargetGoal<>(
                                golem,
                                Player.class,
                                10,
                                true,
                                false,
                                (entity, conditions) ->
                                        entity instanceof Player player
                                                && player.hasEffect(ModEffects.hauntedEffect.getHolder().get())
                        )
                );
            }
        }
    }
}