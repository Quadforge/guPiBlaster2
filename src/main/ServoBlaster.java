package main;

import com.pi4j.io.gpio.*;

public class ServoBlaster {

    public static void main (String[] args) throws InterruptedException {
        final GpioController GPIO;
        final GpioPinDigitalOutput PIN;

        GPIO = GpioFactory.getInstance();
        PIN = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PinLED", PinState.HIGH);

        Thread.sleep(500);

        PIN.low();

        Thread.sleep(500);

        PIN.pulse(500, true);

        Thread.sleep(500);

        PIN.pulse(500, true);

        Thread.sleep(500);

        PIN.pulse(500, true);

        GPIO.shutdown();
    }
}
