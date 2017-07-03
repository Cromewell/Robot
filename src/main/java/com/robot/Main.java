package com.robot;

import com.robot.commands.Command;
import com.robot.commands.LoopCommand;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jo on 17.06.2017.
 * Taking a file name as argument and is going to run the script file.
 */
public class Main {

    /**
     * Current Command Pointer, used by the Executor
     */
    private static int cPointer = -1;

    /**
     * Current State of Loops, describing in which loop we currently are
     */
    private static int loopDeepness;

    /**
     * The List of parsed Commands to execute
     */
    private static ArrayList<Command> commands;

    /**
     * Contains all Entry Command Pointers for loops, used by EndLoopCommand.java
     */
    private static HashMap<Integer, LoopCommand> loopEntries;

    public static void main(String[] args) {
        loopEntries = new HashMap<Integer, LoopCommand>();

        if (args.length != 1) {
            throw new IllegalArgumentException("Needs one script as argument.");
        }

        MyRobot myRobot = null;
        File commandFile = new File(args[0]);

        try {
            myRobot = new MyRobot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        //parse and execute script file//
        commands = FileParser.parseFile(commandFile, myRobot, new InputManager());

        for (cPointer = 0; cPointer < commands.size(); cPointer++) {
            commands.get(cPointer).execute();
        }
    }

    /**
     * Returns the current Command Pointer
     * @return
     */
    public static int getCurrentCommandPointer(){
        return cPointer;
    }

    /**
     * Sets the Command Pointer to pointer
     * @param pointer The Index of the Command to be executed next
     */
    public static void setNextCommandPointer(int pointer){
        cPointer = pointer - 1;
    }

    /**
     * Returns the Current "Deepness" of Loops
     * @return
     */
    public static int getLoopDeepness(){
        return loopDeepness;
    }

    /**
     * Adds 1 to loopDeepness to indicate a new Loop
     */
    public static void goIntoLoop(){
        loopDeepness++;
    }

    /**
     * Substracts 1 from loopDeepness to indicate that a Loop has been exited
     */
    public static void exitLoop(){
        loopDeepness--;
    }

    /**
     * Returns the Command List
     * @return
     */
    public static ArrayList<Command> getCommands(){
        return commands;
    }

    /**
     * Returns the LoopCommand corresponding to the given Loop (depth)
     * @param loop
     * @return
     */
    public static LoopCommand getLoopEntry(int loop){
        return loopEntries.get(loop);
    }

    /**
     * Sets the Pointer (LoopCommand) to the corresponding Loop (depth)
     * @param loop
     * @param pointer
     */
    public static void setLoopEntry(int loop, LoopCommand pointer){
        loopEntries.put(loop,pointer);
    }
}
