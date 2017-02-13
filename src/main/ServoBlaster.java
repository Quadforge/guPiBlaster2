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
        runTime.exec("gpio mode 1 pwm");
        runTime.exec("gpio pwm-ms");
        runTime.exec("gpio pwmc " + clockSpeed);
        runTime.exec("gpio pwmr " + pwmRange);
        runTime.exec("gpio pwm 1 " + servoPulses[5]);

        Thread.sleep(waitTime);
        runTime.exec("gpio pwm 1 " + servoPulses[0]);
        Thread.sleep(waitTime);
        runTime.exec("gpio pwm 1 " + servoPulses[9]);
        Thread.sleep(waitTime);
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
