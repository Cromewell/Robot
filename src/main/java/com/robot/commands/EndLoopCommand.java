package com.robot.commands;

import com.robot.Main;
import com.robot.MyRobot;

/**
 * Created by Zorro909 on 02.07.2017.
 */
public class EndLoopCommand extends Command {

    public EndLoopCommand(final MyRobot robot, boolean debug) {
        super(robot, debug);
    }

    @Override
    public void execute() {
        if (Main.getLoopDeepness() <= 0) {
            if (isDebug()) {
                System.out.println("End Command found outside of Loop! Ignoring!");
            }
        } else {
            Main.setNextCommandPointer(Main.getLoopEntry(Main.getLoopDeepness()).getLoopCommandPointer());
            Main.getLoopEntry(Main.getLoopDeepness()).throughEndCommand();
            if (isDebug()) {
                System.out.println("End of Loop: Going back to Command " + (Main.getCurrentCommandPointer() + 1));
            }
            Main.exitLoop();
        }
    }
}
