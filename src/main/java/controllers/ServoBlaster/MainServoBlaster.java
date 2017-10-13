package ServoBlaster;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServoBlaster implements ServoBlaster.ServoBlasterInterface, ServoBlaster.setValueInterface {
  
    /*
     servodDirectory does not acurately tell someone what "dicrectory" it is.
     For someone without knowledge of the system, servod could refer to many different things.
     An example of a more descriptive name would be "ServoBlasterDirectory" or "ProgramLocation".
     */

    private String servodDirectory = "/home/pi/PiBits/ServoBlaster/user";
    private String devServoBlasterDirectory  = "/dev/servoblaster";

    private File startDirectory = new File(servodDirectory);
    private File blasterDirectory = new File(devServoBlasterDirectory);
    private PrintWriter command;


  
    private ProcessBuilder startShellFile = new ProcessBuilder("/bin/sh", "launchServod.sh");
    private ProcessBuilder quitShellFile = new ProcessBuilder("/bin/sh", "quitServod.sh");
    private Process process;
  
  
    /*
     In regards to making things modular for resuse in the future.
     The following, while good named methods for this project; could be made more naming genetic.
     This avoids the copying of code with different names, for other possible use cases.
     An example of a more generic name would be "startProgram" additionally,
     servodDirectory could be changed to "progeamDirectory" etc as mentioned above.
     */
  
    public void openApplication() throws IOException {
        startShellFile.directory(new File(servodDirectory));
        process = startShellFile.start();
    }

    public void endApplication() throws IOException {
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
