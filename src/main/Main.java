package main;

import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] a) throws InterruptedException, IOException {

        ServoBlaster3 blaster = new ServoBlaster3();
         blaster.automatic();
      //  ads ADT = new ads();


        /*try {
            ADT.ADs();

        } catch (I2CFactory.UnsupportedBusNumberException e) {
            e.printStackTrace();
        }*/
    }
}