package com.robot;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jo on 17.06.2017.
 * Parses the given file and executes the commandos.
 */
class FileParser {

    private static final boolean DEBUGGING = true;
    private static boolean shouldExit = false;
    private static boolean clicking = false;

    /**
     * Parses the script file and executes the commands in it.
     *
     * @param file Roboscript file
     * @param rob  Executing robot
     */
    static void parseFile(File file, Rob rob, InputManager inputManager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] line;
            ArrayList<Integer> toExecute = new ArrayList<>();
            boolean finishedLine = false;
            StringBuilder builder = new StringBuilder();


            while (reader.ready()) {
                line = reader.readLine().split(" ");

                for (String word : line) {
                    if (finishedLine) {
                        finishedLine = false;
                        break;
                    }
                    switch (word) {
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

                            if (DEBUGGING) {
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

                            if (DEBUGGING) {
                                System.out.println("writing " + builder.toString());
                            }
                            break;
                        }
                        case "delay": {
                            if (DEBUGGING) {
                                System.out.println("waiting " + line[1] + " ms");
                            }

                            rob.delay(Integer.valueOf(line[1]));
                            finishedLine = true;
                            break;
                        }
                        case "mouse": {
                            if (DEBUGGING) {
                                System.out.println("setting mouse to " + line[1] + " x and " + line[2] + " y");
                            }

                            rob.mouseMove(Integer.valueOf(line[1]), Integer.valueOf(line[2]));
                            finishedLine = true;
                            break;
                        }
                        case "mouseD": {
                            if (DEBUGGING) {
                                System.out.println("moving mouse to " + line[1] + " x and " + line[2] + " y");
                            }

                            rob.moveMouseTo(Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[2]));
                            finishedLine = true;
                            break;
                        }
                        case "mouseL": {
                            if (DEBUGGING) {
                                System.out.println("left mouse button clicked");
                            }

                            rob.typeButton(MouseEvent.BUTTON1);
                            break;
                        }
                        case "mouseR": {
                            if (DEBUGGING) {
                                System.out.println("right mouse button clicked");
                            }

                            rob.typeButton(MouseEvent.BUTTON2);
                            break;
                        }
                        case "clicker": {
                            if (DEBUGGING) {
                                System.out.println("clicker activated");
                                System.out.println("clicks to go " + line[1] + " with a delay of " + line[2] + " ms");
                            }

                            try {
                                // Get the logger for "org.jnativehook" and disable logging.
                                Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
                                logger.setLevel(Level.OFF);

                                // Don't forget to disable the parent handlers.
                                logger.setUseParentHandlers(false);
                                GlobalScreen.registerNativeHook();
                                GlobalScreen.addNativeKeyListener(inputManager);
                            } catch (NativeHookException e) {
                                e.printStackTrace();
                            }

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
                            if (DEBUGGING) {
                                System.out.println("typing " + word);
                            }

                            toExecute.add(KeyEvent.getExtendedKeyCodeForChar(word.charAt(0)));
                            break;
                    }
                }
                rob.executeKeyChain(toExecute);
                if (DEBUGGING) {
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

    static boolean isClicking() {
        return clicking;
    }

    static void setShouldExit(boolean shouldExit) {
        FileParser.shouldExit = shouldExit;
    }
}
