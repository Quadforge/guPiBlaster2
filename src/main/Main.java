package main;

import java.io.IOException;

public class Main {
    public static void main(String[] a) throws InterruptedException, IOException {
//      //  ServoBlaster blaster = new ServoBlaster(192, 2000, 5000);
        // ServoBlaster blaster = new ServoBlaster(192, 2000, 400);
         ServoBlaster blaster = new ServoBlaster();
         blaster.servoB();

    }
}