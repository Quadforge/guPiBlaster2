package ADS;

import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.i2c.*;

import java.io.IOException;

public class ADSDriver {

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        /*ADSReadVoltage ADS = new ADSReadVoltage();
        ADS.analogPinValueListener();
        ADS.diffAnalogInputs[0].addListener(ADS.listener);
        ADS.diffAnalogInputs[1].addListener(ADS.listener);
        System.out.println(ADS.df.format(ADS.voltage));*/
        ADSVoltage ads = new ADSVoltage();
        ads.DifferentialReadings();
    }
}
