package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by robert on 3/31/17.
 */
public class ServoBlaster3 {
    final private int STARTING_PULSE = 900;
    final private int MID_PULSE = 1600;
    final private String DEV_SERVO_DIRECTORY = "/dev/servoblaster";

    final private int[] PULSES = {900, 1000, 1200, 1300,1400,1500,1600,1700,1800,1900,2000};

    int countdownStart = 5;

    File devServoblaster = new File(DEV_SERVO_DIRECTORY);
    PrintWriter command;

    public void initialPulse()throws IOException{
        try{
            command = new PrintWriter(devServoblaster);
            command.println("2=" + STARTING_PULSE + "us");
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
    public void automatic() throws IOException, InterruptedException {                                //index (   0   1   2   3   4     5     6   7    8    9   10
        for (int i =1; i <=10; i++) {                                                                 //pulses(900,1000,1200,1300,1400,1500,1600,1700,1800,1900,2000
            try {
                command = new PrintWriter(devServoblaster);
                command.println("2=" + PULSES[i] + "us");
                command.close();
                Thread.sleep(2000);                                                             //Still able to use the sleep method for letting the motor spin for 2 seconds(this value can be change)
            }catch (IOException e){
                System.out.println("Cannot find /dev/servoblaster");
            }
        }
        command = new PrintWriter(devServoblaster);
        command.println("2=" + STARTING_PULSE + "us");
        command.close();
    }
}
