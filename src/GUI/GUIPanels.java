import javax.swing.*;
import java.awt.*;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIPanels {

    private GUIArrows arrowpanel;
    private JPanel currenttext;
    private JPanel voltagetext;
    private JPanel temptext;
    private JPanel forcetext;

    private JLabel incrt;
    private JLabel currentbox;
    private JLabel voltagebox;
    private JLabel tempbox;
    private JLabel forcebox;

    public GUIPanels(){
        //imports the variables from each class
        GUIArrows idk = new GUIArrows();
        GUIBox idk2 = new GUIBox();
        Font myFont = new Font("Dialog", Font.BOLD, 25);

        //the text to be displayed on the screen
        incrt = new JLabel(idk.getIncrementer() + " ms");
        incrt.setFont(myFont);
        incrt.setForeground(Color.black);
        currentbox = new JLabel("Current: " + idk2.getCurrent() + "/amps");
        currentbox.setFont(myFont);
        currentbox.setForeground(Color.black);
        voltagebox = new JLabel("Voltage: " + idk2.getVoltage() + "/volts");
        voltagebox.setFont(myFont);
        voltagebox.setForeground(Color.black);
        tempbox = new JLabel("Temperature: " + idk2.getTemp() + "°C");
        tempbox.setFont(myFont);
        tempbox.setForeground(Color.black);
        forcebox = new JLabel("Force: " + idk2.getForce() + " N");
        forcebox.setFont(myFont);
        forcebox.setForeground(Color.black);

        //activates gridbag placement variables
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();

        arrowpanel = new GUIArrows();

        arrowpanel.getArrowpanel().add(incrt);

        currenttext.setLayout(new GridBagLayout());
        currenttext = new JPanel();

        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;

        currenttext.add(currentbox, gbc);

        voltagetext.setLayout(new GridBagLayout());
        voltagetext = new JPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;

        voltagetext.add(voltagebox, gbc);

        temptext.setLayout(new GridBagLayout());
        temptext = new JPanel();

        gbc2.gridx = 0;
        gbc2.gridy = 0;

        temptext.add(tempbox, gbc2);

        forcetext.setLayout(new GridBagLayout());
        forcetext = new JPanel();

        gbc2.gridx = 0;
        gbc2.gridy = 0;

        forcetext.add(forcebox, gbc2);

    }
    /**returns the currenttext
     * @return Currenttext contains the currenttext
     */
    public JPanel getCurrenttext(){return currenttext;}
    /**returns the voltagetext
     * @return Voltagetext contains the voltagetext
     */
    public JPanel getVoltagetext(){return voltagetext;}
    /**returns the temptext
     * @return Temptext contains the temptext
     */
    public JPanel getTemptext(){return temptext;}
    /**returns the forcetext
     * @return Forcetext contains the forcetext
     */
    public JPanel getForcetext(){return forcetext;}
}
