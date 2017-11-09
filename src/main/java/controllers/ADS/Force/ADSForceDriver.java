package ADS.Force;

import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

public class ADSForceDriver {
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        /*ADSForceOld a = new ADSForceOld();
        a.DifferentialReadings();*/
        ADSReadForce Force = new ADSReadForce();
        Force.DIFF_ANALOG_INPUTS[0].addListener(Force.listener);
    }
}
