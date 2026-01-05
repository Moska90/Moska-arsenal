package name.modid.item.custom;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpeedKatana extends Item {
    private static final ResourceLocation SPEED_MOD_ID = ResourceLocation.fromNamespaceAndPath("moska_arsenal", "speed_boost");
    private static final int DURATION_TICKS = 200; // 10 seconds
    private static final int COOLDOWN_TICKS = 600; // 30 seconds

    // Store when each player's speed boost should end
    private static final Map<UUID, Integer> activeBoosts = new HashMap<>();

    public SpeedKatana(ToolMaterial material, Properties settings) {
        super(settings);
    }

    // Register this once in your main mod initialization
    public static void registerTickHandler() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            int currentTick = server.getTickCount();

            // Check each active boost
            activeBoosts.entrySet().removeIf(entry -> {
                UUID playerId = entry.getKey();
                int endTick = entry.getValue();

                if (currentTick >= endTick) {
                    // Time to remove the boost
                    ServerPlayer player = server.getPlayerList().getPlayer(playerId);
                    if (player != null) {
                        AttributeInstance attr = player.getAttribute(Attributes.MOVEMENT_SPEED);
                        attr.removeModifier(SPEED_MOD_ID);
                    }
                    return true; // Remove from map
                }
                return false; // Keep in map
            });
        });
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        if (world.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        ItemStack stack = user.getItemInHand(hand);

        // Check if on cooldown
        if (user.getCooldowns().isOnCooldown(stack)) {
            return InteractionResult.FAIL;
        }

        AttributeInstance speedAttribute = user.getAttribute(Attributes.MOVEMENT_SPEED);

        // Add speed boost
        AttributeModifier modifier = new AttributeModifier(
                SPEED_MOD_ID,
                0.05,
                AttributeModifier.Operation.ADD_VALUE
        );
        speedAttribute.addPermanentModifier(modifier);

        // Set cooldown
        user.getCooldowns().addCooldown(stack, DURATION_TICKS + COOLDOWN_TICKS);

        // Schedule removal
        if (user instanceof ServerPlayer serverPlayer && world instanceof net.minecraft.server.level.ServerLevel serverLevel) {
            int endTick = serverLevel.getServer().getTickCount() + DURATION_TICKS;
            activeBoosts.put(serverPlayer.getUUID(), endTick);
        }

        return InteractionResult.SUCCESS;
    }
}