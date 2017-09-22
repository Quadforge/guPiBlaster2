package ServoBlaster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServoBlaster {
    private String servodDirectory = "/home/pi/PiBits/ServoBlaster/user";
    private String devServoBlasterDirectory  = "/dev/servoblaster";

    private File startDirectory = new File(servodDirectory);
    private File blasterDirectory = new File(devServoBlasterDirectory);
    private PrintWriter command;


    private ProcessBuilder startShellFile = new ProcessBuilder("/bin/sh", "launchServod.sh");
    private ProcessBuilder quitShellFile = new ProcessBuilder("/bin/sh", "quitServod.sh");
    private Process process;

    private final int[] pulseWidth = {800, 900, 1000, 1100, 1170, 1270, 1350, 1450, 1520, 1600, 1700, 1800};

    public void StartServoBlaster() throws IOException {
        startShellFile.directory(new File(servodDirectory));
        process = startShellFile.start();
    }

    public void CloseServoBlaster() throws IOException {
        quitShellFile.directory(new File(servodDirectory));
        process =  quitShellFile.start();
    }

    public void automatic() throws InterruptedException {
        for (int i = 0; i < pulseWidth.length; i++){
            try {
                command = new PrintWriter(blasterDirectory);
                command.println("2=" + pulseWidth[i] + "us");
                command.close();
                Thread.sleep(1000);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void Slider(int sliderValue) throws InterruptedException {
        try {
            command = new PrintWriter(blasterDirectory);
            command.println("2=" + sliderValue + "us");
            command.close();
        }catch (IOException e){
            System.out.println("Connot find /dev/servoblaster");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
         MainServoBlaster ms = new MainServoBlaster();
         ms.StartServoBlaster();
         //ms.automatic();


    }
}
