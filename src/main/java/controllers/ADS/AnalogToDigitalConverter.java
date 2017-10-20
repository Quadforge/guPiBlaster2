package ADS;

import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.jni.I2C;

import java.io.IOException;

public class AnalogToDigitalConverter extends ADS1015GpioProvider {

    GpioController controller = GpioFactory.getInstance();

    public AnalogToDigitalConverter(int busNumber, int address) throws I2CFactory.UnsupportedBusNumberException, IOException {
        super(busNumber, address);
    }
    public void readVoltage() throws IOException, I2CFactory.UnsupportedBusNumberException {
        ADS1015GpioProvider adsGpioProvider = new QuadGpioProvider(I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x48);
        }
}
