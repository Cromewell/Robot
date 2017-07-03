package com.robot;

import com.robot.commands.*;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jo on 17.06.2017.
 * Parses the given file and returns its commands.
 */
public class FileParser {

    private static final boolean DEBUGGING = true;
    private static boolean shouldExit = false;
    private static boolean clicking = false;

    /**
     * Parses the script file
     *
     * @param file    Roboscript file
     * @param myRobot Executing robot
     */
    static ArrayList<Command> parseFile(File file, MyRobot myRobot, InputManager inputManager) {
        ArrayList<Command> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] line;
            ArrayList<Integer> toExecute = new ArrayList<>();
            boolean finishedLine = false;
            StringBuilder builder = new StringBuilder();


            while (reader.ready()) {
                String input = reader.readLine().trim();
                //Allow Empty Lines via input.isEmpty()
                if (input.isEmpty()) {
                    continue;
                }
                // \\s catches every Whitespace, like Space or Tabs and removes them.
                line = input.split("\\s");

                finishedLine = false;

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
                            commands.add(new StringCommand(myRobot, builder.toString(), DEBUGGING));
                            finishedLine = true;
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
                            commands.add(new StringNCommand(myRobot, builder.toString(), DEBUGGING));
                            finishedLine = true;
                            break;
                        }
                        case "delay": {
                            commands.add(new DelayCommand(myRobot, Integer.parseInt(line[1]), DEBUGGING));
                            finishedLine = true;
                            break;
                        }
                        case "mouse": {
                            commands.add(new MouseCommand(myRobot, Integer.valueOf(line[1]), Integer.valueOf(line[2]), DEBUGGING));
                            finishedLine = true;
                            break;
                        }
                        case "mouseD": {
                            commands.add(new MouseDCommand(myRobot, Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3]), DEBUGGING));
                            finishedLine = true;
                            break;
                        }
                        case "mouseL": {
                            commands.add(new MouseLCommand(myRobot, DEBUGGING));
                            break;
                        }
                        case "mouseR": {
                            commands.add(new MouseRCommand(myRobot, DEBUGGING));
                            break;
                        }
                        case "clicker": {
                            commands.add(new ClickerCommand(myRobot, Integer.parseInt(line[1]), Integer.parseInt(line[2]), inputManager, DEBUGGING));
                            finishedLine = true;
                            break;
                        }
                        case "loop": {
                            if (line.length == 2) {
                                commands.add(new LoopCommand(myRobot, DEBUGGING, Integer.valueOf(line[1])));
                                finishedLine = true;
                            } else {
                                commands.add(new LoopCommand(myRobot, DEBUGGING, -1));
                            }
                            break;
                        }
                        case "end": {
                            commands.add(new EndLoopCommand(myRobot, DEBUGGING));
                            finishedLine = true;
                            break;
                        }
                        default:
                            toExecute.add(KeyEvent.getExtendedKeyCodeForChar(word.charAt(0)));
                            break;
                    }
                }
                if (toExecute.size() > 0) {
                    commands.add(new KeyChainCommand(myRobot, new ArrayList<>(toExecute), DEBUGGING));
                }
                toExecute.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commands;
    }

    static boolean isClicking() {
        return clicking;
    }

    public static void setClicking(boolean clicking) {
        FileParser.clicking = clicking;
    }

    public static boolean isShouldExit() {
        return shouldExit;
    }

    public static void setShouldExit(boolean shouldExit) {
        FileParser.shouldExit = shouldExit;
    }
}
