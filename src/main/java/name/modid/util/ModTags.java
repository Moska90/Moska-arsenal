package name.modid.util;

import name.modid.Moska_arsenal;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> REPAIRS_CRIMSONITE = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, "repairs_crimsonite"));
        public static final TagKey<Item> REPAIRS_VOIDGLASS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, "repairs_voidglass"));

        public static final TagKey<Item> REPAIRS_DRAGON = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, "repairs_dragon"));
    }
}