package me.lemonboi439.end_revamped.block;

import me.lemonboi439.end_revamped.EndRevamped;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;


import java.util.function.Function;

public class ModBlocks {

    private static Block register(
            String name,
            Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings settings,
            boolean registerItem
    ) {
        // Create registry key for the block
        RegistryKey<Block> blockKey = RegistryKey.of(Registries.BLOCK.getKey(), id(name));

        // Create block instance with its registry key
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Register block item if needed
        if (registerItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), id(name));

            BlockItem blockItem = new BlockItem(
                    block,
                    new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey()
            );

            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        // Register block
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Identifier id(String name) {
        return Identifier.of(EndRevamped.MOD_ID, name);
    }

    // Your block
    public static final Block VOID_GRASS = register(
            "void_grass",
            Block::new,
            AbstractBlock.Settings.create().strength(0.6f),
            true
    );

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(VOID_GRASS);
        });
    }
}
