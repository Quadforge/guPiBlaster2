package ADS;

import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

public class ADSForceReading {
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSForce a = new ADSForce();
        a.DifferentialReadings();
    }
}
