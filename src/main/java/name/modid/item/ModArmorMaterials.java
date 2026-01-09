package name.modid.item;

import name.modid.Moska_arsenal;
import name.modid.util.ModKeys;
import name.modid.util.ModTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;


import java.util.Map;

public class ModArmorMaterials {
    public static final int BASE_DURABILITY = 15;

    public static final ArmorMaterial DRAGON_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ModTags.Items.REPAIRS_DRAGON,
            ModKeys.Items.DRAGON_ARMOR_MATERIAL_KEY
    );
}
