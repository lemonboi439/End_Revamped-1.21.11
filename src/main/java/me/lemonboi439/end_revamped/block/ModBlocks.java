package me.lemonboi439.end_revamped.block;

import me.lemonboi439.end_revamped.EndRevamped;
import net.minecraft.block.*;
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
            AbstractBlock.Settings settings
    ) {
        RegistryKey<Block> blockKey = RegistryKey.of(
                Registries.BLOCK.getKey(),
                Identifier.of(EndRevamped.MOD_ID, name)
        );

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    // Your block
    public static final Block VOID_GRASS = register(
            "void_grass",
            Block::new,
            AbstractBlock.Settings.create().strength(0.6f)
    );

    public static final Block ELDERSHADE_LOG = register(
            "eldershade_log",
            PillarBlock::new,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool()
    );

    public static final Block ELDERSHADE_PLANKS = register(
            "eldershade_planks",
            Block::new,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool()
    );

    public static final Block ELDERSHADE_STAIRS = register(
            "eldershade_stairs",
            (settings) -> new StairsBlock(ModBlocks.ELDERSHADE_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.create().strength(2.0f).requiresTool()
    );

    public static final Block ELDERSHADE_SLAB = register(
            "eldershade_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool()
    );





    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(VOID_GRASS);
        });
    }
}
