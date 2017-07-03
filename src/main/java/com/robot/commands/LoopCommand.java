package com.robot.commands;

import com.robot.Main;
import com.robot.MyRobot;

/**
 * Created by Zorro909 on 02.07.2017.
 */
public class LoopCommand extends Command {

    int loops = -1;
    int cLoops = -1;
    int command = 0;
    boolean throughEnd = false;

    public LoopCommand(MyRobot robot, boolean debug, int loops) {
        super(robot, debug);
        this.cLoops = loops;
    }

    @Override
    public void execute() {
        if (throughEnd == false) {
            loops = cLoops;
        } else {
            throughEnd = false;
        }
        if (isDebug()) {
            System.out.println("Current Loops Remaining: " + loops);
        }
        if (loops > 0 || loops == -1) {
            if (loops != -1) {
                loops--;
            }
            Main.loopDeepness++;
            Main.loopEntries.put(Main.loopDeepness, this);
            command = Main.currentCommand;
            if (isDebug()) {
                System.out.println("Current Deepness: " + Main.loopDeepness + " + currentCommand: " + Main.currentCommand);
            }
        } else {

            int cP = Main.currentCommand;
            try {
                int l = 0;
                while (!(Main.commands.get(cP) instanceof EndLoopCommand) || l > 0) {
                    if (Main.commands.get(cP) instanceof EndLoopCommand) {
                        l--;
                    }
                    cP++;
                    if (Main.commands.get(cP) instanceof LoopCommand) {
                        l++;
                    }
                }
            } catch (Exception e) {
                if (isDebug()) {
                    System.out.println("No last End Command found! Exiting Program!");
                }
                Main.currentCommand = Integer.MAX_VALUE - 1;
                return;
            }
            Main.currentCommand = cP;
            if (isDebug()) {
                System.out.println("Exiting Loop " + (Main.loopDeepness) + " at " + Main.currentCommand);
            }
        }
    }
}
