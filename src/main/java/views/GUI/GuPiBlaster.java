package GUI;

import ADS.Voltage.ADSReadVoltage;
import HelperFunctions.ReturnADSReadings;
import com.pi4j.io.i2c.I2CFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GuPiBlaster extends JFrame {
    private JPanel mainPanel;
    private JPanel readingsPanel;
    private JPanel readingsTextBoxPanel;
    private JPanel readingLabelUnits;
    private JPanel servoBlasterPanel;

    private JButton startSensors;

    //TextBox
    public JTextField currentBox, forceBox, temperatureBox, voltageBox;
    private JLabel currentLabel, forceLabel, temperatureLabel, voltageLabel;

    ReturnADSReadings getReadings = new ReturnADSReadings();
    ADSReadVoltage readVoltage = new ADSReadVoltage();

    public GuPiBlaster(String windowTitle) throws IOException, I2CFactory.UnsupportedBusNumberException {
        setTitle(windowTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(mainPanel);
        pack();
        setVisible(true);
    }

    public void buildPanel() throws IOException {
        mainPanel = new JPanel(new GridLayout(1,2));

        readingsPanel = new JPanel(new GridLayout(1,1));
        readingsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        readingsTextBoxPanel = new JPanel(new GridLayout(4,1));
        readingLabelUnits = new JPanel(new GridLayout(4,1));

        //Button not working
        servoBlasterPanel = new JPanel();
        startSensors = new JButton("Start Sensor");

        currentLabel = new JLabel("Amps");
        currentBox = new JTextField(String.valueOf(getReadings.getCurrent()));
        currentBox.setEditable(false);

        forceLabel = new JLabel("Newtons");
        forceBox = new JTextField(String.valueOf(getReadings.getForce()));
        forceBox.setEditable(false);

        temperatureLabel = new JLabel("Celsius");
        temperatureBox = new JTextField(String.valueOf(getReadings.getTemperature()));
        temperatureBox.setEditable(false);

        voltageLabel = new JLabel("Volts");
        voltageBox = new JTextField(String.valueOf(getReadings.getVoltage()));
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

        servoBlasterPanel.add(startSensors);

        mainPanel.add(readingsPanel);
        mainPanel.add(servoBlasterPanel);

    }
}
