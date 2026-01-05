package name.modid.item;

import name.modid.Moska_arsenal;
import name.modid.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial CRIMSONITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2000,
            5.0F,
            1.5F,
            22,
            ModTags.Items.REPAIRS_CRIMSONITE
    );

    public static final ToolMaterial VOIDGLASS_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            4000,
            5.0F,
            2.0F,
            22,
            ModTags.Items.REPAIRS_VOIDGLASS
    );
}