package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class MainGUI extends JFrame{
    //Panel objects
    private JPanel mainPanel = new JPanel();
    private JPanel sensorReadingPanel;
    private JPanel servoControllerPanel;

    //Slider variables
    protected JSlider servoSlider;
    private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
    protected int minMicroSec = 900;
    protected int maxMicroSec = 2000;

    //Sensor reader Label and TextBox
    private JLabel temperature;
    private JLabel force;
    private JLabel current;
    private JLabel voltage;


    public MainGUI(){
        setTitle("guPiBlaster");
        setSize(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        buildServoSliderGUI();
        buildSensorReaderGUI();
        add(mainPanel);
        setVisible(true);
    }

    private void buildGUI() {
        mainPanel.setLayout(new GridLayout(1,2));

        sensorReadingPanel = new JPanel();

        servoControllerPanel = new JPanel();


        mainPanel.add(sensorReadingPanel);
        mainPanel.add(servoControllerPanel);
    }

    private void buildServoSliderGUI(){
        servoSlider = new JSlider( minMicroSec, maxMicroSec);

        labelTable.put(new Integer(900), new JLabel("OFF"));
        labelTable.put(new Integer(1000), new JLabel("1.0"));
        labelTable.put(new Integer(1100), new JLabel("1.1"));
        labelTable.put(new Integer(1200), new JLabel("1.2"));
        labelTable.put(new Integer(1300), new JLabel("1.3"));
        labelTable.put(new Integer(1400), new JLabel("1.4"));
        labelTable.put(new Integer(1500), new JLabel("1.5"));
        labelTable.put(new Integer(1600), new JLabel("1.6"));
        labelTable.put(new Integer(1700), new JLabel("1.7"));
        labelTable.put(new Integer(1800), new JLabel("1.8"));
        labelTable.put(new Integer(1900), new JLabel("1.9"));
        labelTable.put(new Integer(2000), new JLabel("2.0"));

        servoSlider.setOrientation(JSlider.VERTICAL);
        servoSlider.setMajorTickSpacing(100);
        servoSlider.setSnapToTicks(true);
        servoSlider.setValue(minMicroSec);
        servoSlider.setPaintTicks(true);
        servoSlider.setLabelTable(labelTable);
        servoSlider.setPaintLabels(true);

        mainPanel.add(servoSlider);
    }

    private void buildSensorReaderGUI(){
        temperature = new JLabel("C");
        force = new JLabel("N");
        current = new JLabel("amp");
        voltage = new JLabel("V");

        sensorReadingPanel.add(temperature);
        sensorReadingPanel.add(force);
        sensorReadingPanel.add(current);
        sensorReadingPanel.add(voltage);

        mainPanel.add(servoControllerPanel);
    }

    public static void main(String[] args){
        new MainGUI();
    }
}
