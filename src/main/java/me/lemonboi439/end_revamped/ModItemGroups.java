package me.lemonboi439.end_revamped;

import me.lemonboi439.end_revamped.block.ModBlocks;
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
                        .icon(() -> new ItemStack(ModBlocks.ELDERSHADE_LOG))
                        .displayName(Text.translatable("itemGroup.end_revamped.end_revamped"))
                        .entries((context, entries) -> {

                            // Eldershade wood set
                            entries.add(ModBlocks.ELDERSHADE_LOG);
                            entries.add(ModBlocks.ELDERSHADE_PLANKS);
                            entries.add(ModBlocks.ELDERSHADE_STAIRS);
                            entries.add(ModBlocks.ELDERSHADE_SLAB);

                            // Add more blocks here as you create them
                        })
                        .build()
        );
    }
}
