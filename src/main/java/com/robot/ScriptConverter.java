package com.robot;

import com.robot.commands.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Zorro on 05.07.2017.
 * 
 * Used to convert Roboscript to Duckyscript
 * and the other way around.
 */
public class ScriptConverter {

    private static String currentScript = "";
    private static String buffer = "";

    /**
     * Converts the file content to Duckyscript.
     *
     * @param f Roboscript file to convert
     * @return String with Duckyscript code.
     */
    public static String convertToDucky(File f) {
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            Main.setNextCommandPointer(1);

            ArrayList<Command> cmds = FileParser.parseFile(reader, null, null);
            if (Main.getDefaultDelay() != 0) {
                addToBuffer("DEFAULTDELAY " + Main.getDefaultDelay());
                writeToScript();
            }
            int cP;
            while ((cP = Main.getCurrentCommandPointer()) < cmds.size()) {
                Command c = cmds.get(cP);
                if (c instanceof LoopCommand || c instanceof EndLoopCommand) {
                    c.execute();
                } else {
                    if (c instanceof StringCommand) {
                        addToBuffer("STRING " + ((StringCommand) c).getString());
                        writeToScript();
                    } else if (c instanceof StringNCommand) {
                        addToBuffer("STRING " + ((StringNCommand) c).getString());
                        writeToScript();
                        addToBuffer("ENTER");
                        writeToScript();
                    } else if (c instanceof KeyChainCommand) {
                        ArrayList<String> cmd = ((KeyChainCommand) c).getCommands();
                        for (int i = 0; i < cmd.size(); i++) {
                            String s = cmd.get(i);
                            switch (s) {
                                case "gui": {
                                    addToBuffer("CTRL ESCAPE");
                                    break;
                                }
                                case "key_end": {
                                    addToBuffer("END");
                                    break;
                                }
                                case "esc": {
                                    addToBuffer("ESCAPE");
                                    break;
                                }
                                case "shift": {
                                    if (cmd.size() - 1 > i && cmd.get(i + 1).equals("enter")) {
                                        addToBuffer("SHIFT-ENTER");
                                    } else {
                                        addToBuffer("SHIFT");
                                    }
                                    break;
                                }
                                case "ctrl": {
                                    if (cmd.size() - 2 > i && cmd.get(i + 1).equals("alt") && cmd.get(i + 2).equals("enter")) {
                                        addToBuffer("CTRL-ALT-ENTER");
                                    } else {
                                        addToBuffer("CTRL");
                                    }
                                    break;
                                }
                                case "alt": {
                                    if (cmd.size() - 1 > i && cmd.get(i + 1).equals("f4")) {
                                        addToBuffer("ALT-F4");
                                    } else {
                                        addToBuffer("ALT");
                                    }
                                    break;
                                }
                                default: {
                                    addToBuffer(s.toUpperCase());
                                }
                            }
                        }
                        writeToScript();
                    } else if (c instanceof DelayCommand) {
                        addToBuffer("DELAY " + ((DelayCommand) c).getDelay());
                        writeToScript();
                    }


                    if (c instanceof ClickerCommand || c instanceof MouseCommand || c instanceof MouseDCommand || c instanceof MouseLCommand || c instanceof MouseRCommand) {
                        System.err.println("Robot Script incompatible with DuckyScript, because of Mouse Commands!\nAborting Converting!");
                        System.exit(1);
                    }

                }
                Main.setNextCommandPointer(Main.getCurrentCommandPointer() + 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sc = currentScript;
        currentScript = "";
        return sc;
    }

    /**
     * Converts the file content to Roboscript.
     *
     * @param f Duckyscript file to convert
     * @return String with Roboscript code.
     */
    public static String convertToRobot(File f) {

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String l;
            while ((l = reader.readLine()) != null) {
                String[] line = l.trim().split("\\s");

                boolean finishedLine = false;

                for (int i = 0; i < line.length; i++) {
                    switch (line[i]) {
                        case "REM": {
                            finishedLine = true;
                            break;
                        }
                        case "STRING": {
                            addToBuffer("string " + join(line, 1, line.length));
                            finishedLine = true;
                            break;
                        }
                        case "ENTER": {
                            addToBuffer("enter");
                            finishedLine = true;
                            break;
                        }
                        case "DELAY": {
                            addToBuffer("delay " + line[1]);
                            finishedLine = true;
                            break;
                        }
                        case "REPLAY": {
                            String b = getBufferScript();
                            setBufferScript("loop " + line[1] + "\n" + b + "\nend");
                            finishedLine = true;
                            break;
                        }
                        case "CONTROL":
                        case "CTRL": {
                            if (line.length > i + 1 && (line[1].equals("ESC") || line[i + 1].equals("ESCAPE"))) {
                                addToBuffer("gui");
                                i++;
                                break;
                            }
                            addToBuffer("ctrl");
                            break;
                        }
                        case "SHIFT": {
                            addToBuffer("shift");
                            break;
                        }
                        case "ALT": {
                            addToBuffer("alt");
                            break;
                        }
                        case "APP": {
                            addToBuffer("shift f10");
                            break;
                        }
                        case "MENU": {
                            addToBuffer("shift f10");
                            break;
                        }
                        case "DOWN":
                        case "DOWNARROW": {
                            addToBuffer("down");
                            break;
                        }
                        case "LEFT":
                        case "LEFTARROW": {
                            addToBuffer("left");
                            break;
                        }
                        case "RIGHT":
                        case "RIGHTARROW": {
                            addToBuffer("right");
                            break;
                        }
                        case "UP":
                        case "UPARROW": {
                            addToBuffer("up");
                            break;
                        }
                        case "CAPSLOCK": {
                            addToBuffer("capslock");
                            break;
                        }
                        case "DELETE": {
                            addToBuffer("delete");
                            break;
                        }
                        case "END": {
                            addToBuffer("key_end");
                            break;
                        }
                        case "ESC":
                        case "ESCAPE": {
                            addToBuffer("esc");
                            break;
                        }
                        case "INSERT": {
                            addToBuffer("insert");
                            break;
                        }
                        case "NUMLOCK": {
                            addToBuffer("numlock");
                            break;
                        }
                        case "PAGEUP": {
                            addToBuffer("pageup");
                            break;
                        }
                        case "PAGEDOWN": {
                            addToBuffer("pagedown");
                            break;
                        }
                        case "PRINTSCREEN": {
                            addToBuffer("printscreen");
                            break;
                        }
                        case "SPACE": {
                            addToBuffer("space");
                            break;
                        }
                        case "TAB": {
                            addToBuffer("tab");
                            break;
                        }
                        case "SHIFT-ENTER": {
                            addToBuffer("shift enter");
                            break;
                        }
                        case "CTRL-ALT-DEL": {
                            addToBuffer("ctrl alt delete");
                            break;
                        }
                        case "ALT-F4": {
                            addToBuffer("alt f4");
                            break;
                        }
                        case "WINDOWS": {
                            addToBuffer("gui");
                            break;
                        }
                        case "GUI": {
                            addToBuffer("gui");
                            break;
                        }

                        case "DEFAULTDELAY": {
                            addToBuffer("defaultdelay " + line[1]);
                            finishedLine = true;
                            break;
                        }
                        case "PAUSE":
                        case "BREAK": {
                            addToBuffer("ctrl break");
                            break;
                        }
                        case "HOME": {
                            addToBuffer("home");
                            break;
                        }
                        default: {
                            addToBuffer(line[i].toLowerCase());
                        }
                    }
                    if (finishedLine || i + 1 >= line.length) {
                        i = Integer.MAX_VALUE - 1;
                        writeToScript();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sc = currentScript;
        currentScript = "";
        return sc;
    }

    /**
     * Concats a string array with one whitespace between each member.
     *
     * @param line Array to concat.
     * @param i    Start index.
     * @param max  Array length.
     * @return String of the array content.
     */
    private static String join(String[] line, int i, int max) {
        StringBuilder joined = new StringBuilder();
        for (int l = i; l < max; l++) {
            joined.append(" ").append(line[l]);
        }
        return joined.substring(1);
    }

    /**
     * Writes buffer content into currentScript.
     */
    private static void writeToScript() {
        if (!buffer.isEmpty()) {
            currentScript += buffer;
            if (!buffer.endsWith("\n")) {
                currentScript += "\n";
            }
        }
        buffer = "";
    }

    /**
     * Adds a script fragment to the buffer.
     *
     * @param script Script fragment to add.
     */
    private static void addToBuffer(String script) {
        if (!buffer.isEmpty()) {
            buffer += " ";
        }
        buffer += script;
    }

    /**
     * @return Buffer content.
     */
    private static String getBufferScript() {
        return buffer;
    }

    /**
     * Sets buffer content to a given string.
     *
     * @param script String to set.
     */
    private static void setBufferScript(String script) {
        buffer = script;
    }
}
