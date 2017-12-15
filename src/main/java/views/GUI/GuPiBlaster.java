import ADS.Current.ADSReadCurrent;
import ADS.Force.ADSReadForce;
import ADS.Voltage.ADSReadVoltage;
import ServoBlaster.MainServoBlaster;
import com.pi4j.io.i2c.I2CFactory;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public class GuPiBlaster extends JFrame {
    private JPanel mainPanel;
    private JPanel readingsPanel;
    private JPanel readingsTextBoxPanel;
    private JPanel readingLabelUnits;
    private JPanel servoBlasterPanel;

    private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
    private JSlider servoBlasterSlider;


    //TextBox
    public JTextField currentBox, forceBox, temperatureBox, voltageBox;
    private JLabel currentLabel, forceLabel, temperatureLabel, voltageLabel;

/*
    ReadAndWriteText readADS = new ReadAndWriteText();
*/
    ADSReadVoltage getVoltage = new ADSReadVoltage();
    ADSReadCurrent getCurrent = new ADSReadCurrent();
    ADSReadForce getForce = new ADSReadForce();


    public GuPiBlaster(String windowTitle) throws IOException, I2CFactory.UnsupportedBusNumberException {
        setTitle(windowTitle);
        startADSReadings();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(mainPanel);
        pack();
        setVisible(true);
    }

    public void buildPanel() throws FileNotFoundException {
        mainPanel = new JPanel(new GridLayout(1,2));

        readingsPanel = new JPanel(new GridLayout(1,1));
        readingsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        readingsTextBoxPanel = new JPanel(new GridLayout(4,1));
        readingLabelUnits = new JPanel(new GridLayout(4,1));

        //Button not working
        servoBlasterPanel = new JPanel();
        //servoBlasterPanel.add(getServoBlasterSlider());

        currentLabel = new JLabel("Amps");
        currentBox = new JTextField(String.valueOf(getCurrent.DF.format(getCurrent.getDataValue())));
        currentBox.setEditable(false);

        forceLabel = new JLabel("Newtons");
        forceBox = new JTextField(String.valueOf(getForce.DF.format(getForce.getDataValue())));
        forceBox.setEditable(false);

        temperatureLabel = new JLabel("Celsius");
        temperatureBox = new JTextField();
        temperatureBox.setEditable(false);

        voltageLabel = new JLabel("Volts");
        voltageBox = new JTextField(String.valueOf(getVoltage.DF.format(getVoltage.getDataValue())));
        voltageBox = new JTextField();

        voltageBox.setEditable(false);

        readingsTextBoxPanel.add(currentBox);
        readingsTextBoxPanel.add(voltageBox);
        readingsTextBoxPanel.add(forceBox);
        readingsTextBoxPanel.add(temperatureBox);

        readingLabelUnits.add(currentLabel);
        readingLabelUnits.add(voltageLabel);
        readingLabelUnits.add(forceLabel);
        readingLabelUnits.add(temperatureLabel);

        readingsPanel.add(readingsTextBoxPanel);
        readingsPanel.add(readingLabelUnits);

        mainPanel.add(readingsPanel);
        mainPanel.add(servoBlasterPanel);

    }
    /*public JSlider getServoBlasterSlider(){
        servoBlasterSlider = new JSlider(JSlider.VERTICAL, 900, 2000);
        labelTable.put(new Integer(800), new JLabel("OFF"));
        labelTable.put(new Integer(890), new JLabel("1.0"));
        labelTable.put(new Integer(970), new JLabel("1.1"));
        labelTable.put(new Integer(1070), new JLabel("1.2"));
        labelTable.put(new Integer(1150), new JLabel("1.3"));
        labelTable.put(new Integer(1242), new JLabel("1.4"));
        labelTable.put(new Integer(1322), new JLabel("1.5"));
        labelTable.put(new Integer(1410), new JLabel("1.6"));
        labelTable.put(new Integer(1502), new JLabel("1.7"));
        labelTable.put(new Integer(1590), new JLabel("1.8"));
        labelTable.put(new Integer(1670), new JLabel("1.9"));
        labelTable.put(new Integer(1762), new JLabel("2.0"));
        labelTable.put(new Integer(1850), new JLabel("2.1"));
        labelTable.put(new Integer(1942), new JLabel("2.2"));
        servoBlasterSlider.setMajorTickSpacing(90);
        servoBlasterSlider.setSnapToTicks(true);
        servoBlasterSlider.setValue(900);
        servoBlasterSlider.setPaintTicks(true);
        servoBlasterSlider.setLabelTable(labelTable);
        servoBlasterSlider.setPaintLabels(true);
        return servoBlasterSlider;
    }*/

    public void startADSReadings(){
        getVoltage.analogPinValueListener();
        getCurrent.analogPinValueListener();
        getForce.analogPinValueListener();
        getVoltage.DIFF_ANALOG_INPUTS[0].addListener(getVoltage.voltageListener);
        getCurrent.DIFF_ANALOG_INPUTS[0].addListener(getCurrent.currentListener);
        getForce.DIFF_ANALOG_INPUTS[0].addListener(getForce.forceListener);
    }

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        GuPiBlaster runADS = new GuPiBlaster("blaster");
       /* MainServoBlaster servoBlaster = new MainServoBlaster();
        servoBlaster.startProgram();
            servoBlaster.setSliderValue(runADS.servoBlasterSlider.getValue());
*/

    }
}
