package blasted.redebug.event;

import blasted.redebug.RedstoneDebugger;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_REDSTONE_DEBUGGER = "key.categories.redebug.redstone_debugger";
    public static final String KEY_TRIGGER_REDSTONE_DEBUGGER = "key.redebug.trigger_redstone_debugger";

    public static KeyBinding redstoneDebuggerKeyBinding;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (redstoneDebuggerKeyBinding.wasPressed()) {
                RedstoneDebugger.LOGGER.info("Key pressed");
            }
        });
    }

    public static void register() {
        redstoneDebuggerKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TRIGGER_REDSTONE_DEBUGGER,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATEGORY_REDSTONE_DEBUGGER
        ));

        registerKeyInputs();
    }

}
