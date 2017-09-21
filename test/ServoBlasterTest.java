import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
*
 * Created by codyfinn on 1/17/17.


import javax.swing.*;
import java.io.IOException;

public class ServoBlasterTest extends JFrame {
    public static void main(String[] a) throws InterruptedException, IOException {
//      //  ServoBlaster.ServoBlaster blaster = new ServoBlaster.ServoBlaster(192, 2000, 5000);
        // ServoBlaster.ServoBlaster blaster = new ServoBlaster.ServoBlaster(192, 2000, 400);
JFrame gui = new JFrame();
        gui = new JFrame();
        gui.setName("guPiBlaster");
        gui.setSize(500,250);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ServoBlaster.ServoBlaster blaster = new ServoBlaster.ServoBlaster();
        blaster.servoB();

    }
}
*/

public class ServoBlasterTest {
    final static private String DEV_SERVO_DIRECTORY = "/dev/servoblaster";

    static final private int[] PULSES = {800, 900, 1000, 1100, 1170, 1270, 1350, 1450, 1520, 1600, 1700, 1800};

    static File devServoblaster = new File(DEV_SERVO_DIRECTORY);
    static PrintWriter command;
    public static void main(String[] args) throws IOException, InterruptedException {
        final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                auto();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private static void auto(){
        for (int i = 1; i <= 11; i++){
            try {
                command = new PrintWriter(devServoblaster);
                command.println("2=" + PULSES[i] + "us");
                command.close();
            }catch (IOException e){
                System.out.println("NONE");
            }
        }
    }
}