package ADS;

import com.pi4j.io.i2c.*;

import java.io.IOException;

public class ADSVoltageReading {
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSVoltage v = new ADSVoltage();
        v.readVoltage();
        /*ads ad = new ads();
        ad.ADS();*/
    }

}
