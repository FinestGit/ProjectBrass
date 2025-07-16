package com.github.finestgit.projectbrass.item;

import com.github.finestgit.projectbrass.TutorialMod;
import com.github.finestgit.projectbrass.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> PROJECT_BRASS_ITEMS_TAB = CREATIVE_MODE_TAB.register("project_brass_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.COPPER_BAR.get()))
                    .title(Component.translatable("creativetab.projectbrass.project_brass_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_BAR);
                        output.accept(ModItems.RAW_COPPER);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> PROJECT_BRASS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("project_brass_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "project_brass_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.COPPER_ORE.get()))
                    .title(Component.translatable("creativetab.projectbrass.project_brass_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.COPPER_ORE);
                        output.accept(ModBlocks.COPPER_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
