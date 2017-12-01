package ADS.Voltage;

import HelperFunctions.ReadAndWrite;
import HelperFunctions.ReadAndWriteText;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

public class ADSVoltageDriver {

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADSReadVoltage ADS = new ADSReadVoltage();
        //ReadAndWriteText Read = new ReadAndWriteText();
        ReadAndWrite write = new ReadAndWrite();
        //ADS.analogPinValueListener();
        while (true){
            ADS.analogPinValueListener();
            ADS.diffAnalogInputs[0].addListener(ADS.listener);
        }

        //ADS.diffAnalogInputs[1].addListener(ADS.listener);

    }
}
