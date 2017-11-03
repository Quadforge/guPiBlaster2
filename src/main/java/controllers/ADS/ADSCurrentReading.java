package ADS;

import com.pi4j.io.i2c.*;

import java.io.IOException;

public class ADSCurrentReading {
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSCurrent a = new ADSCurrent();
        a.DifferentialReadings();
    }
}
