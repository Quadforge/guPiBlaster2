import org.junit.Test;

import static org.junit.Assert.*;

import main.ServoBlaster;

/**
 * Created by codyfinn on 1/17/17.
 */
public class ServoBlasterTest {
    @Test
    public void setPulseWidth() throws Exception {
        ServoBlaster blaster = new ServoBlaster(1000);
        //assertEquals("0=1000", blaster.setPulseWidth(), "String is not in the proper format");
    }
}