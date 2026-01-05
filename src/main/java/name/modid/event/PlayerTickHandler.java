package name.modid.event;

import name.modid.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import javax.smartcardio.ATR;

public class PlayerTickHandler {
    private static final ResourceLocation HEALTH_MOD_ID = ResourceLocation.fromNamespaceAndPath("moska_arsenal", "health_boost");

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            // Loop through all players on the server
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                AttributeInstance maxHealthAttribute = player.getAttribute(Attributes.MAX_HEALTH);

                // Check if player has ANY stack of the mace items (regardless of enchantments/damage)
                boolean hasCrimsonMace = false;
                boolean hasVoidMace = false;

                for (ItemStack stack : player.getInventory().getNonEquipmentItems()) {
                    if (stack.is(ModItems.CRIMSONREAPER)) {
                        hasCrimsonMace = true;
                    }
                    if (stack.is(ModItems.VOIDREAPER)) {
                        hasVoidMace = true;
                    }
                    // Early exit if we found both
                    if (hasCrimsonMace && hasVoidMace) {
                        break;
                    }
                }

                boolean hasHealthModifier = maxHealthAttribute.getModifier(HEALTH_MOD_ID) != null;

                double healthBonus = 0.0;
                if (hasVoidMace) {
                    healthBonus = 20.0;
                } else if (hasCrimsonMace) {
                    healthBonus = 10.0;
                }

                // Get current modifier value if it exists
                AttributeModifier currentModifier = maxHealthAttribute.getModifier(HEALTH_MOD_ID);
                double currentBonus = currentModifier != null ? currentModifier.amount() : 0.0;

                if (healthBonus > 0 && currentBonus != healthBonus) {
                    // Player has a mace and either no modifier or wrong value - update it
                    if (currentModifier != null) {
                        maxHealthAttribute.removeModifier(HEALTH_MOD_ID);
                    }
                    AttributeModifier modifier = new AttributeModifier(
                            HEALTH_MOD_ID,
                            healthBonus,
                            AttributeModifier.Operation.ADD_VALUE
                    );
                    maxHealthAttribute.addPermanentModifier(modifier);
                } else if (healthBonus == 0 && hasHealthModifier) {
                    // Player doesn't have any mace but has modifier - remove it
                    maxHealthAttribute.removeModifier(HEALTH_MOD_ID);
                }
            }
        });
    }
}