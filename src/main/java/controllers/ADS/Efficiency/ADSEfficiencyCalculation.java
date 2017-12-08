package ADS.Efficiency;

import HelperFunctions.ReadAndWriteText;

import java.io.IOException;
import ADS.Current.ADSReadCurrent;
import ADS.Force.ADSReadForce;
import ADS.Voltage.ADSReadVoltage;
import com.pi4j.io.i2c.I2CFactory;


public class ADSEfficiencyCalculation{

    protected double mass; // force / acceleration
    protected double power; // voltage * current
    protected double efficiency; // mass / power
    private final double acceleration = 9.80665; // m/s^2

    ADSReadForce force = new ADSReadForce();
    ADSReadVoltage voltage = new ADSReadVoltage();

    public ADSEfficiencyCalculation() throws IOException, I2CFactory.UnsupportedBusNumberException {

    }

    public ADSEfficiencyCalculation(int v) throws IOException, I2CFactory.UnsupportedBusNumberException {
        force.analogPinValueListener();
        force.DIFF_ANALOG_INPUTS[v].addListener(force.forceListener);
    }

    public void Efficiency()  {

        //System.out.println(ADSReadForce.getDataValue());
    }
    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException {
        ADSEfficiencyCalculation voltageCalc = new ADSEfficiencyCalculation(0);
        System.out.println(voltageCalc.force.getDataValue());
    }

}

