package com.robot.commands;

import com.robot.MyRobot;

import java.awt.event.KeyEvent;

/**
 * Created by Jo on 02.07.2017.
 */
public class StringNCommand extends Command {

    private String toType;

    public StringNCommand(MyRobot myRobot, String toType, boolean debug) {
        super(myRobot, debug);
        this.toType = toType;
    }

    @Override
    public void execute() {

        getMyRobot().typeString(toType);
        getMyRobot().typeKey(KeyEvent.VK_ENTER);

        if (isDebug()) {
            System.out.println("typing " + toType);
        }
    }

    public String getString(){
        return toType;
    }
}