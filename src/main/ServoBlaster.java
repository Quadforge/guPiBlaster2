package main;

import com.pi4j.io.gpio.*;

public class ServoBlaster {

    /*public static void main (String[] args) throws InterruptedException {
        final GpioController GPIO;
        final GpioPinDigitalOutput PIN;

        GPIO = GpioFactory.getInstance();
        PIN = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PinLED", PinState.HIGH);

        Thread.sleep(500);

        PIN.low();

        for (int i = 0; i <=3; i++){        // This would make the LED Flash 5 times

            Thread.sleep(1000);

            PIN.pulse(1000, true);
        }

        GPIO.shutdown();
    }*/
    private long pulse;
    private long waitTime;

    public ServoBlaster(long pulse, long waitTime) throws InterruptedException {
        final GpioController GPIO;
        final GpioPinDigitalOutput PIN;

        GPIO = GpioFactory.getInstance();
        PIN = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PinLED", PinState.HIGH);

        //Thread.sleep(waitTime);
        Thread.sleep(pulse);

        PIN.low();

        for (int i = 0; i <=100000; i++){        // This would make the LED Flash 5 times

            //Thread.sleep(waitTime);
            Thread.sleep(pulse);

            PIN.pulse(pulse, true);
        }
        GPIO.shutdown();
    }

    public void setPulse(long setP){
        pulse = setP;
    }
    public long getPulse(long getP){
        pulse = getP;
        return this.pulse;
    }
    public void setWait(long setW){
        waitTime = setW;
    }
    public long getWait(long getW){
        waitTime = getW;
        return this.waitTime;
    }
}
