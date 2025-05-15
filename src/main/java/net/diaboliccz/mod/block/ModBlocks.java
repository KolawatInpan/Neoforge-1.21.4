package net.diaboliccz.mod.block;

import net.diaboliccz.mod.TestMod;
import net.diaboliccz.mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TestMod.MOD_ID);

    // Register the DONUT_BLOCK
    public static final DeferredBlock<Block> DONUT_BLOCK = BLOCKS.register(
            "donut_block",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .requiresCorrectToolForDrops()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.BAMBOO)
                    .lightLevel(state -> 7)));

    // Register the DONUT_BLOCK
    public static final DeferredBlock<Block> DONUT_ORE = BLOCKS.register(
            "donut_ore",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .requiresCorrectToolForDrops()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.BAMBOO)
                    .lightLevel(state -> 7)));

    // Register the block item for
    private static void registerBlockItem(String name, DeferredBlock<Block> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, block.getId())))); // Set the ID for the item
    }

    public static void Register(IEventBus eventBus) {
        // Register the blocks
        BLOCKS.register(eventBus);

        // Register the block item
        registerBlockItem("donut_block", DONUT_BLOCK);
        registerBlockItem("donut_ore", DONUT_ORE);
    }
}