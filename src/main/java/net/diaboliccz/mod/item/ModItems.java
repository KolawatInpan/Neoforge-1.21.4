package net.diaboliccz.mod.item;

import net.diaboliccz.mod.TestMod;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    public static final DeferredItem<Item> DONUT = ITEMS.registerItem(
        "donut",
        Item::new, 
        new Item.Properties());

    public static final DeferredItem<Item> DONUT_PICKAXE = ITEMS.registerItem(
        "donut_pickaxe",
        Item::new,
        new Item.Properties());

    public static final DeferredItem<Item> DONUT_SWORD = ITEMS.registerItem(
        "donut_sword",
        Item::new,
        new Item.Properties());



    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
