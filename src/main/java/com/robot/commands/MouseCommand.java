package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class MouseCommand extends Command {

    private int x;
    private int y;

    public MouseCommand(MyRobot myRobot, int x, int y, boolean debug) {
        super(myRobot, debug);
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("setting mouse to " + x + " x and " + y + " y");
        }

        getMyRobot().mouseMove(x, y);
    }
}
