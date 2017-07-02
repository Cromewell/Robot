package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class DelayCommand extends Command {

    public DelayCommand(MyRobot myRobot, int time, boolean debug) {
        super(myRobot, time, debug);
    }

    @Override
    public void execute() {
        getMyRobot().delay(getTime());

        if (isDebug()) {
            System.out.println("waiting " + getTime() + " ms");
        }
    }
}
