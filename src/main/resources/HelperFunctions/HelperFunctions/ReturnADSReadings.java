package HelperFunctions;

import GUI.GuPiBlaster;
import com.pi4j.io.i2c.I2CFactory;

import javax.swing.*;
import java.io.IOException;

public class ReturnADSReadings {
    public double voltage;
    double current;
    double force;
    double temperature;

    //Getter and setter for voltage
    public double getVoltage(){
        return this.voltage;
    }
    public void setVoltage(double volt){
        this.voltage = volt;
        volt = voltage;
        voltage = volt;
        //System.out.println(voltage);
    }
    //getter and setters for current
    public void setCurrent(double curr){
        current = curr;
        //System.out.println(curr);
    }
    public double getCurrent(){
        return current;
    }
    //getter and setter for force
    public void setForce(double forc){
        force = forc;
    }
    public double getForce(){
        return force;
    }
    //getter and setter for temp
    public void setTemperature(double temp){
        temperature = temp;
    }
    public double getTemperature(){
        return temperature;
    }
    public void Print(){
        System.out.println(getVoltage());
    }
}
