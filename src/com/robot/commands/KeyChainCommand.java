package com.robot.commands;

import com.robot.MyRobot;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.util.Arrays;

/**
 * Created by Jo on 02.07.2017.
 */
public class KeyChainCommand extends Command {

    public KeyChainCommand(MyRobot myRobot, ArrayList<Integer> keys, boolean debug) {
        super(myRobot, keys, debug);
    }

    @Override
    public void execute() {
        getMyRobot().executeKeyChain(getKeys());
        if (isDebug()) {
            //System.out.println(Arrays.toString(new ArrayList[]{getKeys()}));
            for (int key : getKeys()) {
                System.out.println("pressing " + KeyEvent.getKeyText(key));
            }
        }
    }
}
