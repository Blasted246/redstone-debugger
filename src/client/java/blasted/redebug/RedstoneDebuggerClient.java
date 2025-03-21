package blasted.redebug;

import blasted.redebug.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class RedstoneDebuggerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
