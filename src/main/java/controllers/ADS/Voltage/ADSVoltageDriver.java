package ADS.Voltage;

import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

public class ADSVoltageDriver {

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSReadVoltage voltage = new ADSReadVoltage();
        voltage.analogPinValueListener();
        voltage.DIFF_ANALOG_INPUTS[0].addListener(voltage.voltageListener);
    }
}
