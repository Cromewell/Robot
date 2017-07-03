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

    public static int currentCommand = -1;
    public static int loopDeepness = 0;
    public static ArrayList<Command> commands;
    public static HashMap<Integer, LoopCommand> loopEntries = new HashMap<Integer, LoopCommand>();

    public static void main(String[] args) {

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

        for (currentCommand = 0; currentCommand < commands.size(); currentCommand++) {
            commands.get(currentCommand).execute();
        }
    }
}
