package main;

import com.pi4j.io.gpio.*;

public class ServoBlaster {

    public static void main (String[] args) throws InterruptedException {
        final GpioController GPIO;
        final GpioPinDigitalOutput PIN;

        GPIO = GpioFactory.getInstance();
        PIN = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PinLED", PinState.HIGH);

        Thread.sleep(1000);

        PIN.low();

        for (int i = 0; i <=3; i++){        // This would make the LED Flash 5 times

            Thread.sleep(1000);

            PIN.pulse(1000, true);
        }

        GPIO.shutdown();
    }
}
