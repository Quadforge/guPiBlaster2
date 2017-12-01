package Interfaces;//package ADS;

import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;

public interface ADSInterface<T> {
    void setupGpio();
    void analogPinValueListener();
    void setListenerValue(GpioPinAnalogValueChangeEvent gpioEvent);
    double getDataValue();
}
