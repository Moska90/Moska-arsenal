package name.modid.item;

import name.modid.Moska_arsenal;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab CUSTOM_GROUP = register(
            "custom_group",
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.moska_arsenal.custom_group"))
                    .icon(() -> new ItemStack(ModItems.VOIDREAPER))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add your items here
                        output.accept(ModItems.CRIMSONITE);
                        output.accept(ModItems.CRIMSONREAPER);
                        output.accept(ModItems.VOIDREAPER);
                        output.accept(ModItems.VOID_UPGRADE_SMITHING_TEMPLATE);
                    })
                    .build()
    );

    public static CreativeModeTab register(String name, CreativeModeTab tab) {
        return Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(Moska_arsenal.MOD_ID, name),
                tab
        );
    }

    public static void initialize() {
        // This method just ensures the class is loaded
    }
}
