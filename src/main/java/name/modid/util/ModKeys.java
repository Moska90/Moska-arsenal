package name.modid.util;

import name.modid.Moska_arsenal;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class ModKeys {
    public static class Items {
        public static final ResourceKey<EquipmentAsset> DRAGON_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, "dragon"));
    }
}
