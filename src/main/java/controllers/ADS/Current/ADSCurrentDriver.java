package ADS.Current;

import com.pi4j.io.i2c.*;

import java.io.IOException;

public class ADSCurrentDriver {
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        /*ADSCurrentOld a = new ADSCurrentOld();
        a.DifferentialReadings();*/
        ADSReadCurrent current = new ADSReadCurrent();
        current.analogPinValueListener();
        current.DIFF_ANALOG_INPUTS[0].addListener(current.currentListener);
    }
}
