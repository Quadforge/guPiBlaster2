package ADS;

import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;

public interface ADSInterface<T> {
    void setupGpio();
    void analogPinValueListener();
    double setListerValue(GpioPinAnalogValueChangeEvent gpioEvent);
}
