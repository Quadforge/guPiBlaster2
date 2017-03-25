import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIArrows {

    //makes the JButton variables global
    private JButton upbutton;
    private JButton downbutton;
    //makes the JPanel global variables
    private JPanel arrowpanel;
    private double incrementer = 1.0;
    ///creates the Incrementer double variable

    public GUIArrows() {
        //UpArrow();
        //DownArrow();

        arrowpanel = new JPanel(); //creates second JPanel for the arrows
        arrowpanel.setLayout(new GridBagLayout());
        //gives button GridBagLayout

        arrowpanel.setBackground(null);
        //removes the default panel background

    }

    public void UpArrow(){
        ServoIncrt pulseWidth = new ServoIncrt();
        //creates the inner class, and makes actionlistener a variable
        GridBagConstraints gbc = new GridBagConstraints();
        //creates the gridbagconstraints to be used
        ImageIcon upArrow = new ImageIcon("/home/otakusenseihig/IdeaProjects/TestingFeatures/upArrow.png");
        //adds an image to the upbutton

        upbutton = new JButton(upArrow);
        //makes upbutton a global variable
        upbutton.addActionListener(pulseWidth);

        upbutton.setBorder(BorderFactory.createEmptyBorder());
        //removes the border of upbutton
        upbutton.setContentAreaFilled(false);
        //removes the area around the button

        gbc.weightx = 1;
        //extends the horizontal weight
        gbc.gridx = 0;
        gbc.gridy = 0;
        //sends the upbutton to coordinates (0, 0)
        gbc.insets = new Insets(0, 0, 0, 0);
        //Insets (top, left, bottom, right);
        //seperates from the left side by 100 and the bottom by 50
        gbc.anchor = GridBagConstraints.LINE_END;
        //moves the upbutton to the left most of the frame

        arrowpanel.add(upbutton, gbc);
        //implements the upbutton and gbc to the panel
    }

    public void DownArrow(){
        ServoIncrt pulseWidth = new ServoIncrt();
        //creates the inner class, and makes actionlistener a variable
        GridBagConstraints gbc = new GridBagConstraints();
        //creates the gridbagconstraints to be used
        ImageIcon downArrow = new ImageIcon("/home/otakusenseihig/IdeaProjects/TestingFeatures/downArrow.png");
        //adds an image to the downbutton

        downbutton = new JButton(downArrow);
        //makes downbutton a global variable
        downbutton.addActionListener(pulseWidth);

        downbutton.setBorder(BorderFactory.createEmptyBorder());
        //removes the border of upbutton
        downbutton.setContentAreaFilled(false);
        //removes the area around the button

        gbc.gridx = 1;
        gbc.gridy = 0;
        //sends the downbutton to coordinates (0,1)
        gbc.anchor = GridBagConstraints.LINE_START;
        //moves the downbutton to the left most of the frame

        arrowpanel.add(downbutton, gbc);
        //implementes the downbutton and gbc to the panel
    }

    public class ServoIncrt implements ActionListener {
        //creates an inner class that implements ActionListener

        public void actionPerformed(ActionEvent e) {
            //creates the actionPerformed method

            if (e.getSource() == upbutton && incrementer <= 2.0) {
                //conditional if upbutton is clicked and limit is less or equal to 2
                incrementer += 0.1;
                //increments + .1
                if (Math.floor(incrementer) == 2.0) {
                    //@param Math.floor rounds the output of adding .1 down
                    upbutton.setText("MAX");
                }
            }
            if (e.getSource() == downbutton && incrementer >= 1.0) {
                //conditional if downbutton is clicked and limit is greater or equal to 1
                incrementer -= 0.1;
                //increments - .1
                if (Math.ceil(incrementer) == 1.0) {
                    //Math.ceil rounds number up
                    downbutton.setText("MAX");
                }
            }
        }
    }
    /**
     * returns the JButton
     * @return creates the upbutton
     */
    public JButton getUpbutton() {return upbutton;}
    /**
     * returns the JButton
     * @return creates the downbutton
     */
    public JButton getDownbutton() {return downbutton;}
    /**
     * returns the arrowpanel
     * @return Arrowpanel the arrowpanel. It contains these JButtons
     */
    public JPanel getArrowpanel() {return arrowpanel;}
    /**
     * returns the incrementer
     * @return Incrementer the incrementer.
     */
    public double getIncrementer() {return incrementer;}
}
