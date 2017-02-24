package main;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;


public class ServoBlaster {

        public void servoB(){

            for (int pulse = 0; pulse <= 100; pulse+=10){
                try {
                    File file = new File("/dev/servoblaster");
                    PrintWriter printWriter = new PrintWriter(file);
                    printWriter.println("0=" + pulse);
                    printWriter.close();

                } catch (IOException ex) {
                    System.out.println(ex.toString());
                    System.out.println("Could not find /dev/servoblaster");
                }
            }
        }
    }