package com.robot.commands;

import com.robot.MyRobot;

import java.awt.event.KeyEvent;

/**
 * Created by Jo on 02.07.2017.
 */
public class StringNCommand  extends Command {

    public StringNCommand(MyRobot myRobot, String s, boolean debug) {
        super(myRobot, s, debug);
    }

    @Override
    public void execute() {

        getMyRobot().typeString(getS());
        getMyRobot().typeKey(KeyEvent.VK_ENTER);

        if (isDebug()) {
            System.out.println("typing " + getS());
        }
    }
}