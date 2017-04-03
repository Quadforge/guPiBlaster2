package main;
import java.awt.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class ServoBlaster {
    Toolkit toolkit;
    Timer timer;

        /*
        public void startServod(){
        // code meant to start servod at startup
        // we have edited the script manually, hoping for help in the future with this part
        }
        */

    // Allows user to input pulsewidth
    public void userRun(int userPulse){
        try {
            File file = new File("/dev/servoblaster");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("2=" + userPulse + "us");
            printWriter.close();
        }catch (IOException ex){
            System.out.println("/dev file not found");
        }
    }

    //Manuallly sets servoblaster to run through pulse width 1 to 2 ms
    public void autoRun() {
        timer = new Timer();
        timer.schedule(new Task1(),
                0,        //initial delay
                1*1000);  //subsequent rate
    }

    class Task1 extends TimerTask {
        double servoPulse = 0;

        //uses timertask to write new increment of pulsewidth every 5 seconds
        public void run() {
            servoPulse++;
            if (servoPulse < 10) {
                double pulse = (0+servoPulse/10)*1000;
                int pulse1 = (int)pulse;
                try {
                    File file = new File("/dev/servoblaster");
                    PrintWriter printWriter = new PrintWriter(file);
                    printWriter.println("2=" + pulse1 + "us");
                    printWriter.close();
                }catch (IOException ex) {
                    System.out.println("/dev file not found");
                }

            } else {
                timer.cancel();
            }
        }
    }
}
