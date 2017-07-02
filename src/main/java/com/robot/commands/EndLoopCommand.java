package com.robot.commands;

import com.robot.Main;
import com.robot.MyRobot;

/**
 * Created by Zorro909 on 02.07.2017.
 */
public class EndLoopCommand extends Command {

    public EndLoopCommand(MyRobot robot, boolean debug) {
        super(robot, debug);
    }

    @Override
    public void execute() {
        if (Main.loopDeepness <= 0) {
            if (isDebug()) {
                System.out.println("End Command found outside of Loop! Ignoring!");
            }
        } else {
            Main.currentCommand = Main.loopEntries.get(Main.loopDeepness).command - 1;
            Main.loopEntries.get(Main.loopDeepness).throughEnd = true;
            if (isDebug()) {
                System.out.println("End of Loop: Going back to Command " + (Main.currentCommand + 1));
            }
            Main.loopDeepness--;
        }
    }
}
