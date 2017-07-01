package com.robot;

import java.awt.*;
import java.io.File;

/**
 * Created by Jo on 17.06.2017.
 * Taking a file name as argument and is going to run the script file.
 */
public class Main {
    public static void main(String[] args) {

        if(args.length != 1){
            throw new IllegalArgumentException("No script as argument");
        }

        Rob rob = null;
        File commandFile = new File(args[0]);

        try {
            rob = new Rob();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        //parse and execute script file//
        FileParser.parseFile(commandFile, rob, new InputManager());
    }
}
