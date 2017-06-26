package com.robot;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.*;
import java.io.File;

/**
 * Created by Jo on 17.06.2017.
 * Taking a file name as argument and is going to run the script file.
 */
public class Main {
    public static void main(String[] args) {

        Rob rob = null;
        File commandFile = new File(args[0]);

        try {
            rob = new Rob();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        if (rob == null) {
            System.exit(1);
        }


        //parse and execute script file//
        FileParser.parseFile(commandFile, rob, new InputManager());
    }
}
