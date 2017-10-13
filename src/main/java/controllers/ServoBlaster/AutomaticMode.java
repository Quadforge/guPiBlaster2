package ServoBlaster;

import GUI.ServoBlasterSliderGUI;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AutomaticMode extends ServoBlasterSliderGUI{
    private Timer timer;
    private int currentPulse = minMicroSec;


    private void countdownTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new IncreasePulse(), 0, 5000);
    }

    class IncreasePulse extends TimerTask{
        MainServoBlaster automatic = new MainServoBlaster();
        @Override
        public void run() {
            if (currentPulse < maxMicroSec){
                for (int i = currentPulse; i < maxMicroSec; i+=100){
                    try {
                        automatic.setSliderValue(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
