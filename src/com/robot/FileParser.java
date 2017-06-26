package com.robot;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jo on 17.06.2017.
 */
public class FileParser {

    private static boolean debug = true;
    private static boolean shouldExit = false;
    private static boolean clicking = false;

    /**
     * Parses the sript file and executes the commands in it.
     *
     * @param file
     * @param rob
     */
    static void parseFile(File file, Rob rob, InputManager inputManager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] line;
            ArrayList<Integer> toExecute = new ArrayList<>();
            boolean finishedLine = false;
            StringBuilder builder = new StringBuilder();


            while (reader.ready()) {
                line = reader.readLine().split(" ");

                for (int i = 0; i < line.length; i++) {
                    if (finishedLine) {
                        finishedLine = false;
                        break;
                    }
                    switch (line[i]) {
                        case "gui": {
                            toExecute.add(KeyEvent.VK_WINDOWS);
                            break;
                        }
                        case "enter": {
                            toExecute.add(KeyEvent.VK_ENTER);
                            break;
                        }
                        case "right": {
                            toExecute.add(KeyEvent.VK_RIGHT);
                            break;
                        }
                        case "up": {
                            toExecute.add(KeyEvent.VK_UP);
                            break;
                        }
                        case "left": {
                            toExecute.add(KeyEvent.VK_LEFT);
                            break;
                        }
                        case "down": {
                            toExecute.add(KeyEvent.VK_DOWN);
                            break;
                        }
                        case "shift": {
                            toExecute.add(KeyEvent.VK_SHIFT);
                            break;
                        }
                        case "tab": {
                            toExecute.add(KeyEvent.VK_TAB);
                            break;
                        }
                        case "ctrl": {
                            toExecute.add(KeyEvent.VK_CONTROL);
                            break;
                        }
                        case "alt": {
                            toExecute.add(KeyEvent.VK_ALT);
                            break;
                        }
                        case "space": {
                            toExecute.add(KeyEvent.VK_SPACE);
                            break;
                        }
                        case "esc": {
                            toExecute.add(KeyEvent.VK_ESCAPE);
                            break;
                        }
                        case "string": {
                            builder.delete(0, builder.length());
                            for (int j = 1; j < line.length; j++) {
                                builder.append(line[j]);
                                if (j + 1 != line.length) {
                                    builder.append(" ");
                                }
                            }

                            rob.typeString(builder.toString());

                            finishedLine = true;

                            if (debug) {
                                System.out.println("writing " + builder.toString());
                            }
                            break;
                        }
                        case "stringN": {
                            builder.delete(0, builder.length());
                            for (int j = 1; j < line.length; j++) {
                                builder.append(line[j]);
                                if (j + 1 != line.length) {
                                    builder.append(" ");
                                }
                            }

                            rob.typeString(builder.toString());
                            rob.typeKey(KeyEvent.VK_ENTER);

                            finishedLine = true;

                            if (debug) {
                                System.out.println("writing " + builder.toString());
                            }
                            break;
                        }
                        case "delay": {
                            if (debug) {
                                System.out.println("waiting " + line[1] + " ms");
                            }

                            rob.delay(Integer.valueOf(line[1]));
                            finishedLine = true;
                            break;
                        }
                        case "mouse": {
                            if (debug) {
                                System.out.println("setting mouse to " + line[1] + " x and " + line[2] + " y");
                            }

                            rob.mouseMove(Integer.valueOf(line[1]), Integer.valueOf(line[2]));
                            finishedLine = true;
                            break;
                        }
                        case "mouseD": {
                            if (debug) {
                                System.out.println("moving mouse to " + line[1] + " x and " + line[2] + " y");
                            }

                            rob.moveMouseTo(Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[2]));
                            finishedLine = true;
                            break;
                        }
                        case "mouseL": {
                            if (debug) {
                                System.out.println("left mouse button clicked");
                            }

                            rob.typeButton(MouseEvent.BUTTON1);
                            break;
                        }
                        case "mouseR": {
                            if (debug) {
                                System.out.println("right mouse button clicked");
                            }

                            rob.typeButton(MouseEvent.BUTTON2);
                            break;
                        }
                        case "clicker": {
                            if (debug) {
                                System.out.println("clicker activated");
                                System.out.println("clicks to go " + line[1] + " with a delay of " + line[2] + " ms");
                            }

                            try {
                                // Get the logger for "org.jnativehook" and set the level to warning.
                                Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
                                logger.setLevel(Level.OFF);

                                // Don't forget to disable the parent handlers.
                                logger.setUseParentHandlers(false);
                                GlobalScreen.registerNativeHook();
                            } catch (NativeHookException e) {
                                e.printStackTrace();
                            }
                            GlobalScreen.addNativeKeyListener(inputManager);
                            clicking = true;
                            for (int j = 0; j < Integer.valueOf(line[1]); j++) {
                                if (shouldExit) {
                                    System.out.println("exit clicker loop");
                                    break;
                                }
                                rob.typeButton(KeyEvent.BUTTON1_MASK);
                                rob.delay(Integer.valueOf(line[2]));
                            }

                            try {
                                GlobalScreen.unregisterNativeHook();
                            } catch (NativeHookException e) {
                                e.printStackTrace();
                            }
                            clicking = false;
                            shouldExit = false;
                            finishedLine = true;
                            break;
                        }
                        default:
                            if (debug) {
                                System.out.println("typing " + line[i]);
                            }

                            toExecute.add(KeyEvent.getExtendedKeyCodeForChar(line[i].charAt(0)));
                            break;
                    }
                }
                rob.executeKeyChain(toExecute);
                if (debug) {
                    for (int key : toExecute) {
                        System.out.println("pressing " + KeyEvent.getKeyText(key));
                    }
                }
                toExecute.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isClicking() {
        return clicking;
    }

    public static void setShouldExit(boolean shouldExit) {
        FileParser.shouldExit = shouldExit;
    }
}
