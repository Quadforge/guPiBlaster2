package GUI;

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
    /**
     * imports the variables from each class
     */
    private GUITxT printVar = new GUITxT();
    private Font myFont = new Font("Dialog", Font.BOLD, 20);

    public GUIPanels(){
        /**
         * the methods used in the file
         */
        Current();
        Voltage();
        Temperature();
        Force();
        /**
         * the main panel of the file
         */
        datapanel = new JPanel();

        /**
         * creates a gridlayout for the panel and labels
         */
        datapanel.setLayout(new GridLayout(4, 2,20,5));

        /**
         * the boxes and labels with their "neighbors"
         */
        datapanel.add(curt);
        datapanel.add(currentbox);

        datapanel.add(voltagebox);
        datapanel.add(volts);

        datapanel.add(tempbox);
        datapanel.add(temp);

        datapanel.add(forcebox);
        datapanel.add(force);

        datapanel.setBackground(null);
    }
    public void Current(){
        /**
         * the text to be displayed on the screen
         */
        currentbox = new JLabel("Current: " + printVar.getCurrent() + "/amps");
        currentbox.setFont(myFont);
        currentbox.setForeground(Color.black);
        /**
         * the box panel that will take in the graph type design
         */
        curt = new JPanel();
        curt.setBackground(null);
        curt.setBorder(BorderFactory.createLineBorder(Color.black));
        /**
         * insert code here
         */
    }
    public void Voltage(){
        /**
         * the text to be displayed on the screen
         */
        voltagebox = new JLabel("Voltage: " + printVar.getVoltage() + "/volts");
        voltagebox.setFont(myFont);
        voltagebox.setForeground(Color.black);
        /**
         * the box panel that will take in the graph type design
         */
        volts = new JPanel();
        volts.setBackground(null);
        //volts.setBorder(BorderFactory.createLineBorder(Color.black));
        /**
         * insert code here
         */
    }
    public void Temperature(){
        /**
         * the text to be displayed on the screen
         */
        tempbox = new JLabel("Temperature: " + printVar.getTemp() + "°C");
        tempbox.setFont(myFont);
        tempbox.setForeground(Color.black);
        tempbox.setBackground(null);
        /**
         * the box panel that will take in the graph type design
         */
        temp = new JPanel();
        temp.setBackground(null);
        //temp.setBorder(BorderFactory.createLineBorder(Color.black));
        /**
         * insert code here
         */
    }
    public void Force(){
        /**
         * the text to be displayed on the screen
         */
        forcebox = new JLabel("Force: " + printVar.getForce() + " N");
        forcebox.setFont(myFont);
        forcebox.setForeground(Color.black);
        /**
         * the box panel that will take in the graph type design
         */
        force = new JPanel();
        force.setBackground(null);
        //force.setBorder(BorderFactory.createLineBorder(Color.black));
        /**
         * insert code here
         */
    }
    /**returns the datapanel
     * @return Datapanel contains the datapanel
     */
    public JPanel getDatapanel(){return datapanel;}
}
