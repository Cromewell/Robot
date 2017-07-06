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

    private InputManager inputManager;
    private int amount;
    private int delay;

    public ClickerCommand(MyRobot myRobot, int amount, int delay, InputManager inputManager, boolean debug) {
        super(myRobot, debug);
        this.inputManager = inputManager;
        this.amount = amount;
        this.delay = delay;
    }

    @Override
    public void execute() {
        if (isDebug()) {
            System.out.println("CLICKER ACTIVATED!");
            System.out.println("CLICKS TO GO " + amount + " WITH A DELAY OF " + delay + " ms");
        }

        try {
            // Get the logger for "org.jnativehook" and disable logging.
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);

            // Don't forget to disable the parent handlers.
            logger.setUseParentHandlers(false);
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(inputManager);
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        FileParser.setClicking(true);
        for (int click = 0; click < amount; click++) {

            //check if escape was clicked and clicker should be stopped.
            if (FileParser.isShouldExit()) {
                System.out.println("exit clicker loop");
                break;
            }

            //click and wait
            getMyRobot().typeButton(KeyEvent.BUTTON1_MASK);
            getMyRobot().delay(delay);
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
