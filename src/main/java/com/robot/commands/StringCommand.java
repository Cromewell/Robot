package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class StringCommand extends Command {

    private String toType;

    public StringCommand(MyRobot myRobot, String toType, boolean debug) {
        super(myRobot, debug);
        this.toType = toType;
    }

    @Override
    public void execute() {

        getMyRobot().typeString(toType);

        if (isDebug()) {
            System.out.println("typing " + toType);
        }
    }
}
