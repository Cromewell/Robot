package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class MouseDCommand extends Command {

    public MouseDCommand(MyRobot myRobot, int x, int y, int speed, boolean debug) {
        super(myRobot, x, y, speed, debug);
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("moving mouse to " + getX() + " x and " + getY() + " y");
        }

        getMyRobot().moveMouseTo(getX(), getY(), getSpeed());
    }
}
