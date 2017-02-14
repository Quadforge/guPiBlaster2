package main;

import java.io.IOException;

public class ServoBlaster {

    int clockSpeed;
    int pwmRange;
    int waitTime;

    int[] servoPulses = {100, 120, 130, 140, 150, 160,
                         170, 180, 190, 200};

    public ServoBlaster(int clockSpeed, int pwmRange, int waitTime) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        runTime.exec("gpio mode 1 pwm");                //This would set WiringPi PWM to PIN01 or GPIO 12
        runTime.exec("gpio pwm-ms");                    //This would create a mark space
        runTime.exec("gpio pwmc " + clockSpeed);        //This would instruct WiringPi to set a PWM Clock Speed
        runTime.exec("gpio pwmr " + pwmRange);          //This would instruct WiringPi to set Range
        runTime.exec("gpio pwm 1 " + servoPulses[5]);   //This instruct WiringPi to set the Servo to turn in 90 degree

        Thread.sleep(waitTime);
        runTime.exec("gpio pwm 1 " + servoPulses[0]);   //This instruct WiringPi to set the Servo to turn in "0" degree
        Thread.sleep(waitTime);
        runTime.exec("gpio pwm 1 " + servoPulses[9]);   //This instruct WiringPi to set the Servo to turn in "180" degree
        Thread.sleep(waitTime);
        runTime.exec("gpio pwm 1 " + servoPulses[5]);   //This instruct WiringPi to set the Servo to turn it back to 90 degree
    }


    public void setClockSpeed(int setCS){
        clockSpeed = setCS;
    }
    public void setPwmRange(int setPWMR){
        pwmRange = setPWMR;
    }
    public void setWaitTime(int setWT){
        waitTime = setWT;
    }
    public int getClockSpeed(int getCS){
        clockSpeed = getCS;
        return clockSpeed;
    }
    public int getPwmRange(int getPWMR){
        pwmRange = getPWMR;
        return  getPWMR;
    }
    public int getWaitTime(int getWT){
        waitTime = getWT;
        return waitTime;
    }

}
