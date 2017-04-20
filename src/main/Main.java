package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] a) throws InterruptedException, IOException {
//          ServoBlaster blaster = new ServoBlaster(192, 2000, 5000);
//         ServoBlaster2 blaster = new ServoBlaster2(192, 2000, 400);
         //ServoBlaster blaster = new ServoBlaster();
         //blaster.autoRun();
         //blaster.userRun(1200);
         //blaster.userRun(900);
        ServoBlaster3 blaster = new ServoBlaster3();
        blaster.auto();
       /* boolean isRunning = false;

        while (isRunning = true){
            System.out.println("");
        }
        for (int i = 0; i <= 3; i++){
            if (i == 3)
                blaster.initialPulse();
            if (i == 0)
                blaster.increasePulse();
        }
        //blaster.initialPulse();

*/
    }
}