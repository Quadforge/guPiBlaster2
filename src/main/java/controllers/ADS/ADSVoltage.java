package ADS;

import com.pi4j.gpio.extension.ads.ADS1015GpioProvider;
import com.pi4j.gpio.extension.ads.ADS1015Pin;
import com.pi4j.gpio.extension.ads.ADS1x15GpioProvider;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.text.DecimalFormat;

public class ADSVoltage {

    private GpioController gpio = GpioFactory.getInstance();
    private GpioPinListenerAnalog listener;
    final DecimalFormat df = new DecimalFormat("#.##");

    public double Voltage;

    public void readVoltage() throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        ADS1015GpioProvider gpioProvider = new QuadGpioProvider(I2CBus.BUS_1, ADS1015GpioProvider.ADS1015_ADDRESS_0x48);

        GpioPinAnalogInput myInputs[] = {
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A0, "A0"),
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A1, "A1"),
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A2, "A2"),
                gpio.provisionAnalogInputPin(gpioProvider, ADS1015Pin.INPUT_A3, "A3")};

        //sets all analog inputs with the gain amplifier value of +- 4.096V
        gpioProvider.setProgrammableGainAmplifier(ADS1x15GpioProvider.ProgrammableGainAmplifierValue.PGA_4_096V, ADS1015Pin.ALL);

        gpioProvider.setEventThreshold(500, ADS1015Pin.ALL);

        gpioProvider.setMonitorInterval(100);

        listener = new GpioPinListenerAnalog() {
            @Override
            public void handleGpioPinAnalogValueChangeEvent(GpioPinAnalogValueChangeEvent event) {
                //sets raw value of gpio
                double rawValue = event.getValue();

                double percent = ((rawValue * 100) / ADS1015GpioProvider.ADS1015_RANGE_MAX_VALUE);

                //votage = gets voltage from pin * (percent /100)
                Voltage = gpioProvider.getProgrammableGainAmplifier(event.getPin()).getVoltage() * (percent / 100);

                System.out.println(" (" + event.getPin().getName() + ") : VOLTS=" + df.format(Voltage));
                       // "| PERCENT=" + pdf.format(percent) + "% | RAW=" + value + "       ");
            }
        };
        myInputs[0].addListener(listener);  //A0
        myInputs[1].addListener(listener);  //A1
        myInputs[2].addListener(listener);  //A2
        myInputs[3].addListener(listener);  //A3

        Thread.sleep(5000);

        gpio.shutdown();
    }
}
