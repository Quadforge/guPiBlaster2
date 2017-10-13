package ServoBlaster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServoBlaster implements ServoBlasterInterface{
    private String servodDirectory = "/home/pi/PiBits/ServoBlaster/user";
    private String devServoBlasterDirectory  = "/dev/servoblaster";

    private File startDirectory = new File(servodDirectory);
    private File blasterDirectory = new File(devServoBlasterDirectory);
    private PrintWriter command;


    private ProcessBuilder startShellFile = new ProcessBuilder("/bin/sh", "launchServod.sh");
    private ProcessBuilder quitShellFile = new ProcessBuilder("/bin/sh", "quitServod.sh");
    private Process process;

    public void startServoBlaster() throws IOException {
        startShellFile.directory(new File(servodDirectory));
        process = startShellFile.start();
    }

    public void stopServoBlaster() throws IOException {
        quitShellFile.directory(new File(servodDirectory));
        process =  quitShellFile.start();
    }

    public void setSliderValue(int sliderValue) throws InterruptedException {
        try {
            command = new PrintWriter(blasterDirectory);
            command.println("2=" + sliderValue + "us");
            command.close();
        }catch (IOException e){
            System.out.println("Connot find /dev/servoblaster");
        }
    }

}
