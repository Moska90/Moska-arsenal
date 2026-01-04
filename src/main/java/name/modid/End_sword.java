package name.modid;

import name.modid.event.PlayerTickHandler;
import name.modid.item.ModItemGroups;
import name.modid.item.ModItems;
import name.modid.loot.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class End_sword implements ModInitializer {
	public static final String MOD_ID = "end_sword";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModItemGroups.initialize();
		PlayerTickHandler.register();
		ModLootTableModifiers.modifyLootTables();
	}
}