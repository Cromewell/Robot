package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class MouseDCommand extends Command {

    private int x;
    private int y;
    private int speed;

    public MouseDCommand(MyRobot myRobot, int x, int y, int speed, boolean debug) {
        super(myRobot, debug);
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("MOVING MOUSE TO " + x + " = x AND " + y + " = y");
        }

        getMyRobot().moveMouseTo(x, y, speed);
    }
}
