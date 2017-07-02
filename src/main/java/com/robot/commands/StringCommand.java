package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class StringCommand extends Command {

    public StringCommand(MyRobot myRobot, String s, boolean debug) {
        super(myRobot, s, debug);
    }

    @Override
    public void execute() {

        getMyRobot().typeString(getS());

        if (isDebug()) {
            System.out.println("typing " + getS());
        }
    }
}
