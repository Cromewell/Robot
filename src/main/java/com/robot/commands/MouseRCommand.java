package com.robot.commands;

import com.robot.MyRobot;

import java.awt.event.MouseEvent;

/**
 * Created by Jo on 02.07.2017.
 */
public class MouseRCommand extends Command {

    public MouseRCommand(MyRobot myRobot, boolean debug) {
        super(myRobot, debug);
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("RIGHT MOUSE BUTTON CLICKED!");
        }

        getMyRobot().typeButton(MouseEvent.BUTTON2);
    }
}