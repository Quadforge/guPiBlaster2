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
    final private int STARTING_PULSE = 800;
    final private int MID_PULSE = 1600;
    final private String DEV_SERVO_DIRECTORY = "/dev/servoblaster";

    final private int[] PULSES = {800, 900, 1000, 1100, 1170, 1270, 1350, 1450, 1520, 1600, 1700, 1800};

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
    public void automatic() throws IOException, InterruptedException {                               //index ( 0    1    2    3    4    5    6    7    8   9    10
        for (int i =1; i <=11; i++) {                                                                //pulses(900,1000,1200,1300,1400,1500,1600,1700,1800,1900,2000
            try {                                                                              //servoblaster( 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250
                command = new PrintWriter(devServoblaster);                        //ReadingsFromOscilloscope(0900,1000,1100,1200,1300,1400,1600,1700,1800,1900,2000,2100,2200,2400,2500,2600,2700,2800
                command.println("2=" + PULSES[i] + "us");                            //adjustmentServoblaster(  80,  90,  100, 110, 117, 127, 135, 145, 152, 160, 170, 180, 190, 200)
                command.close();                                                            //adjustmentPulse( .90, 1.0,  1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 2.1, 2.2)
                Thread.sleep(5000);                                                             //Still able to use the sleep method for letting the motor spin for 2 seconds(this value can be change)
            }catch (IOException e){
                System.out.println("Cannot find /dev/servoblaster");
            }
        }
        command = new PrintWriter(devServoblaster);
        command.println("2=" + STARTING_PULSE + "us");
        command.close();
    }
}
