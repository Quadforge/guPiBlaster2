package ADS;

import java.io.IOException;
import java.text.DecimalFormat;
import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1015Pin;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider.ProgrammableGainAmplifierValue;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;


public class ads {

    private GpioPinAnalogInput[] myInputs;

    public void ADS ()throws InterruptedException, UnsupportedBusNumberException, IOException {

        System.out.println("<--Pi4J--> ADS1015 GPIO Example ... started.");

        // number formatters
        final DecimalFormat df = new DecimalFormat("#.##");
        final DecimalFormat pdf = new DecimalFormat("###.#");

        final GpioController gpio = GpioFactory.getInstance();


        ADS1015GpioProvider gpioProvider = new QuadGpioProvider(I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x48);

        // provision gpio analog input pins from ADS1015
        GpioPinAnalogInput myInputs[] = {
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A0, "MyAnalogInput-A0"),
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A1, "MyAnalogInput-A1"),
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A2, "MyAnalogInput-A2"),
        };

        // .all refers to all different i2c adresses hooked up
        gpioProvider.setProgrammableGainAmplifier(ProgrammableGainAmplifierValue.PGA_4_096V, ADS1015Pin.ALL);


        // Define a threshold value for each pin for analog value change events to be raised.
        // It is important to set this threshold high enough so that you don't overwhelm your program with change events for insignificant changes
        gpioProvider.setEventThreshold(500, ADS1015Pin.ALL);


        // Define the monitoring thread refresh interval (in milliseconds).
        // This governs the rate at which the monitoring thread will read input values from the ADC chip
        // (a value less than 50 ms is not permitted)
        gpioProvider.setMonitorInterval(100);

        // create analog pin value change listener
        GpioPinListenerAnalog listener = new GpioPinListenerAnalog() {
            @Override
            public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event) {
                // RAW value
                double value = event.getValue();

                // percentage
                double percent = ((value * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);

                // approximate voltage ( *scaled based on PGA setting )
                double voltage = gpioProvider.getProgrammableGainAmplifier(event.getPin()).getVoltage() * (percent / 100);

                // display output
                System.out.println(" (" + event.getPin().getName() + ") : VOLTS=" + df.format(voltage) + "  " +
                        "| PERCENT=" + pdf.format(percent) + "% | RAW=" + value + "       ");

            }
      /* */ };

        myInputs[0].addListener(listener);
        myInputs[1].addListener(listener);
        myInputs[2].addListener(listener);
    do{
        for (GpioPinAnalogInput pin : myInputs) {
                double value = pin.getValue();
                double percent = ((value * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);
                double voltage = gpioProvider.getProgrammableGainAmplifier(pin).getVoltage() * (percent / 100);
                System.out.println(voltage);
            }
            Thread.sleep(1000);
        }while(1==1);

    }
}
