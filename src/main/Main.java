package main;

import TestClasses.ServoBlaster.ServoBlaster3;

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