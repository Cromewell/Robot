package com.robot.commands;

import com.robot.MyRobot;

import java.awt.event.MouseEvent;

/**
 * Created by Jo on 02.07.2017.
 */
public class MouseLCommand extends Command {

    public MouseLCommand(MyRobot myRobot, boolean debug) {
        super(myRobot, debug);
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("LEFT MOUSE BUTTON CLICKED!");
        }

        getMyRobot().typeButton(MouseEvent.BUTTON1);
    }
}
