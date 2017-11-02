package pi4jServoBlaster;

import GUI.ServoBlasterSliderGUI;
import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;


public class ServoBlasterPi4j {

    public static void main(String[] args) throws Exception {
        /*ServoProvider servoProvider = new RPIServoBlasterProvider();
        ServoDriver servo7 = servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(2));
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < 30000) { // 2 minutes
            for (int i = 50; i < 150; i++) {
                servo7.setServoPulseWidth(i); // Set raw value for this servo driver - 50 to 195
                Thread.sleep(10);
            }
            for (int i = 150; i > 50; i--) {
                servo7.setServoPulseWidth(i); // Set raw value for this servo driver - 50 to 195
                Thread.sleep(10);
            }
        }
        System.out.println("Exiting RPIServoBlasterExample");*/

        ServoProvider servoProvider = new RPIServoBlasterProvider();
        ServoDriver servodMap2 = servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(2));

        ServoBlasterSliderGUI slider = new ServoBlasterSliderGUI();

        while (true){
            servodMap2.setServoPulseWidth(slider.servoSlider.getValue());
        }

    }
}