package ADS;

import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1015Pin;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider.ProgrammableGainAmplifierValue;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import com.pi4j.io.gpio.Pin;
import com.pi4j.jni.I2C;

import java.io.IOException;
import java.text.DecimalFormat;

public class ADSForce{

    public void DifferentialReadings() throws InterruptedException, UnsupportedBusNumberException, IOException {

        // number formatters
        final DecimalFormat df = new DecimalFormat("#.##");
        final DecimalFormat pdf = new DecimalFormat("###.#");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // create custom ADS1015 GPIO provider
        final DifferentialGpioProvider DIFF = new DifferentialGpioProvider(I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x49); //ADC1 address 1001001

        // provision gpio analog input pins from ADS1015
        GpioPinAnalogInput differentialInputs[] = {
                gpio.provisionAnalogInputPin(DIFF, ADS1015PinDifferential.INPUT_A0_A1, "A0-A1"), //force pins
        };

        // PGA value PGA_4_096V is a 1:1 scaled input,
        // so the output values are in direct proportion to the detected voltage on the input pins
        DIFF.setProgrammableGainAmplifier(ProgrammableGainAmplifierValue.PGA_4_096V, ADS1015Pin.ALL);

        // create analog pin value change listener
        GpioPinListenerAnalog listener = new GpioPinListenerAnalog()
        {
            @Override
            public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event)
            {
                final double baseline = 12.25; //
                final double outputSensitivity = -4.9; //
                // RAW value
                double value = event.getValue();

                // percentage
                double percent =  ((value * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);

                // approximate voltage ( *scaled based on PGA setting )
                double voltage = DIFF.getProgrammableGainAmplifier(event.getPin()).getVoltage() * (percent/100);

                double force = (voltage * outputSensitivity) + baseline; //converts voltage reading into force

                // display output
                System.out.println(" (" + event.getPin().getName() +"): VOLTS = " + df.format(voltage) + "V");
                System.out.println(" (" + event.getPin().getName() + "): FORCE = " + df.format(force) + "N");

            }
        };

        differentialInputs[0].addListener(listener); //A0_A1 force reading

        // keep program running for 10 minutes
        Thread.sleep(600000);

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Exiting ADS1015GpioExample");
    }
}
