import javax.swing.*;
import java.awt.*;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIAM {
    /**
     * creates the auto and the manual buttons
     */
    private JButton autobutton;
    private JButton manbutton;
    /**
     * creates the ampanel
     */
    private JPanel ampanel;

    public GUIAM(){
        /**
         * the methods created for the file
         */
        AutoButton();
        ManButton();

        /**
         * creates a panel for the auto and manual and creates the layout
         */
        ampanel = new JPanel();
        ampanel.setLayout(new GridLayout(1, 2,10,0));
        /**
         * adds the buttons to the panel
         */
        ampanel.add(autobutton);
        ampanel.add(manbutton);

        ampanel.setBackground(null);

    }
    public void AutoButton(){
        Font myFont = new Font("Dialog", Font.BOLD, 28);
        autobutton = new JButton("AUTO");
        autobutton.setFont(myFont);
        autobutton.setForeground(Color.red);
        //autobutton.setBackground(Color.black);
        //autobutton.setBorder(BorderFactory.createLineBorder(Color.black));
        /**
         * input code here
         */
    }
    public void ManButton(){
        Font myFont = new Font("Dialog", Font.BOLD, 28);
        manbutton = new JButton("MANUAL");
        manbutton.setFont(myFont);
        manbutton.setForeground(Color.red);
        //manbutton.setBackground(Color.black);
        //manbutton.setBorder(BorderFactory.createLineBorder(Color.black));
        /**
         * input code here
         */
    }
    /**returns the JButton
     *@return creates the autobutton
     */
    public JButton getAutobutton(){return autobutton;}
    /**returns the JButton
     *@return creates the downbutton
     */
    public JButton getManbutton(){return manbutton;}
    /**returns the ampanel
     * @return Ampanel the ampanel. It contains these JButtons
     */
    public JPanel getAmpanel(){return ampanel;}
}
