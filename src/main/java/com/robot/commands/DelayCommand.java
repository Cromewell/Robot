package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 */
public class DelayCommand extends Command {

    private int time;

    public DelayCommand(MyRobot myRobot, int time, boolean debug) {
        super(myRobot, debug);
        this.time = time;
    }

    @Override
    public void execute() {
        getMyRobot().delay(time);

        if (isDebug()) {
            System.out.println("waiting " + time + " ms");
        }
    }
}
