package ADS.Current;

import ADS.ADS1015DifferentialPins;
import ADS.DifferentialGpioProvider;
import Interfaces.ADSInterface;
import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1015Pin;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalog;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.text.DecimalFormat;

public class ADSReadCurrent implements ADSInterface {
    private double baseLine; //why is this not a constant?
    private double outputSensitivity; //why is this not a constant?
    private double value;
    private double percent;
    private double voltage;
    private double current;

    public GpioPinListener currentListener;

    protected  final DecimalFormat DF = new DecimalFormat("#.##");

    private final GpioController GPIO = GpioFactory.getInstance();

    private final DifferentialGpioProvider DIFFERENTIAL_PROVIDER = new DifferentialGpioProvider(
            I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x48);

    protected final GpioPinAnalog DIFF_ANALOG_INPUTS[] = {
            GPIO.provisionAnalogInputPin(DIFFERENTIAL_PROVIDER, ADS1015DifferentialPins.INPUT_A0_A1)
    };

    public ADSReadCurrent() throws IOException, I2CFactory.UnsupportedBusNumberException {
        setupGpio();
    }

    @Override
  //Function called setupGpio() but what would occur if someone used this and wanted a single ended reading? From reading the inner methods, I am assuming that it is being setup in Differential Mode. If it is not, then the name is fine as is. However, if it is then the name should reflect this. Someone using this method might think it sets up the Gpio in single reading mode. 
    public void setupGpio() {
        DIFFERENTIAL_PROVIDER.setProgrammableGainAmplifier(
                ADS1x15GpioProvider.ProgrammableGainAmplifierValue.PGA_4_096V, ADS1015Pin.ALL);
        DIFFERENTIAL_PROVIDER.setEventThreshold(500, ADS1015Pin.ALL);

        DIFFERENTIAL_PROVIDER.setMonitorInterval(100);
    }

    @Override
    public void analogPinValueListener() {
        currentListener = new GpioPinListenerAnalog() {
            @Override
            public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event) {
                setListenerValue(event);
                System.out.println(DF.format(current));
            }
        };
    }

    @Override
  //The function below is doing allot of "actions". While returning a current value. The name of the function does not acurately represent what is going to occur.
    public void setListenerValue(GpioPinAnalogValueChangeEvent gpioEvent) {
        baseLine = 0.5; //why is this set here? Could be declared as a constant or set with a constructor.
        outputSensitivity = 0.133; //why is this set here? Could be declared as a constant or set with a constructor.
        value = gpioEvent.getValue();
        percent = ((value * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);
        voltage = DIFFERENTIAL_PROVIDER.getProgrammableGainAmplifier(gpioEvent.getPin()).getVoltage();
        current = (voltage - baseLine) /outputSensitivity;
    }

    @Override
    public double getDataValue() {
        return 0;
    }
}
