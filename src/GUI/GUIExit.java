package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIExit {

    /**
     * creates the exitpanel
     */
    private JPanel exitpanel;
    /**
     * creates the exitbutton
     */
    private JButton exitbutton;

    public GUIExit(){
        ExitButton();
    }

    public void ExitButton(){
        /**
         * makes the panel a global variable
         */
        exitpanel = new JPanel();
        /**
         * sets the layout of the panel
         */
        exitpanel.setLayout(new BorderLayout());
	    Font myFont = new Font("Dialog", Font.BOLD, 50);

        /**
         * makes the exitbutton a global variable
         */
        exitbutton = new JButton("X");
	    exitbutton.setFont(myFont);
	    exitbutton.setForeground(Color.black);
	    exitbutton.setContentAreaFilled(false);

        /**
         * adds button to panel and the borderlayout north
         */
        exitpanel.add(exitbutton, BorderLayout.NORTH);
        /**
         * removes the default panel button
         */
        exitpanel.setBackground(null);


    }
    /**returns the JButton
     *@return creates the exitbutton
     */
    public JButton getExitbutton(){return exitbutton;}
    /**returns the exitpanel
     * @return Exitpanel the exitpanel. It contains these JButtons
     */
    public JPanel getExitpanel(){return exitpanel;}
}
