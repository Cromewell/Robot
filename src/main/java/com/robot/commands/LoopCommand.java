package com.robot.commands;

import com.robot.Main;
import com.robot.MyRobot;

/**
 * Created by Zorro909 on 02.07.2017.
 */
public class LoopCommand extends Command {

    private int loops = -1;
    private int cLoops = -1;
    private int command = 0;
    private boolean throughEnd = false;

    public LoopCommand(final MyRobot robot, boolean debug, int loops) {
        super(robot, debug);
        this.cLoops = loops;
        if(cLoops == -1){
            if(isDebug()){
                System.out.println("Warning: Program contains Infinite Loop! Program will not terminate by itself!");
            }
        }
    }

    @Override
    public void execute() {
        if (!throughEnd) {
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
            Main.goIntoLoop();
            Main.setLoopEntry(Main.getLoopDeepness(), this);
            command = Main.getCurrentCommandPointer();
            if (isDebug()) {
                System.out.println("Current Deepness: " + Main.getLoopDeepness() + " + currentCommand: " + Main.getCurrentCommandPointer());
            }
        } else {

            int cP = Main.getCurrentCommandPointer();
            try {
                int l = 0;
                while (!(Main.getCommands().get(cP) instanceof EndLoopCommand) || l > 0) {
                    if (Main.getCommands().get(cP) instanceof EndLoopCommand) {
                        l--;
                    }
                    cP++;
                    if (Main.getCommands().get(cP) instanceof LoopCommand) {
                        l++;
                    }
                }
            } catch (Exception e) {
                if (isDebug()) {
                    System.out.println("No last End Command found! Exiting Program!");
                }
                Main.setNextCommandPointer(Integer.MAX_VALUE);
                return;
            }
            Main.setNextCommandPointer(cP+1);
            if (isDebug()) {
                System.out.println("Exiting Loop " + (Main.getLoopDeepness()) + " at " + Main.getCurrentCommandPointer());
            }
        }
    }

    /**
     * Signals the LoopCommand that next Time it executes, it was through a EndLoopCommand
     */
    public void throughEndCommand(){
        throughEnd = true;
    }

    /**
     * Returns the Command Pointer of this LoopCommand
     * @return
     */
    public int getLoopCommandPointer(){
        return command;
    }
}
