import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

public class GUIDriver extends GuPiBlaster {
    public GUIDriver(String windowTitle) throws IOException, I2CFactory.UnsupportedBusNumberException {
        super(windowTitle);
    }

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException {
        GuPiBlaster main = new GuPiBlaster("guPiBlaster");

    }
}
