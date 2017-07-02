package com.robot.commands;

import com.robot.InputManager;
import com.robot.MyRobot;

import java.util.ArrayList;

/**
 * Created by Jo on 02.07.2017.
 * Defines the command constructors.
 */
public abstract class Command {

    private MyRobot myRobot;
    private ArrayList<Integer> keys;
    private int amount;
    private int delay;
    private InputManager inputManager;
    private boolean debug;
    private String s;
    private int time;
    private int x;
    private int y;
    private int speed;

    public Command(MyRobot myRobot, int time, boolean debug) {
        this.myRobot = myRobot;
        this.time = time;
        this.debug = debug;
    }

    public Command(MyRobot myRobot, boolean debug) {
        this.myRobot = myRobot;
        this.debug = debug;
    }


    public Command(MyRobot myRobot, ArrayList<Integer> keys, boolean debug) {
        this.myRobot = myRobot;
        this.keys = keys;
        this.debug = debug;
    }

    public Command(MyRobot myRobot, String s, boolean debug) {
        this.myRobot = myRobot;
        this.debug = debug;
        this.s = s;
    }

    public Command(MyRobot myRobot, int x, int y, boolean debug) {
        this.myRobot = myRobot;
        this.debug = debug;
        this.x = x;
        this.y = y;
    }

    public Command(MyRobot myRobot, int amount, int delay, InputManager inputManager, boolean debug) {
        this.myRobot = myRobot;
        this.inputManager = inputManager;
        this.debug = debug;
        this.amount = amount;
        this.delay = delay;
    }

    public Command(MyRobot myRobot, int x, int y, int speed, boolean debug) {
        this.myRobot = myRobot;
        this.debug = debug;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public abstract void execute();


    public MyRobot getMyRobot() {
        return myRobot;
    }

    ArrayList<Integer> getKeys() {
        return keys;
    }

    public boolean isDebug() {
        return debug;
    }

    String getS() {
        return s;
    }

    int getTime() {
        return time;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getSpeed() {
        return speed;
    }

    int getAmount() {
        return amount;
    }

    int getDelay() {
        return delay;
    }

    InputManager getInputManager() {
        return inputManager;
    }
}
