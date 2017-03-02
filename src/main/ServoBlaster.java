package main;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;


public class ServoBlaster {
                         // 0   1    2    3    4    5    6
    int[] servoPulses = {80, 90, 100, 110, 120, 130, 140,
                        // 7    8    9   10   11    12   13   14
                        150, 160, 170, 180, 190, 200, 210, 220};

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
