package ADS.Voltage;

import ADS.Voltage.ADSReadVoltage;
import com.pi4j.io.i2c.*;

import java.io.IOException;

public class ADSDriver {

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSReadVoltage ADS = new ADSReadVoltage();
        ADS.analogPinValueListener();
        ADS.diffAnalogInputs[0].addListener(ADS.listener);
        ADS.diffAnalogInputs[1].addListener(ADS.listener);

    }
}
