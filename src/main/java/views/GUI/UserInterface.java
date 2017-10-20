package GUI;

import javax.swing.*;
import java.util.Hashtable;

public class UserInterface extends JFrame {
    private JPanel labelPanel;
    private JPanel readingsPanel;
    private JLabel tempLabel;
    private JLabel currentLabel;
    private JLabel forceLabel;
    private JLabel voltageLabel;
    private JSlider servoSlider;
    private JTextField temperatureDisplay;
    private JTextField currentDisplay;
    private JTextField voltageDisplay;
    private JTextField forceDisplay;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel dataPanel;
    private JPanel servoBlasterPanel;
    private JPanel SliderLabel;
    private JLabel pwm1;
    private JLabel pwm2;
    private JLabel OFF;
    private JLabel pwm3;
    private JLabel pwm4;
    private JLabel pwm5;
    private JLabel pwm6;
    private JLabel pwm7;
    private JLabel pwm8;
    private JLabel pwm9;
    private JLabel pwm10;
    private JLabel pwm11;
    private JLabel pwm12;
    private JLabel pwm13;
    private JTabbedPane tabbedPane1;
    private JPanel aboutTabbedPanel;
    private JPanel settingsTabbedPanel;
    private JPanel exportsTabbedPanel;
    private JTextPane quageforgeMCCTextPane;

    private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();

    public UserInterface(){
        setTitle("ServoSliderTest");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(mainPanel);
        //pack();
        setVisible(true);

    }

    public static void main(String[] args){
        new UserInterface();

    }
}
