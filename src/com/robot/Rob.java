package com.robot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Jo on 17.06.2017.
 * <p>
 * Holds extra methods for keyboard usage.
 */
class Rob extends Robot {

    Rob() throws AWTException {
    }

    /**
     * Type the given string on keyboard.
     *
     * @param s String to type
     */
    void typeString(String s) {
        for (int i = 0; i < s.length(); i++) {

            int c;

            switch (s.charAt(i)) {
                case '!': {
                    keyPress(KeyEvent.VK_SHIFT);
                    typeKey(KeyEvent.VK_1);
                    keyRelease(KeyEvent.VK_SHIFT);
                    break;
                }
                case '?': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD6);
                    typeKey(KeyEvent.VK_NUMPAD3);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case ';': {
                    keyPress(KeyEvent.VK_SHIFT);
                    typeKey(KeyEvent.VK_COMMA);
                    keyRelease(KeyEvent.VK_SHIFT);
                    break;
                }
                case ':': {
                    keyPress(KeyEvent.VK_SHIFT);
                    typeKey(KeyEvent.VK_PERIOD);
                    keyRelease(KeyEvent.VK_SHIFT);
                    break;
                }
                case '/': {
                    keyPress(KeyEvent.VK_SHIFT);
                    typeKey(KeyEvent.VK_7);
                    keyRelease(KeyEvent.VK_SHIFT);
                    break;
                }
                case '\\': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD9);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case '(': {
                    keyPress(KeyEvent.VK_SHIFT);
                    typeKey(KeyEvent.VK_8);
                    keyRelease(KeyEvent.VK_SHIFT);
                    break;
                }
                case ')': {
                    keyPress(KeyEvent.VK_SHIFT);
                    typeKey(KeyEvent.VK_9);
                    keyRelease(KeyEvent.VK_SHIFT);
                    break;
                }
                case '{': {
                    keyPress(KeyEvent.VK_CONTROL);
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_7);
                    keyRelease(KeyEvent.VK_CONTROL);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case '}': {
                    keyPress(KeyEvent.VK_CONTROL);
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_0);
                    keyRelease(KeyEvent.VK_CONTROL);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case '[': {
                    keyPress(KeyEvent.VK_CONTROL);
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_8);
                    keyRelease(KeyEvent.VK_CONTROL);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case ']': {
                    keyPress(KeyEvent.VK_CONTROL);
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_9);
                    keyRelease(KeyEvent.VK_CONTROL);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'Ä': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD1);
                    typeKey(KeyEvent.VK_NUMPAD9);
                    typeKey(KeyEvent.VK_NUMPAD6);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'ä': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD8);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'Ö': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD1);
                    typeKey(KeyEvent.VK_NUMPAD4);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'ö': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD4);
                    typeKey(KeyEvent.VK_NUMPAD6);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'Ü': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'ü': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD5);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                case 'ß': {
                    keyPress(KeyEvent.VK_ALT);
                    typeKey(KeyEvent.VK_NUMPAD0);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD2);
                    typeKey(KeyEvent.VK_NUMPAD3);
                    keyRelease(KeyEvent.VK_ALT);
                    break;
                }
                default:
                    c = KeyEvent.getExtendedKeyCodeForChar(s.charAt(i));
                    keyPress(c);
                    keyRelease(c);
                    break;
            }
        }
    }

    /**
     * Presses and releases a key.
     *
     * @param keyCode Key to type
     */
    void typeKey(int keyCode) {
        keyPress(keyCode);
        keyRelease(keyCode);
    }

    /**
     * Presses and releases a mouse button.
     *
     * @param buttonCode Button to type
     */
    void typeButton(int buttonCode) {
        mousePress(buttonCode);
        mouseRelease(buttonCode);
    }

    /**
     * This function presses the given keys and releases them after pressing all.
     *
     * @param keys Keys to execute
     */
    void executeKeyChain(int... keys) {
        for (int key : keys) {
            keyPress(key);
            delay(80);
        }
        for (int key : keys) {
            keyRelease(key);
        }
    }

    /**
     * This function presses the given keays and releases them after pressing all.
     *
     * @param keys Keys to execute
     */
    void executeKeyChain(ArrayList<Integer> keys) {
        for (int key : keys) {
            keyPress(key);
            delay(80);
        }
        for (int key : keys) {
            keyRelease(key);
        }
    }

    void moveMouseTo(int x, int y, int speed) {
        Point location = MouseInfo.getPointerInfo().getLocation();

        int n = speed / 5;

        double dx = (x - location.x) / ((double) n);
        double dy = (y - location.y) / ((double) n);
        double dt = speed / ((double) n);

        for (int step = 1; step <= n; step++) {
            delay((int) dt);
            mouseMove((int) (location.x + dx * step), (int) (location.y + dy * step));
        }
    }
}
