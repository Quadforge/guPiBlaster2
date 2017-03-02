package main;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;


public class ServoBlaster {
  
    private String servoBlasterDir = "/dev/servoblaster"; 
                      // 0   1    2    3    4    5    6
    int[] servoPulses = {80, 90, 100, 110, 120, 130, 140,
                      // 7    8    9   10   11    12   13   14
                        150, 160, 170, 180, 190, 200, 210, 220};

        public void servoB(){

            for (int pulse = 0; pulse <= 100; pulse+=10){                 //Goes through the array of pulses
                try {
                    File file = new File(seroBlasterDir);
                    PrintWriter printWriter = new PrintWriter(file);
                    printWriter.println("0=" + servoPulses[0]);
                    printWriter.println("0=" + servoPulses[1]);
                    printWriter.println("0=" + servoPulses[2]);
                    printWriter.println("0=" + servoPulses[3]);
                    printWriter.println("0=" + servoPulses[4]);
                    printWriter.println("0=" + servoPulses[5]);
                    printWriter.println("0=" + servoPulses[6]);
                    printWriter.println("0=" + servoPulses[7]);
                    printWriter.println("0=" + servoPulses[8]);
                    printWriter.println("0=" + servoPulses[9]);
                    printWriter.println("0=" + servoPulses[10]);
                    printWriter.println("0=" + servoPulses[11]);
                    printWriter.println("0=" + servoPulses[12]);
                    printWriter.println("0=" + servoPulses[13]);
                    printWriter.println("0=" + servoPulses[14]);
                    printWriter.close();

                } catch (IOException ex) {
                    System.out.println(ex.toString());
                    System.out.println("Could not find /dev/servoblaster");
                }
            }
        }
    }
