package Interfaces;//package ADS;

import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;

public interface ADSInterface<T> {
    void setupGpio();
    void analogPinValueListener();
    double setListerValue(GpioPinAnalogValueChangeEvent gpioEvent);
}
