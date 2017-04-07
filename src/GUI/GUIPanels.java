import javax.swing.*;
import java.awt.*;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIPanels {
    /**
     * creates the panels
     */
    private JPanel datapanel;
    private JPanel curt;
    private JPanel volts;
    private JPanel temp;
    private JPanel force;

    /**
     * creates the labels
     */
    private JLabel currentbox;
    private JLabel voltagebox;
    private JLabel tempbox;
    private JLabel forcebox;

    public GUIPanels(){
        /**
         * imports the variables from each class
         */
        GUITxT printVar = new GUITxT();
        Font myFont = new Font("Dialog", Font.BOLD, 20);

        /**
         * the text to be displayed on the screen
         */
        currentbox = new JLabel("Current: " + printVar.getCurrent() + "/amps");
        currentbox.setFont(myFont);
        currentbox.setForeground(Color.black);
        voltagebox = new JLabel("Voltage: " + printVar.getVoltage() + "/volts");
        voltagebox.setFont(myFont);
        voltagebox.setForeground(Color.black);
        tempbox = new JLabel("Temperature: " + printVar.getTemp() + "°C");
        tempbox.setFont(myFont);
        tempbox.setForeground(Color.black);
        forcebox = new JLabel("Force: " + printVar.getForce() + " N");
        forcebox.setFont(myFont);
        forcebox.setForeground(Color.black);

        curt = new JPanel();
        curt.setBackground(null);
        curt.setBorder(BorderFactory.createLineBorder(Color.black));
        volts = new JPanel();
        volts.setBackground(null);
        volts.setBorder(BorderFactory.createLineBorder(Color.black));
        temp = new JPanel();
        temp.setBackground(null);
        temp.setBorder(BorderFactory.createLineBorder(Color.black));
        force = new JPanel();
        force.setBackground(null);
        force.setBorder(BorderFactory.createLineBorder(Color.black));

        datapanel = new JPanel();
        datapanel.setLayout(new GridLayout(4, 2, 5, 5));

        datapanel.add(curt);
        datapanel.add(currentbox);

        datapanel.add(volts);
        datapanel.add(voltagebox);

        datapanel.add(temp);
        datapanel.add(tempbox);

        datapanel.add(force);
        datapanel.add(forcebox);

        datapanel.setBackground(null);

    }
    /**returns the datapanel
     * @return Datapanel contains the datapanel
     */
    public JPanel getDatapanel(){return datapanel;}
}
