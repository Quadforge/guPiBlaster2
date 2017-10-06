package GUI;

import ServoBlaster.MainServoBlaster;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Hashtable;

public class ServoBlasterSliderGUI extends JFrame {

    JSlider servoSlider;

    static JPanel mainPanel;

    Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();

    int minMicroSec = 800;
    int maxMicroSec = 2000;

    public ServoBlasterSliderGUI(){
        setTitle("ServoSliderTest");
        setSize(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        add(mainPanel);
        setVisible(true);

    }
    public void buildGUI(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,1));
        servoSlider = new JSlider(minMicroSec, maxMicroSec);

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

        servoSlider.setMajorTickSpacing(90);
        servoSlider.setSnapToTicks(true);
        servoSlider.setValue(minMicroSec);
        servoSlider.setPaintTicks(true);
        servoSlider.setLabelTable(labelTable);
        servoSlider.setPaintLabels(true);

        mainPanel.add(servoSlider);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        ServoBlasterSliderGUI test = new ServoBlasterSliderGUI();
        MainServoBlaster sliderTest = new MainServoBlaster();
        sliderTest.StartServoBlaster();

        while(true){
            sliderTest.slider(test.servoSlider.getValue());
        }
    }
}
