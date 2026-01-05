package name.modid.item;

import name.modid.Moska_arsenal;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final TagKey<Item> REPAIRS_CRIMSONITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, "repairs_crimsonite_armor"));
    public static final TagKey<Item> REPAIRS_VOIDGLASS_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, "repairs_voidglass_armor"));

    public static final ToolMaterial CRIMSONITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            455,
            5.0F,
            1.5F,
            22,
            REPAIRS_CRIMSONITE_ARMOR
    );

    public static final ToolMaterial VOIDGLASS_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            455,
            5.0F,
            1.5F,
            22,
            REPAIRS_VOIDGLASS_ARMOR
    );
}
