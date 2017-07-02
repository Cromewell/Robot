package com.robot;

import com.robot.commands.Command;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Jo on 17.06.2017.
 * Taking a file name as argument and is going to run the script file.
 */
public class Main {
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
        ArrayList<Command> commands = FileParser.parseFile(commandFile, myRobot, new InputManager());

        for (Command cmd : commands) {
            cmd.execute();
        }
    }
}
