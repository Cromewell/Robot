package com.robot.commands;

import com.robot.MyRobot;

import java.util.ArrayList;

/**
 * Created by Jo on 02.07.2017.
 */
public abstract class Command {

    private MyRobot myRobot;
    private ArrayList<Integer> keys;
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

    public ArrayList<Integer> getKeys() {
        return keys;
    }

    public boolean isDebug() {
        return debug;
    }

    public String getS() {
        return s;
    }

    public int getTime() {
        return time;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
