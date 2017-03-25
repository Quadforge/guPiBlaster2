import javax.swing.*;
import java.awt.*;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIAM {

    private JButton autobutton;
    private JButton manbutton;
    private JPanel ampanel;

    public GUIAM(){
        AutoButton();
        ManButton();
        //creates a panel for the auto and manual
        ampanel = new JPanel();
        //ampanel.setLayout(new GridLayout(1,2));

        Font myFont = new Font("Dialog", Font.BOLD, 25);

        autobutton = new JButton("AUTO");
        autobutton.setFont(myFont);
        autobutton.setBackground(Color.black);

        ampanel.add(autobutton);

        manbutton = new JButton("MANUAL");
        manbutton.setFont(myFont);
        manbutton.setBackground(Color.black);

        ampanel.add(manbutton);

        ampanel.setBackground(null);

    }
    public void AutoButton(){

    }
    public void ManButton(){

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
