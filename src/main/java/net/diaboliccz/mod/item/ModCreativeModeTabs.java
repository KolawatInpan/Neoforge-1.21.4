package net.diaboliccz.mod.item;
import net.diaboliccz.mod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import net.diaboliccz.mod.TestMod;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.world.item.ItemStack;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> DONUT_ITEMS_TAB = CREATIVE_MODE_TAB.register("donut_items_tab",
    () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ModItems.DONUT.get()))
        .title(Component.translatable("creativetab.diabolicczmod.donut_items_tabs"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.DONUT);
        })
        .build());

    public static final Supplier<CreativeModeTab> DONUT_TOOLS_TAB = CREATIVE_MODE_TAB.register("donut_tools_tab",
    () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ModItems.DONUT.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "donut_items_tab"))
        .title(Component.translatable("creativetab.diabolicczmod.donut_tools_tabs"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.DONUT_PICKAXE);
            output.accept(ModItems.DONUT_SWORD);
        })
        .build());

    public static final Supplier<CreativeModeTab> DONUT_BLOCKS_TAB = CREATIVE_MODE_TAB.register("donut_blocks_tab",
    () -> CreativeModeTab.builder()
        .icon(() -> new ItemStack(ModBlocks.DONUT_BLOCK.get()))
        .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "donut_tools_tab"))
        .title(Component.translatable("creativetab.diabolicczmod.donut_blocks_tabs"))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModBlocks.DONUT_BLOCK);
            output.accept(ModBlocks.DONUT_ORE);
        })
        .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
