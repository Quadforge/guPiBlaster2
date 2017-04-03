package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by robert on 3/31/17.
 */
public class ServoBlaster3 {
    final private int ZERO_PULSE = 900;
    final private int MID_PULSE = 1600;
    final private String DEV_SERVO_DIRECTORY = "/dev/servoblaster";

    File devServoblaster = new File(DEV_SERVO_DIRECTORY);
    PrintWriter command;

    public void initialPulse()throws IOException{
        try{
            command = new PrintWriter(devServoblaster);
            command.println("2=" + ZERO_PULSE + "us");
            command.close();

        }catch (IOException e){
            System.out.println("Cannot find /dev/servoblaster");
        }
    }
    public void increasePulse()throws IOException{
        try {
            command = new PrintWriter(devServoblaster);
            command.println("2=" + MID_PULSE + "us");
            command.close();
        }catch (IOException e){
            System.out.println("Connot find /dev/servoblaster");
        }
    }
}
