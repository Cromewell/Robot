package com.robot.commands;

import com.robot.MyRobot;

/**
 * Created by Jo on 02.07.2017.
 * Defines the command constructors.
 */
public abstract class Command {

    private MyRobot myRobot;
    private boolean debug;


    public Command(MyRobot myRobot, boolean debug) {
        this.myRobot = myRobot;
        this.debug = debug;
    }

    public abstract void execute();


    public MyRobot getMyRobot() {
        return myRobot;
    }


    /**
     * @return Returns true if debugging flag is true.
     */
    public boolean isDebug() {
        return debug;
    }

}
