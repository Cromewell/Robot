package com.robot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Jo on 17.06.2017.
 * <p>
 * Holds extra methods for keyboard usage.
 */
public class MyRobot extends Robot {

    MyRobot() throws AWTException {
    }

    /**
     * Type the given string on keyboard.
     *
     * @param s String to type
     */
    public void typeString(String s) {
        for (int i = 0; i < s.length(); i++) {

            int c;

            switch (s.charAt(i)) {
                case '!': {
                    typeExclamationMark();
                    break;
                }
                case '?': {
                    typeQuestionMark();
                    break;
                }
                case '"': {
                    typeQuotationMark();
                    break;
                }
                case '\'': {
                    typeApostrophe();
                    break;
                }
                case '|': {
                    typePipe();
                    break;
                }
                case '$': {
                    typeDollarSign();
                    break;
                }
                case '§': {
                    typeParagraphSign();
                    break;
                }
                case '%': {
                    typePercentSign();
                    break;
                }
                case '&': {
                    typeAndSign();
                    break;
                }
                case '_': {
                    typeUnderscore();
                    break;
                }
                case '*': {
                    typeStar();
                    break;
                }
                case '~': {
                    typeTilde();
                    break;
                }
                case '^': {
                    typeCircumflex();
                    break;
                }
                case '=': {
                    typeEqual();
                    break;
                }
                case '<': {
                    typeLesserThan();
                    break;
                }
                case '>': {
                    typeGreaterThan();
                    break;
                }
                case '@': {
                    typeAt();
                    break;
                }
                case ';': {
                    typeSemicolon();
                    break;
                }
                case ':': {
                    typeColon();
                    break;
                }
                case '/': {
                    typeSlash();
                    break;
                }
                case '\\': {
                    typeBackslash();
                    break;
                }
                case '(': {
                    typeOpenedBracket();
                    break;
                }
                case ')': {
                    typeClosedBracket();
                    break;
                }
                case '{': {
                    typeOpenedCurlyBracket();
                    break;
                }
                case '}': {
                    typeClosedCurlyBracket();
                    break;
                }
                case '[': {
                    typeOpenedSquareBracket();
                    break;
                }
                case ']': {
                    typeClosedSquareBracket();
                    break;
                }
                case '\u00C4': {
                    typeUppercaseAe();
                    break;
                }
                case '\u00E4': {
                    typeLowercaseAe();
                    break;
                }
                case '\u00D6': {
                    typeUppercaseOe();
                    break;
                }
                case '\u00F6': {
                    typeLowercaseOe();
                    break;
                }
                case '\u00DC': {
                    typeUppercaseUe();
                    break;
                }
                case '\u00FC': {
                    typeLowercaseUe();
                    break;
                }
                case '\u00DF': {
                    typeSharpS();
                    break;
                }
                default:

                    c = KeyEvent.getExtendedKeyCodeForChar(s.charAt(i));
                    if (Character.isUpperCase(s.charAt(i))) {
                        keyPress(KeyEvent.VK_SHIFT);
                    }
                    try {
                        keyPress(c);
                        keyRelease(c);
                    } catch (IllegalArgumentException iae) {
                        System.err.println();
                        System.err.println("##########################################################################");
                        System.err.println("#                                                                        #");
                        System.err.println("# Invalid key code! Script file has to be enoceded in UTF-8 without BOM! #");
                        System.err.println("#                                                                        #");
                        System.err.println("##########################################################################");
                        System.err.println();
                        System.exit(1);
                    }
                    if (Character.isUpperCase(s.charAt(i))) {
                        keyRelease(KeyEvent.VK_SHIFT);
                    }
                    break;
            }
        }
    }

