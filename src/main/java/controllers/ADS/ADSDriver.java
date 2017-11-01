package ADS;

import com.pi4j.io.i2c.*;

import java.io.IOException;

public class ADSDriver {
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSVoltage a = new ADSVoltage();
        a.DifferentialReadings();
    }

}
