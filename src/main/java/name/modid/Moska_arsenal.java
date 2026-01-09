package name.modid;

import name.modid.event.PlayerTickHandler;
import name.modid.item.ModItemGroups;
import name.modid.item.ModItems;
import name.modid.item.custom.SpeedKatana;
import name.modid.loot.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Moska_arsenal implements ModInitializer {
	public static final String MOD_ID = "moska_arsenal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModItemGroups.initialize();
		PlayerTickHandler.register();
		ModLootTableModifiers.modifyLootTables();
		SpeedKatana.registerTickHandler();
	}
}