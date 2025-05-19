package net.nellm.solustectonic.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nellm.solustectonic.SolusTectonic;
import net.nellm.solustectonic.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SolusTectonic.MODID);

    public static final Supplier<CreativeModeTab> SOLUS_TAB = CREATIVE_MODE_TAB.register("solus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PEARL.get()))
                    .title(Component.translatable("creativetab.solus_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PEARL.get());
                        output.accept(ModItems.IRON_PROSPECTING_PICK.get());

                        output.accept(ModBlocks.FOIDOLITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_FOIDOLITE_BLOCK.get());
                        output.accept(ModBlocks.KOMATIITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_KOMATIITE_BLOCK.get());
                        output.accept(ModBlocks.PERIDOTITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_PERIDOTITE_BLOCK.get());
                        output.accept(ModBlocks.DUNITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_DUNITE_BLOCK.get());
                        output.accept(ModBlocks.PYROXENITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_PYROXENITE_BLOCK.get());
                        output.accept(ModBlocks.DIABASE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_DIABASE_BLOCK.get());
                        output.accept(ModBlocks.GABBRO_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_GABBRO_BLOCK.get());
                        output.accept(ModBlocks.SYENITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_SYENITE_BLOCK.get());
                        output.accept(ModBlocks.DACITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_DACITE_BLOCK.get());
                        output.accept(ModBlocks.RHYOLITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_RHYOLITE_BLOCK.get());
                        output.accept(ModBlocks.PEGMATITE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_PEGMATITE_BLOCK.get());
                        output.accept(ModBlocks.TEPHRA_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
