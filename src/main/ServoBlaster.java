package main;

import com.pi4j.io.gpio.*;


public class ServoBlaster {

    private long pulseWidth;
    private long waitTime;

    private int[] intervals = {1000, 1100, 1200, 1300, 1400, 1500,
                                1600, 1700, 1800, 1900, 2000};

    /*public ServoBlaster(long pulseWidth, long waitTime) throws InterruptedException {*/
    public ServoBlaster(long waitTime) throws InterruptedException {
        final GpioController GPIO;
        final GpioPinDigitalOutput PIN;

        GPIO = GpioFactory.getInstance();
        PIN = GPIO.provisionDigitalOutputPin(RaspiPin.GPIO_07, "PinLED", PinState.HIGH);

        //PIN.low();

        for (int j = 0; j < intervals.length; j++){                 //This loop use the interval array
                pulseWidth = intervals[j];                          //setting pulseWidth equal to interval from 0-11, index
                Thread.sleep(waitTime);                             //Turn off the LED
                /*System.out.println(pulseWidth/1000.00);*/
                System.out.println(pulseWidth/1000.00 + " sec");    //To Display the current measure of time which is seconds
                PIN.pulse(pulseWidth, true);               //Grab the input parameter from ServoBlasterTest, then passes
                                                                    //though loop.
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
