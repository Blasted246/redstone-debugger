package blasted.redebug;

import blasted.redebug.block.DebugBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blasted.redebug.item.DebugItems;

public class RedstoneDebugger implements ModInitializer {
	public static final String MOD_ID = "redebug";

	private static KeyBinding myKeyBinding;

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
		myKeyBinding = new KeyBinding(
				"key.mymod.example",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_R,
				"category.mymod.keys"
		);
		KeyBindingHelper.registerKeyBinding(myKeyBinding);
		LOGGER.info("Loaded Redstone Debugger!");
	}

	public static KeyBinding getMyKeyBinding() {
		return myKeyBinding;
	}

}