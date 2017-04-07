import javax.swing.*;
import java.awt.*;

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

        /**
         * imports picture for the exitbutton
         */
        ImageIcon closeBt = new ImageIcon("enter closebt.png location here");
        /**
         * makes the exitbutton a global variable and imports image
         */
        exitbutton = new JButton(closeBt);

        /**
         * makes exitbutton activate a shorter version of actionlistener (lambda)
         */
        exitbutton.addActionListener(e -> ExitbuttonClick());

        /**
         * removes the exitbutton border
         */
        exitbutton.setBorder(BorderFactory.createEmptyBorder());
        /**
         * removes the border and area around the button
         */
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
    /**
     * the created shortened actionlistener
     */
    void ExitbuttonClick(){
        /**
         * closes program on click
         */
        System.exit(0);

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
