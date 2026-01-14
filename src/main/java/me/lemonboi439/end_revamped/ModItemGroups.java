package me.lemonboi439.end_revamped;

import me.lemonboi439.end_revamped.block.ModBlocks;
import me.lemonboi439.end_revamped.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> END_REVAMPED_GROUP =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    Identifier.of(EndRevamped.MOD_ID, "end_revamped"));

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, END_REVAMPED_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 0)
                        .icon(() -> new ItemStack(ModBlocks.ELDERSHADE_LOG))  // make sure this name matches ModBlocks
                        .displayName(Text.literal("End Revamped"))
                        .entries((context, entries) -> {

                            entries.add(ModBlocks.ELDERSHADE_LOG);
                            entries.add(ModItems.ELDERSHADE_LOG_ITEM);

                            entries.add(ModBlocks.ELDERSHADE_PLANKS);
                            entries.add(ModItems.ELDERSHADE_PLANKS_ITEM);

                            entries.add(ModBlocks.ELDERSHADE_STAIRS);
                            entries.add(ModItems.ELDERSHADE_STAIRS_ITEM);

                            entries.add(ModBlocks.ELDERSHADE_SLAB);
                            entries.add(ModItems.ELDERSHADE_SLAB_ITEM);

                        })
                        .build()
        );
    }
}
