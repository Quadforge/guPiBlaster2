package ADS.Force;

import ADS.ADS1015DifferentialPins;
import ADS.ADSInterface;
import ADS.DifferentialGpioProvider;
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

public class ADSReadForce implements ADSInterface {

    private double baseLine;
    private double outputSensitivity;
    private double value;
    private double percent;
    private double voltage;
    private double force;

    public GpioPinListener listener;

    protected  final DecimalFormat DF = new DecimalFormat("#.##");

    private final GpioController GPIO = GpioFactory.getInstance();

    private final DifferentialGpioProvider DIFFERENTIAL_PROVIDER = new DifferentialGpioProvider(I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x49);
    protected final GpioPinAnalog DIFF_ANALOG_INPUTS[] = {
            GPIO.provisionAnalogInputPin(DIFFERENTIAL_PROVIDER, ADS1015DifferentialPins.INPUT_A0_A1, "A0-A1")
    };


    public ADSReadForce() throws IOException, I2CFactory.UnsupportedBusNumberException {
        setupGpio();
    }

    @Override
    public void setupGpio() {
        DIFFERENTIAL_PROVIDER.setProgrammableGainAmplifier(ADS1x15GpioProvider.ProgrammableGainAmplifierValue.PGA_4_096V, ADS1015Pin.ALL);

        DIFFERENTIAL_PROVIDER.setEventThreshold(500, ADS1015Pin.ALL);

        DIFFERENTIAL_PROVIDER.setMonitorInterval(100);
    }

    @Override
    public void analogPinValueListener() {
        listener = new GpioPinListenerAnalog() {
            @Override
            public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event) {
                setListerValue(event);

            }
        };
    }

    @Override
    public double setListerValue(GpioPinAnalogValueChangeEvent gpioEvent) {
        baseLine = 12.25;
        outputSensitivity = -4.9;

        value = gpioEvent.getValue();
        percent = ((value * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);
        voltage = DIFFERENTIAL_PROVIDER.getProgrammableGainAmplifier(gpioEvent.getPin()).getVoltage() * (percent/100);
        return force = (voltage * outputSensitivity) + baseLine;

    }
}
