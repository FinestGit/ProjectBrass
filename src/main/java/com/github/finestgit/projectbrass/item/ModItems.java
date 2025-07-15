package com.github.finestgit.projectbrass.item;

import com.github.finestgit.projectbrass.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> COPPER_BAR = ITEMS.register("copper_bar", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_COPPER = ITEMS.register("raw_copper", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
