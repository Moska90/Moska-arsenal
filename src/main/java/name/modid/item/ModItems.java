package name.modid.item;

import name.modid.Moska_arsenal;
import name.modid.item.custom.SpeedKatana;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

import static name.modid.item.ModToolMaterials.CRIMSONITE_TOOL_MATERIAL;
import static name.modid.item.ModToolMaterials.VOIDGLASS_TOOL_MATERIAL;

public class ModItems {
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, name));

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item CRIMSONITE = register("crimsonite", Item::new,
            new Item.Properties()
                    .stacksTo(1)
    );
    public static final Item VOID_UPGRADE_SMITHING_TEMPLATE = register("void_upgrade_smithing_template", Item::new, new Item.Properties());
    public static final Item COMPACT_PEARL = register("compact_pearl", Item::new, new Item.Properties().stacksTo(1));

    public static final Item CRIMSONREAPER = register(
            "crimsonreaper",
            properties -> new MaceItem(CRIMSONITE_TOOL_MATERIAL, properties),
            new Item.Properties()
                    .sword(CRIMSONITE_TOOL_MATERIAL, 3, -2.4f)
    );

    public static final Item VOIDREAPER = register(
            "voidreaper",
            properties -> new MaceItem(VOIDGLASS_TOOL_MATERIAL, properties),
            new Item.Properties()
                    .enchantable(VOIDGLASS_TOOL_MATERIAL.enchantmentValue())
    );

    public static final Item ATOMSPLIT_KATANA = register(
            "atomsplit_katana",
            properties -> new SpeedKatana(CRIMSONITE_TOOL_MATERIAL, properties),
            new Item.Properties()
                    .sword(CRIMSONITE_TOOL_MATERIAL, 7.5f, -2.4f)
    );

    public static final Item DRAGON_HELMET = register(
            "dragon_helmet",
            Item::new,
            new Item.Properties().humanoidArmor(ModArmorMaterials.DRAGON_ARMOR_MATERIAL, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(ModArmorMaterials.BASE_DURABILITY))
    );

    public static void initialize() {
    }
}