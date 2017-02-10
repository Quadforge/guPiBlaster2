package main;

import com.pi4j.io.gpio.*;
import com.pi4j.io.spi.SpiDevice;


public class ServoBlaster {

    private long pulseWidth;
    private long waitTime;

    private double[] intervals = {1, 1.1, 1.2, 1.3, 1.4, 1.5,
                                1.6, 1.7, 1.8, 1.9, 2};

    /*public ServoBlaster(long pulseWidth, long waitTime) throws InterruptedException {*/
    public ServoBlaster(long waitTime) throws InterruptedException {
        final GpioController GPIO;
        final GpioPinDigitalOutput PIN;


        GPIO = GpioFactory.getInstance();
        PIN = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_01, "PinLED", PinState.HIGH);


        PIN.low();

        /*for (int j = 0; j < intervals.length; j++){                 //This loop use the interval array
                pulseWidth = (long) intervals[j];                          //setting pulseWidth equal to interval from 0-11, index
                Thread.sleep(waitTime);                             //Turn off the LED
                //System.out.println(pulseWidth/1000.00);
                System.out.println(pulseWidth/1000.00 + " sec");    //To Display the current measure of time which is seconds
                PIN.pulse(pulseWidth, true);               //Grab the input parameter from ServoBlasterTest, then passes
                PIN.low();                                                    //though loop.
                Thread.sleep(waitTime);
        }*/
        for (int i = 1; i < 5; i ++) {


            /*PIN.high();
            Thread.sleep((long) 1.0);
            PIN.low();
            Thread.sleep(1000);*/

            PIN.high();
            Thread.sleep((long) 0.15);
            PIN.low();
            Thread.sleep(1000);

            /*PIN.high();
            Thread.sleep((long) 2.0);
            PIN.low();
            Thread.sleep(1000);*/
        }
        GPIO.shutdown();
    }

    public void setPulse(long setP){
        pulseWidth = setP;
    }
    public long getPulse(long getP){
        pulseWidth = getP;
        return this.pulseWidth;
    }
    public void setWait(long setW){
        waitTime = setW;
    }
    public long getWait(long getW){
        waitTime = getW;
        return this.waitTime;
    }
}
