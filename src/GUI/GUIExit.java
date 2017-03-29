import javax.swing.*;
import java.awt.*;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIExit {

    private JPanel exitpanel;
    private JButton exitbutton;

    public GUIExit(){
        ExitButton();
    }

    public void ExitButton(){
        exitpanel = new JPanel();
        //makes the panel a global variable
        exitpanel.setLayout(new BorderLayout());

        ImageIcon closebt = new ImageIcon("enter closebt.png location here");
        //imports picture for the exitbutton
        exitbutton = new JButton(closebt);
        //makes the exitbutton a global variable and imports image
        exitbutton.addActionListener(e -> exitButtonClick());
        //makes exit button activate a shorter version of actionlistener (lambda)

        exitbutton.setBorder(BorderFactory.createEmptyBorder());
        //removes the exitbutton border
        exitbutton.setContentAreaFilled(false);
        //removes the border and area around the button

        exitpanel.add(exitbutton, BorderLayout.NORTH);
        //adds button to panel and the borderlayout north
        exitpanel.setBackground(null);
        //removes the default panel button
    }

    void exitButtonClick(){
        System.exit(0);
        //closes program on click
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
