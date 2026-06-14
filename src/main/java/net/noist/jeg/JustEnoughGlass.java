package net.noist.jeg;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.noist.jeg.block.JEGBlocks;
import net.noist.jeg.item.JEGItems;
import org.slf4j.Logger;

@Mod(JustEnoughGlass.MODID)
public class JustEnoughGlass {

    public static final String MODID = "jeg_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public JustEnoughGlass(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        JEGItems.register(modEventBus);
        JEGBlocks.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            for (String name : JEGItems.getCreativeIngredients()) {
                event.accept(new ItemStack(JEGItems.getItem(name)),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            for (String name : JEGBlocks.getCreativeBlocks()) {
                event.accept(new ItemStack(JEGBlocks.get(name)),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }
}