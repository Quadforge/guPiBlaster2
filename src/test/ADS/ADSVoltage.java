/*
package ADS;
import java.io.IOException;
import java.text.DecimalFormat;

import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1015Pin;
import com.pi4j.gpio.extension.ads.ADS1115Pin;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider.ProgrammableGainAmplifierValue;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalog;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;


public class ADSVoltage {

    public double voltage;

    public void DifferentialReadings() throws InterruptedException, UnsupportedBusNumberException, IOException {

        // number formatters
        final DecimalFormat df = new DecimalFormat("#.##");
        final DecimalFormat pdf = new DecimalFormat("###.#");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // create custom ADS1015 GPIO provider
        final DifferentialGpioProvider DIFF = new DifferentialGpioProvider(I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x48);

        // provision gpio analog input pins from ADS1015
        GpioPinAnalogInput differentialInputs[] = {
                gpio.provisionAnalogInputPin(DIFF, ADS1015DifferentialPins.INPUT_A0_A1, "A0-A1"),
                gpio.provisionAnalogInputPin(DIFF, ADS1015DifferentialPins.INPUT_A2_A3, "A2-A3"),

        };

        // ATTENTION !!
        // It is important to set the PGA (Programmable Gain Amplifier) for all analog input pins.
        // (You can optionally set each input to a different value)
        // You measured input voltage should never exceed this value!
        //
        // In my testing, I am using a Sharp IR Distance Sensor (GP2Y0A21YK0F) whose voltage never exceeds 3.3 VDC
        // (http://www.adafruit.com/products/164)
        //
        // PGA value PGA_4_096V is a 1:1 scaled input,
        // so the output values are in direct proportion to the detected voltage on the input pins
        DIFF.setProgrammableGainAmplifier(ProgrammableGainAmplifierValue.PGA_4_096V, ADS1015Pin.ALL);


        // Define a threshold value for each pin for analog value change events to be raised.
        // It is important to set this threshold high enough so that you don't overwhelm your program with change events for insignificant changes
        DIFF.setEventThreshold(500, ADS1015Pin.ALL);


        // Define the monitoring thread refresh interval (in milliseconds).
        // This governs the rate at which the monitoring thre ad will read input values from the ADC chip
        // (a value less than 50 ms is not permitted)
        DIFF.setMonitorInterval(100);


        // create analog pin value change listener
        GpioPinListenerAnalog listener = new GpioPinListenerAnalog()
        {
            @Override
            public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event)
            {
                // RAW value
                double value = event.getValue();

                // percentage
                double percent =  ((value * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);

                // approximate voltage ( *scaled based on PGA setting )
                 voltage = DIFF.getProgrammableGainAmplifier(event.getPin()).getVoltage() * (percent/100);

                // display output
                System.out.println(" (" + event.getPin().getName() +") : VOLTS=" + df.format(voltage) + "  | PERCENT=" + pdf.format(percent) + "% | RAW=" + value + "       ");
            }
        };

        differentialInputs[0].addListener(listener);
        differentialInputs[1].addListener(listener);



        // keep program running for 10 minutes
        */
/*Thread.sleep(600000);

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Exiting ADS1015GpioExample");*//*

    }
}

*/
