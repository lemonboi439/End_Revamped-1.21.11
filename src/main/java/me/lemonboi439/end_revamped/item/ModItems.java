package me.lemonboi439.end_revamped.item;

import me.lemonboi439.end_revamped.EndRevamped;
import me.lemonboi439.end_revamped.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VOID_GRASS_ITEM =
            registerBlockItem("void_grass", ModBlocks.VOID_GRASS);
    public static final Item ELDERSHADE_LOG_ITEM =
            registerBlockItem("eldershade_log", ModBlocks.ELDERSHADE_LOG);
    public static final Item ELDERSHADE_PLANKS_ITEM =
            registerBlockItem("eldershade_planks", ModBlocks.ELDERSHADE_PLANKS);
    public static final Item ELDERSHADE_STAIRS_ITEM =
            registerBlockItem("eldershade_stairs", ModBlocks.ELDERSHADE_STAIRS);
    public static final Item ELDERSHADE_SLAB_ITEM =
            registerBlockItem("eldershade_slab", ModBlocks.ELDERSHADE_SLAB);




    private static Item registerBlockItem(String name, net.minecraft.block.Block block) {

        RegistryKey<Item> itemKey = RegistryKey.of(
                Registries.ITEM.getKey(),
                Identifier.of(EndRevamped.MOD_ID, name)
        );

        // No useBlockPrefixedTranslationKey() here
        Item item = new BlockItem(block, new Item.Settings().registryKey(itemKey));

        return Registry.register(Registries.ITEM, itemKey, item);
    }

    public static void init() {
        // nothing needed here yet
    }
}
