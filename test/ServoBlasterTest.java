import java.io.IOException;

/*
*
 * Created by codyfinn on 1/17/17.


import javax.swing.*;
import java.io.IOException;

public class ServoBlasterTest extends JFrame {
    public static void main(String[] a) throws InterruptedException, IOException {
//      //  ServoBlaster blaster = new ServoBlaster(192, 2000, 5000);
        // ServoBlaster blaster = new ServoBlaster(192, 2000, 400);
JFrame gui = new JFrame();
        gui = new JFrame();
        gui.setName("guPiBlaster");
        gui.setSize(500,250);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ServoBlaster blaster = new ServoBlaster();
        blaster.servoB();

    }
}
*/
public class ServoBlasterTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServoBlaster2 blaster2 = new ServoBlaster2(192, 2000, 5000);
    }
}