    private void typeCircumflex() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD9);
            typeKey(KeyEvent.VK_NUMPAD4);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_5);
            typeKey(KeyEvent.VK_E);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeAt() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD6);
            typeKey(KeyEvent.VK_NUMPAD4);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_4);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeGreaterThan() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD6);
            typeKey(KeyEvent.VK_NUMPAD2);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_3);
            typeKey(KeyEvent.VK_E);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeLesserThan() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD6);
            typeKey(KeyEvent.VK_NUMPAD0);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_3);
            typeKey(KeyEvent.VK_C);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeStar() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD4);
            typeKey(KeyEvent.VK_NUMPAD2);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_A);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeTilde() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD6);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_7);
            typeKey(KeyEvent.VK_E);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeUnderscore() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD9);
            typeKey(KeyEvent.VK_NUMPAD5);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_5);
            typeKey(KeyEvent.VK_F);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeAndSign() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD3);
            typeKey(KeyEvent.VK_NUMPAD8);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_6);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typePercentSign() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD3);
            typeKey(KeyEvent.VK_NUMPAD7);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_5);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeParagraphSign() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD6);
            typeKey(KeyEvent.VK_NUMPAD7);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_A);
            typeKey(KeyEvent.VK_7);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeDollarSign() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD3);
            typeKey(KeyEvent.VK_NUMPAD6);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_4);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typePipe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD4);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_7);
            typeKey(KeyEvent.VK_C);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeApostrophe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD3);
            typeKey(KeyEvent.VK_NUMPAD9);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_7);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeQuotationMark() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD3);
            typeKey(KeyEvent.VK_NUMPAD4);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeEqual() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD6);
            typeKey(KeyEvent.VK_NUMPAD1);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_3);
            typeKey(KeyEvent.VK_D);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeSharpS() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD3);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_D);
            typeKey(KeyEvent.VK_F);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeUppercaseUe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD0);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_D);
            typeKey(KeyEvent.VK_C);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeLowercaseUe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD5);
            typeKey(KeyEvent.VK_NUMPAD2);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_F);
            typeKey(KeyEvent.VK_C);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeLowercaseOe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD4);
            typeKey(KeyEvent.VK_NUMPAD6);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_F);
            typeKey(KeyEvent.VK_6);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeUppercaseOe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD4);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_D);
            typeKey(KeyEvent.VK_6);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeLowercaseAe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD8);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_E);
            typeKey(KeyEvent.VK_4);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeUppercaseAe() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD9);
            typeKey(KeyEvent.VK_NUMPAD6);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_C);
            typeKey(KeyEvent.VK_4);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeClosedSquareBracket() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD9);
            typeKey(KeyEvent.VK_NUMPAD3);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_5);
            typeKey(KeyEvent.VK_D);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeOpenedSquareBracket() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD9);
            typeKey(KeyEvent.VK_NUMPAD1);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_5);
            typeKey(KeyEvent.VK_B);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeClosedCurlyBracket() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD5);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_7);
            typeKey(KeyEvent.VK_D);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeOpenedCurlyBracket() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD1);
            typeKey(KeyEvent.VK_NUMPAD2);
            typeKey(KeyEvent.VK_NUMPAD3);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_7);
            typeKey(KeyEvent.VK_B);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeOpenedBracket() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD4);
            typeKey(KeyEvent.VK_NUMPAD0);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_8);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeClosedBracket() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD4);
            typeKey(KeyEvent.VK_NUMPAD1);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_9);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeBackslash() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD9);
            typeKey(KeyEvent.VK_NUMPAD2);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_5);
            typeKey(KeyEvent.VK_C);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeExclamationMark() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD3);
            typeKey(KeyEvent.VK_NUMPAD3);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_1);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeQuestionMark() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD6);
            typeKey(KeyEvent.VK_NUMPAD3);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_3);
            typeKey(KeyEvent.VK_F);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeSemicolon() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD5);
            typeKey(KeyEvent.VK_NUMPAD9);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_3);
            typeKey(KeyEvent.VK_B);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeColon() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD5);
            typeKey(KeyEvent.VK_NUMPAD8);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_3);
            typeKey(KeyEvent.VK_A);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    private void typeSlash() {
        if (Main.isWindowsMachine()) {
            keyPress(KeyEvent.VK_ALT);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD0);
            typeKey(KeyEvent.VK_NUMPAD4);
            typeKey(KeyEvent.VK_NUMPAD7);
            keyRelease(KeyEvent.VK_ALT);
        } else if(Main.isLinuxMachine()){
            keyPress(KeyEvent.VK_CONTROL);
            keyPress(KeyEvent.VK_SHIFT);
            keyPress(KeyEvent.VK_U);
            keyRelease(KeyEvent.VK_CONTROL);
            keyRelease(KeyEvent.VK_SHIFT);
            keyRelease(KeyEvent.VK_U);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_0);
            typeKey(KeyEvent.VK_2);
            typeKey(KeyEvent.VK_F);
            typeKey(KeyEvent.VK_ENTER);
        }
    }

    /**
     * Presses and releases a key.
     *
     * @param keyCode Key to type
     */
    public void typeKey(int keyCode) {
        keyPress(keyCode);
        keyRelease(keyCode);
    }

    /**
     * Presses and releases a mouse button.
     *
     * @param buttonCode Button to type
     */
    public void typeButton(int buttonCode) {
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
    public void executeKeyChain(ArrayList<Integer> keys) {
        for (int key : keys) {
            keyPress(key);
            delay((int) Main.getDefaultDelay());
        }
        for (int key : keys) {
            keyRelease(key);
        }
    }

    public void moveMouseTo(int x, int y, int speed) {
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
