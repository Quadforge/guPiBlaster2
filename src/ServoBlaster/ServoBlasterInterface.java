package ServoBlaster;

import java.io.IOException;

public interface ServoBlasterInterface<T>  {

    void startServoBlaster() throws IOException;

    void stopServoBlaster() throws IOException;

    //void automaticMode(int T) throws InterruptedException;

    void setSliderValue(int T) throws InterruptedException;

}