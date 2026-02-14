package net.mustacheodr4t.lepton.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mustacheodr4t.lepton.Lepton;
import net.mustacheodr4t.lepton.integration.ohmega.*;
import net.mustacheodr4t.lepton.items.custom.drinkable.*;
import net.mustacheodr4t.lepton.items.custom.throwable.*;

public class ModItems {
    public static final DeferredRegister<Item>
            ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Lepton.MODID);

    public static final RegistryObject<Item>
            bottleOfFishyWater = ITEMS.register("fishywater",
            () -> new FishyWaterItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("fishywater"))));

    public static final RegistryObject<Item>
            splashBottleOfFishyWater = ITEMS.register("splashfishywater",
            () -> new SplashFishyWaterItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("splashfishywater"))));

    public static final RegistryObject<Item>
            splashLuckPotion = ITEMS.register("splashluckpotion",
            () -> new SplashLuckPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("splashluckpotion"))));

    public static final RegistryObject<Item>
            luckPotion = ITEMS.register("luckpotion",
            () -> new LuckPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("luckpotion"))));

    public static final RegistryObject<Item>
            lesserLuckPotion = ITEMS.register("lesserluckpotion",
            () -> new LesserLuckPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("lesserluckpotion"))));

    public static final RegistryObject<Item>
            splashLesserLuckPotion = ITEMS.register("splashlesserluckpotion",
            () -> new SplashLesserLuckPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("splashlesserluckpotion"))));

    public static final RegistryObject<Item>
            greaterLuckPotion = ITEMS.register("greaterluckpotion",
            () -> new GreaterLuckPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("greaterluckpotion"))));

    public static final RegistryObject<Item>
            splashGreaterLuckPotion = ITEMS.register("splashgreaterluckpotion",
            () -> new SplashGreaterLuckPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("splashgreaterluckpotion"))));

    public static final RegistryObject<Item>
            catnipPotion = ITEMS.register("catnippotion",
            () -> new CatnipPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("catnippotion"))));

    public static final RegistryObject<Item>
            splashCatnipPotion = ITEMS.register("splashcatnippotion",
            () -> new SplashCatnipPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("splashcatnippotion"))));

    public static final RegistryObject<Item>
            blessedPotion = ITEMS.register("blessedpotion",
            () -> new BlessedPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("blessedpotion"))));

    public static final RegistryObject<Item>
            hauntedPotion = ITEMS.register("hauntedpotion",
            () -> new HauntedPotionItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("hauntedpotion"))));

    public static final RegistryObject<Item>
            catnipCharmItem = ITEMS.register("catnipcharm",
            () -> new CatnipCharmItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("catnipcharm"))));

    public static final RegistryObject<Item>
            goldenHorseshoeItem = ITEMS.register("goldenhorseshoe",
            () -> new GoldenHorseshoeItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("goldenhorseshoe"))));

    public static final RegistryObject<Item>
            leadBootsItem = ITEMS.register("leadboots",
            () -> new LeadBoots(new Item.Properties().stacksTo(1).setId(ITEMS.key("leadboots"))));

    public static final RegistryObject<Item>
            reinforcedChestplate = ITEMS.register("reinforcedchestplate",
            () -> new ReinforcedChestplate(new Item.Properties().stacksTo(1).setId(ITEMS.key("reinforcedchestplate"))));

    public static final RegistryObject<Item>
            chainedSteelBall = ITEMS.register("chainedsteelball",
            () -> new ChainedSteelBallItem(new Item.Properties().stacksTo(1).setId(ITEMS.key("chainedsteelball"))));

    public static void register(BusGroup modEventBus) { ITEMS.register(modEventBus); }
}