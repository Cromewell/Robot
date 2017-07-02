package com.robot;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * Created by Jo on 26.06.2017.
 * Global key listener
 */
public class InputManager implements NativeKeyListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        //stop clicker
        if (FileParser.isClicking() && nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            FileParser.setShouldExit(true);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }
}
