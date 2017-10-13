package TestClasses.ServoBlaster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by robert on 3/31/17.
 */
public class ServoBlaster3 {
    final private int STARTING_PULSE = 800;                             //Initial pulse that is sent to the servoblaster current not being used when the application is launched
    final private int MID_PULSE = 1600;                                 //Tempporary variable of a pulse
    final private String DEV_SERVO_DIRECTORY = "/dev/servoblaster";     //dev Servoblaster directory
                           //index# 0,  1,    2,    3,    4,    5,    6,    7,    8,    9,   10,   11
    final private int[] PULSES = {800, 900, 1000, 1100, 1170, 1270, 1350, 1450, 1520, 1600, 1700, 1800};        //Pulses

    File devServoblaster = new File(DEV_SERVO_DIRECTORY);               //The file object referencing the Directory of the servoblaster
    PrintWriter command;                                                //Global variable for the PrintWriter

    public void initialPulse(){                                         //This method would access the dev/servoblaster and write sending and initial pulse of 0.8ms
        try{
            command = new PrintWriter(devServoblaster);
            command.println("2=" + STARTING_PULSE + "us");
            command.close();

        }catch (IOException e){
            System.out.println("Cannot find /dev/servoblaster");
        }
    }
    public void increasePulse(){                                        //This method suppose to increase pulse as it goes to the array.
        //pulseIndex = PULSES[1];                                       //But its currently being use to testing the button

        try {
            command = new PrintWriter(devServoblaster);
            command.println("2=" + PULSES[11] + "us");
            command.close();
        }catch (IOException e){
            System.out.println("Connot find /dev/servoblaster");
        }
    }
    public void automatic() throws IOException, InterruptedException {                               //Index Of The Array ( 0    1    2    3    4    5    6    7    8   9    10
        for (int i =1; i <=11; i++) {                                                              //Pulses That is needed(900,1000,1200,1300,1400,1500,1600,1700,1800,1900,2000
            try {                                                                           //Servoblaster Command numbers( 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250
                command = new PrintWriter(devServoblaster);                                   //Readings From Oscilloscope(0900,1000,1100,1200,1300,1400,1600,1700,1800,1900,2000,2100,2200,2400,2500,2600,2700,2800
                command.println("2=" + PULSES[i] + "us");                           //adjustment for input to Servoblaster(  80,  90,  100, 110, 117, 127, 135, 145, 152, 160, 170, 180, 190, 200)
                command.close();                                                                    //adjusted pulse in ms( .90, 1.0,  1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 2.1, 2.2)
                Thread.sleep(1000);                                                             //Still able to use the sleep method for letting the motor spin for 2 seconds(this value can be change)
            }catch (IOException e){                                                             //the sleep is temporary
                System.out.println("Cannot find /dev/servoblaster");
            }
        }
        command = new PrintWriter(devServoblaster);
        command.println("2=" + STARTING_PULSE + "us");
        command.close();
    }
}
