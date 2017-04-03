import java.io.IOException;

public class ServoBlaster2 {

    String GpioPWM = "gpio pwm 1 ";

    int clockSpeed;
    int pwmRange;
    int waitTime;
                       // 0   1    2    3    4    5    6
    int[] servoPulses = {80, 90, 100, 110, 120, 130, 140,
            // 7    8    9   10   11    12   13   14
            150, 160, 170, 180, 190, 200, 210, 220};

    public ServoBlaster2(int clockSpeed, int pwmRange, int waitTime) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        runTime.exec("gpio mode 1 pwm");                //This would set WiringPi PWM to PIN01 or GPIO 12
        runTime.exec("gpio pwm-ms");                    //This would create a mark space
        runTime.exec("gpio pwmc " + clockSpeed);        //This would instruct WiringPi to set a PWM Clock Speed
        runTime.exec("gpio pwmr " + pwmRange);          //This would instruct WiringPi to set Range
        runTime.exec(GpioPWM + servoPulses[14]);        //This instruct WiringPi to set the Servo to turn in 180 degree

        Thread.sleep(waitTime);
        runTime.exec(GpioPWM + servoPulses[0]);   //This instruct WiringPi to set the Servo to turn in "0" degree
        Thread.sleep(waitTime);
        runTime.exec(GpioPWM + servoPulses[14]);   //This instruct WiringPi to set the Servo to turn in "180" degree
        Thread.sleep(waitTime);
        runTime.exec(GpioPWM + servoPulses[0]);   //This instruct WiringPi to set the Servo to turn it back to 0 degree
        Thread.sleep(waitTime);
        runTime.exec(GpioPWM + servoPulses[14]);
        Thread.sleep(waitTime);

        for (int cycle = 0; cycle <= 10; cycle++){
            if (cycle == 5)
                break;
            runTime.exec(GpioPWM + servoPulses[0]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[1]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[2]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[3]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[4]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[5]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[6]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[7]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[8]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[9]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[10]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[11]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[12]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[13]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[14]);
            Thread.sleep(waitTime);
            runTime.exec(GpioPWM + servoPulses[0]);
            Thread.sleep(waitTime);
        }
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
