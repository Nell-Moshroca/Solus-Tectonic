package net.nellm.solustectonic.item;

import net.minecraft.world.item.Item;
import net.nellm.solustectonic.item.custom.ProspectingPickItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nellm.solustectonic.SolusTectonic;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SolusTectonic.MODID);

    // Misc
    public static final DeferredItem<Item> PEARL = ITEMS.register("pearl",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_PROSPECTING_PICK = ITEMS.register("iron_prospecting_pick",
            () -> new ProspectingPickItem(new Item.Properties().durability(100)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
