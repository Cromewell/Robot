package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class MouseCommand extends Command {

    public MouseCommand(MyRobot myRobot, int x, int y, boolean debug) {
        super(myRobot, x, y, debug);
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("setting mouse to " + getX() + " x and " + getY() + " y");
        }

        getMyRobot().mouseMove(getX(), getY());
    }
}
