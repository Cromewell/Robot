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

    private static boolean debugging = false;
    private static boolean shouldExit = false;
    private static boolean clicking = false;

    /**
     * Parses the script file
     *
     * @param reader    BufferedReader with Roboscript file to read.
     * @param myRobot Executing robot
     */
    static ArrayList<Command> parseFile(BufferedReader reader, MyRobot myRobot, InputManager inputManager) {

        ArrayList<Command> commands = new ArrayList<>();

        try {

            String[] line;
            ArrayList<Integer> toExecute = new ArrayList<>();
            ArrayList<String> toExCommands = new ArrayList<>();
            boolean finishedLine = false;
            StringBuilder builder = new StringBuilder();


            while (reader.ready()) {
                String input = reader.readLine();
                if(input==null||input.isEmpty()){
                    break;
                }
                input = input.trim();
                //Allow Empty Lines via input.isEmpty()
                if (input.isEmpty()) {
                    continue;
                }
                // \\s catches every Whitespace, like Space or Tabs and removes them.
                line = input.split("\\s");

                for (String word : line) {
                    if (finishedLine) {
                        finishedLine = false;
                        break;
                    }
                    switch (word) {
                        case "gui": {
                            toExecute.add(KeyEvent.VK_WINDOWS);
                            toExCommands.add("gui");
                            break;
                        }
                        case "enter": {
                            toExecute.add(KeyEvent.VK_ENTER);
                            toExCommands.add("enter");
                            break;
                        }
                        case "right": {
                            toExecute.add(KeyEvent.VK_RIGHT);
                            toExCommands.add("right");
                            break;
                        }
                        case "up": {
                            toExecute.add(KeyEvent.VK_UP);
                            toExCommands.add("up");
                            break;
                        }
                        case "left": {
                            toExecute.add(KeyEvent.VK_LEFT);
                            toExCommands.add("left");
                            break;
                        }
                        case "down": {
                            toExecute.add(KeyEvent.VK_DOWN);
                            toExCommands.add("down");
                            break;
                        }
                        case "shift": {
                            toExecute.add(KeyEvent.VK_SHIFT);
                            toExCommands.add("shift");
                            break;
                        }
                        case "tab": {
                            toExecute.add(KeyEvent.VK_TAB);
                            toExCommands.add("tab");
                            break;
                        }
                        case "ctrl": {
                            toExecute.add(KeyEvent.VK_CONTROL);
                            toExCommands.add("ctrl");
                            break;
                        }
                        case "alt": {
                            toExecute.add(KeyEvent.VK_ALT);
                            toExCommands.add("alt");
                            break;
                        }
                        case "space": {
                            toExecute.add(KeyEvent.VK_SPACE);
                            toExCommands.add("space");
                            break;
                        }
                        case "esc": {
                            toExecute.add(KeyEvent.VK_ESCAPE);
                            toExCommands.add("esc");
                            break;
                        }
                        case "f1": {
                            toExecute.add(KeyEvent.VK_F1);
                            toExCommands.add("f1");
                            break;
                        }
                        case "f2": {
                            toExecute.add(KeyEvent.VK_F2);
                            toExCommands.add("f2");
                            break;
                        }
                        case "f3": {
                            toExecute.add(KeyEvent.VK_F3);
                            toExCommands.add("f3");
                            break;
                        }
                        case "f4": {
                            toExecute.add(KeyEvent.VK_F4);
                            toExCommands.add("f4");
                            break;
                        }
                        case "f5": {
                            toExecute.add(KeyEvent.VK_F5);
                            toExCommands.add("f5");
                            break;
                        }
                        case "f6": {
                            toExecute.add(KeyEvent.VK_F6);
                            toExCommands.add("f6");
                            break;
                        }
                        case "f7": {
                            toExecute.add(KeyEvent.VK_F7);
                            toExCommands.add("f7");
                            break;
                        }
                        case "f8": {
                            toExecute.add(KeyEvent.VK_F8);
                            toExCommands.add("f8");
                            break;
                        }
                        case "f9": {
                            toExecute.add(KeyEvent.VK_F9);
                            toExCommands.add("f9");
                            break;
                        }
                        case "f10": {
                            toExecute.add(KeyEvent.VK_F10);
                            toExCommands.add("f10");
                            break;
                        }
                        case "f11": {
                            toExecute.add(KeyEvent.VK_F11);
                            toExCommands.add("f11");
                            break;
                        }
                        case "f12": {
                            toExecute.add(KeyEvent.VK_F12);
                            toExCommands.add("f12");
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
                            commands.add(new StringCommand(myRobot, builder.toString(), debugging));
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
                            commands.add(new StringNCommand(myRobot, builder.toString(), debugging));
                            finishedLine = true;
                            break;
                        }
                        case "delay": {
                            commands.add(new DelayCommand(myRobot, Integer.parseInt(line[1]), debugging));
                            finishedLine = true;
                            break;
                        }
                        case "mouse": {
                            commands.add(new MouseCommand(myRobot, Integer.valueOf(line[1]), Integer.valueOf(line[2]), debugging));
                            finishedLine = true;
                            break;
                        }
                        case "mouseD": {
                            commands.add(new MouseDCommand(myRobot, Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3]), debugging));
                            finishedLine = true;
                            break;
                        }
                        case "mouseL": {
                            commands.add(new MouseLCommand(myRobot, debugging));
                            break;
                        }
                        case "mouseR": {
                            commands.add(new MouseRCommand(myRobot, debugging));
                            break;
                        }
                        case "clicker": {
                            commands.add(new ClickerCommand(myRobot, Integer.parseInt(line[1]), Integer.parseInt(line[2]), inputManager, debugging));
                            finishedLine = true;
                            break;
                        }
                        case "loop": {
                            if (line.length == 2) {
                                commands.add(new LoopCommand(myRobot, debugging, Integer.valueOf(line[1])));
                                finishedLine = true;
                            } else {
                                commands.add(new LoopCommand(myRobot, debugging, -1));
                            }
                            break;
                        }
                        case "end": {
                            commands.add(new EndLoopCommand(myRobot, debugging));
                            break;
                        }
                        case "defaultdelay":{
                            Main.setDefaultDelay(Long.valueOf(line[1]));
                            finishedLine = true;
                            break;
                        }
                        case "capslock":{
                            toExecute.add(KeyEvent.VK_CAPS_LOCK);
                            toExCommands.add("capslock");
                            break;
                        }
                        case "delete":{
                            toExecute.add(KeyEvent.VK_DELETE);
                            toExCommands.add("delete");
                            break;
                        }
                        case "key_end":{
                            toExecute.add(KeyEvent.VK_END);
                            toExCommands.add("key_end");
                            break;
                        }
                        case "insert":{
                            toExecute.add(KeyEvent.VK_INSERT);
                            toExCommands.add("insert");
                            break;
                        }
                        case "numlock":{
                            toExecute.add(KeyEvent.VK_NUM_LOCK);
                            toExCommands.add("numlock");
                            break;
                        }
                        case "pageup":{
                            toExecute.add(KeyEvent.VK_PAGE_UP);
                            toExCommands.add("pageup");
                            break;
                        }
                        case "pagedown":{
                            toExecute.add(KeyEvent.VK_PAGE_DOWN);
                            toExCommands.add("pagedown");
                            break;
                        }
                        case "printscreen":{
                            toExecute.add(KeyEvent.VK_PRINTSCREEN);
                            toExCommands.add("printscreen");
                            break;
                        }
                        case "pause":{
                            toExecute.add(KeyEvent.VK_PAUSE);
                            toExCommands.add("pause");
                            break;
                        }
                        case "home":{
                            toExecute.add(KeyEvent.VK_HOME);
                            toExCommands.add("home");
                            break;
                        }
                        default:
                            toExecute.add(KeyEvent.getExtendedKeyCodeForChar(word.charAt(0)));
                            toExCommands.add(String.valueOf(word.charAt(0)));
                            break;
                    }
                }
                if (toExecute.size() > 0) {
                    commands.add(new KeyChainCommand(myRobot, new ArrayList<>(toExecute), new ArrayList<>(toExCommands), debugging));
                }
                toExecute.clear();
                toExCommands.clear();
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

    public static boolean isDebugging() {
        return debugging;
    }

    public static void setDebugging(boolean debugging) {
        FileParser.debugging = debugging;
    }
}
