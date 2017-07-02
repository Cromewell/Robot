package com.robot.commands;

import com.robot.FileParser;
import com.robot.InputManager;
import com.robot.MyRobot;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jo on 02.07.2017.
 */
public class ClickerCommand extends Command {


    public ClickerCommand(MyRobot myRobot, int amount, int delay, InputManager inputManager, boolean debug) {
        super(myRobot, amount, delay, inputManager, debug);
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("clicker activated");
            System.out.println("clicks to go " + getAmount() + " with a delay of " + getDelay() + " ms");
        }

        try {
            // Get the logger for "org.jnativehook" and disable logging.
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);

            // Don't forget to disable the parent handlers.
            logger.setUseParentHandlers(false);
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(getInputManager());
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        FileParser.setClicking(true);
        for (int j = 0; j < getAmount(); j++) {
            if (FileParser.isShouldExit()) {
                System.out.println("exit clicker loop");
                break;
            }
            getMyRobot().typeButton(KeyEvent.BUTTON1_MASK);
            getMyRobot().delay(getDelay());
        }

        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        FileParser.setClicking(false);
        FileParser.setShouldExit(false);
    }
}
