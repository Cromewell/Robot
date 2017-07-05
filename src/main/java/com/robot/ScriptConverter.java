package com.robot;

import com.robot.commands.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
import java.util.ArrayList;

/**
 * Created by Zorro on 05.07.2017.
 */
public class ScriptConverter {

    private static String currentScript = "";

    private static String buffer = "";

    public static String convertToDucky(File f){
        try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
            Main.setNextCommandPointer(1);

            ArrayList<Command> cmds = FileParser.parseFile(reader,null,null);
            if(Main.getDefaultDelay()!=0) {
                addToScript("DEFAULTDELAY " + Main.getDefaultDelay());
                writeToScript();
            }
            int cP = 0;
            while((cP=Main.getCurrentCommandPointer())<cmds.size()){
                Command c = cmds.get(cP);
                if(c instanceof LoopCommand || c instanceof EndLoopCommand){
                    c.execute();
                }else{
                    if(c instanceof StringCommand){
                        addToScript("STRING " + ((StringCommand)c).getString());
                        writeToScript();
                    }else if(c instanceof StringNCommand){
                        addToScript("STRING " + ((StringNCommand)c).getString());
                        writeToScript();
                        addToScript("ENTER");
                        writeToScript();
                    }else if(c instanceof KeyChainCommand){
                        ArrayList<String> cmd = ((KeyChainCommand)c).getCommands();
                        for(int i = 0;i<cmd.size();i++){
                            String s = cmd.get(i);
                            switch(s){
                                case "gui":{
                                    addToScript("CTRL ESCAPE");
                                    break;
                                }
                                case "key_end":{
                                    addToScript("END");
                                    break;
                                }
                                case "esc":{
                                    addToScript("ESCAPE");
                                    break;
                                }
                                case "shift":{
                                    if(cmd.size()-1>i&&cmd.get(i+1).equals("enter")){
                                        addToScript("SHIFT-ENTER");
                                    }else{
                                        addToScript("SHIFT");
                                    }
                                    break;
                                }
                                case "ctrl":{
                                    if(cmd.size()-2>i&&cmd.get(i+1).equals("alt")&&cmd.get(i+2).equals("enter")){
                                        addToScript("CTRL-ALT-ENTER");
                                    }else{
                                        addToScript("CTRL");
                                    }
                                    break;
                                }
                                case "alt":{
                                    if(cmd.size()-1>i&&cmd.get(i+1).equals("f4")){
                                        addToScript("ALT-F4");
                                    }else{
                                        addToScript("ALT");
                                    }
                                }
                                default:{
                                    addToScript(s.toUpperCase());
                                }
                            }
                        }
                        writeToScript();
                    }else if(c instanceof DelayCommand){
                        addToScript("DELAY " + ((DelayCommand)c).getDelay());
                        writeToScript();
                    }


                    if(c instanceof ClickerCommand || c instanceof MouseCommand ||c instanceof MouseDCommand || c instanceof MouseLCommand || c instanceof MouseRCommand){
                        System.err.println("Robot Script incompatible with DuckyScript, because of Mouse Commands!\nAborting Converting!");
                        System.exit(1);
                    }

                }
                Main.setNextCommandPointer(Main.getCurrentCommandPointer()+2);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        String sc = currentScript;
        currentScript = "";
        return sc;
    }

    public static String convertToRobot(File f){

        try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String l = "";
            while((l=reader.readLine())!=null) {
                String[] line = l.trim().split("\\s");

                boolean finishedLine = false;

                for (int i = 0; i < line.length; i++) {
                    switch (line[i]) {
                        case "REM": {
                            finishedLine = true;
                            break;
                        }
                        case "STRING": {
                            addToScript("string " + join(line, 1, line.length));
                            finishedLine = true;
                            break;
                        }
                        case "ENTER": {
                            addToScript("enter");
                            finishedLine = true;
                            break;
                        }
                        case "DELAY": {
                            addToScript("delay " + line[1]);
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
                            if (line.length > i+1 && (line[1].equals("ESC") || line[i+1].equals("ESCAPE"))) {
                                addToScript("gui");
                                i++;
                                break;
                            }
                            addToScript("ctrl");
                            break;
                        }
                        case "SHIFT": {
                            addToScript("shift");
                            break;
                        }
                        case "ALT": {
                            addToScript("alt");
                            break;
                        }
                        case "APP": {
                            addToScript("shift f10");
                            break;
                        }
                        case "MENU":{
                            addToScript("shift f10");
                            break;
                        }
                        case "DOWN":
                        case "DOWNARROW": {
                            addToScript("down");
                            break;
                        }
                        case "LEFT":
                        case "LEFTARROW": {
                            addToScript("left");
                            break;
                        }
                        case "RIGHT":
                        case "RIGHTARROW": {
                            addToScript("right");
                            break;
                        }
                        case "UP":
                        case "UPARROW": {
                            addToScript("up");
                            break;
                        }
                        case "CAPSLOCK": {
                            addToScript("capslock");
                            break;
                        }
                        case "DELETE": {
                            addToScript("delete");
                            break;
                        }
                        case "END": {
                            addToScript("key_end");
                            break;
                        }
                        case "ESC":
                        case "ESCAPE": {
                            addToScript("esc");
                            break;
                        }
                        case "INSERT": {
                            addToScript("insert");
                            break;
                        }
                        case "NUMLOCK": {
                            addToScript("numlock");
                            break;
                        }
                        case "PAGEUP": {
                            addToScript("pageup");
                            break;
                        }
                        case "PAGEDOWN": {
                            addToScript("pagedown");
                            break;
                        }
                        case "PRINTSCREEN": {
                            addToScript("printscreen");
                            break;
                        }
                        case "SPACE": {
                            addToScript("space");
                            break;
                        }
                        case "TAB": {
                            addToScript("tab");
                            break;
                        }
                        case "SHIFT-ENTER": {
                            addToScript("shift enter");
                            break;
                        }
                        case "CTRL-ALT-DEL": {
                            addToScript("ctrl alt delete");
                            break;
                        }
                        case "ALT-F4": {
                            addToScript("alt f4");
                            break;
                        }
                        case "WINDOWS":{
                            addToScript("gui");
                            break;
                        }
                        case "GUI":{
                            addToScript("gui");
                            break;
                        }

                        case "DEFAULTDELAY": {
                            addToScript("defaultdelay " + line[1]);
                            finishedLine = true;
                            break;
                        }
                        case "PAUSE":
                        case "BREAK":{
                            addToScript("ctrl break");
                            break;
                        }
                        case "HOME":{
                            addToScript("home");
                            break;
                        }
                        default:{
                            addToScript(line[i].toLowerCase());
                        }
                    }
                    if (finishedLine || i + 1 >= line.length) {
                        i = Integer.MAX_VALUE - 1;
                        writeToScript();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String sc = currentScript;
        currentScript = "";
        return sc;
    }

    private static String join(String[] line, int i, int max) {
        String joined = "";
        for(int l = i;l<max;l++){
            joined+=" " + line[l];
        }
        return joined.substring(1);
    }

    private static void writeToScript(){
        if(!buffer.isEmpty()){
            currentScript+=buffer;
            if(!buffer.endsWith("\n")){
                currentScript+="\n";
            }
        }
        buffer = "";
    }

    private static void addToScript(String script){
        if(!buffer.isEmpty()){
            buffer+=" ";
        }
        buffer+= script;
    }

    private static String getBufferScript(){
        return buffer;
    }

    private static void setBufferScript(String script){
        buffer = script;
    }
}
