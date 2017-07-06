package com.robot.commands;

import com.robot.MyRobot;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.util.Arrays;

/**
 * Created by Jo on 02.07.2017.
 */
public class KeyChainCommand extends Command {

    private ArrayList<Integer> keys;
    private ArrayList<String> commands;

    public KeyChainCommand(MyRobot myRobot, ArrayList<Integer> keys, ArrayList<String> commands, boolean debug) {
        super(myRobot, debug);
        this.keys = keys;
        this.commands = commands;
    }

    @Override
    public void execute() {
        getMyRobot().executeKeyChain(keys);
        if (isDebug()) {
            //System.out.println(Arrays.toString(new ArrayList[]{getKeys()}));
            for (int key : keys) {
                System.out.println("PRESSING: " + KeyEvent.getKeyText(key));
            }
        }
    }

    public ArrayList<String> getCommands(){
        return commands;
    }
}
