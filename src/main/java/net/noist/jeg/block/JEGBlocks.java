package net.noist.jeg.block;

import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noist.jeg.JustEnoughGlass;
import net.noist.jeg.item.JEGItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Центральная точка регистрации блоков JEG.
 * Предоставляет простой API поверх DeferredRegister.
 */
public class JEGBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JustEnoughGlass.MODID);

    private static final Map<String, RegistryObject<Block>> REGISTRY = new HashMap<>();
    private static final List<String> CREATIVE_BLOCKS = new ArrayList<>();

    private static void registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> registered = BLOCKS.register(name, block);
        JEGItems.ITEMS.register(name, () -> new BlockItem(registered.get(), new Item.Properties()));
        REGISTRY.put(name, registered);
        CREATIVE_BLOCKS.add(name);
    }

    public static Block get(String name) {
        return REGISTRY.get(name).get();
    }

    public static void registerSlab(String name, Block copyFrom) {
        registerBlock(name, () -> new GlassSlabBlock(
                BlockBehaviour.Properties.copy(copyFrom).noOcclusion()));
        CREATIVE_BLOCKS.add(name);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static List<String> getCreativeBlocks() {
        return CREATIVE_BLOCKS;
    }

    static {
        registerSlab("glass_slab", Blocks.GLASS);
        registerSlab("white_glass_slab", Blocks.WHITE_STAINED_GLASS);
        registerSlab("orange_glass_slab", Blocks.ORANGE_STAINED_GLASS);
        registerSlab("magenta_glass_slab", Blocks.MAGENTA_STAINED_GLASS);
        registerSlab("light_blue_glass_slab", Blocks.LIGHT_BLUE_STAINED_GLASS);
        registerSlab("yellow_glass_slab", Blocks.YELLOW_STAINED_GLASS);
        registerSlab("lime_glass_slab", Blocks.LIME_STAINED_GLASS);
        registerSlab("pink_glass_slab", Blocks.PINK_STAINED_GLASS);
        registerSlab("gray_glass_slab", Blocks.GRAY_STAINED_GLASS);
        registerSlab("light_gray_glass_slab", Blocks.LIGHT_GRAY_STAINED_GLASS);
        registerSlab("cyan_glass_slab", Blocks.CYAN_STAINED_GLASS);
        registerSlab("purple_glass_slab", Blocks.PURPLE_STAINED_GLASS);
        registerSlab("blue_glass_slab", Blocks.BLUE_STAINED_GLASS);
        registerSlab("brown_glass_slab", Blocks.BROWN_STAINED_GLASS);
        registerSlab("green_glass_slab", Blocks.GREEN_STAINED_GLASS);
        registerSlab("red_glass_slab", Blocks.RED_STAINED_GLASS);
        registerSlab("black_glass_slab", Blocks.BLACK_STAINED_GLASS);
    }
}
