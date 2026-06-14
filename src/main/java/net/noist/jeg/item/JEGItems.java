package net.noist.jeg.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noist.jeg.JustEnoughGlass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Центральная точка регистрации предметов JEG.
 * Предоставляет простой API поверх DeferredRegister.
 */
public class JEGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JustEnoughGlass.MODID);
    private static final Map<String, RegistryObject<Item>> REGISTRY = new HashMap<>();
    private static final List<String> CREATIVE_INGREDIENTS = new ArrayList<>();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void registerItem(String name) {
        REGISTRY.put(name, ITEMS.register(name, () -> new Item(new Item.Properties())));
        CREATIVE_INGREDIENTS.add(name);
    }

    public static void registerItem(String name, Item.Properties properties) {
        REGISTRY.put(name, ITEMS.register(name, () -> new Item(properties)));
        CREATIVE_INGREDIENTS.add(name);
    }

    public static Item getItem(String name) {
        return REGISTRY.get(name).get();
    }

    public static List<String> getCreativeIngredients() {
        return CREATIVE_INGREDIENTS;
    }

    static {
        registerItem("glass_shard");
        registerItem("white_glass_shard");
        registerItem("orange_glass_shard");
        registerItem("magenta_glass_shard");
        registerItem("light_blue_glass_shard");
        registerItem("yellow_glass_shard");
        registerItem("lime_glass_shard");
        registerItem("pink_glass_shard");
        registerItem("gray_glass_shard");
        registerItem("light_gray_glass_shard");
        registerItem("cyan_glass_shard");
        registerItem("purple_glass_shard");
        registerItem("blue_glass_shard");
        registerItem("brown_glass_shard");
        registerItem("green_glass_shard");
        registerItem("red_glass_shard");
        registerItem("black_glass_shard");
    }
}