package blasted.redebug;

import blasted.redebug.block.DebugBlocks;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blasted.redebug.item.DebugItems;

public class RedstoneDebugger implements ModInitializer {
	public static final String MOD_ID = "redebug";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		try {
			DebugItems.initialize();
			DebugBlocks.initialize();
			LOGGER.info("Registered mod items!");
		} catch (Exception e) {
			LOGGER.error("Failed to register mod items!", e);
		}
		LOGGER.info("Loaded Redstone Debugger!");
	}
}