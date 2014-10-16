package com.kraz.minehr.client.handler;

import com.kraz.minehr.client.settings.Keybindings;
import com.kraz.minehr.reference.Key;
import com.kraz.minehr.util.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

/**
 * Created by Nick on 10/14/2014.
 */
public class KeyInputEventHandler {

    private static Key getPressedKeybinding() {
        if (Keybindings.light.isPressed()) {
            return Key.LIGHT;
        }
        return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){

        //do somethin when key is pressed
    }
}
