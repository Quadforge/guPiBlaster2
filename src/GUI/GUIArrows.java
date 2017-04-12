package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIArrows implements ActionListener{
    /**
     * makes the JPanel global variables
     */
    private JPanel arrowpanel;
    /**
     * makes the JButton variables global
     */
    private JButton upButton;
    private JButton downButton;
    /**
     * creates the Incrementer double variable
     */
    private double incrementer = 1.0;

    private JLabel incrtbox;

    public GUIArrows() {
        /**
         * @Methods make new methods
         */
        UpArrow();
        DownArrow();

        /**
         * creates second JPanel for the arrows
         */
        arrowpanel = new JPanel();

        /**
         * the text to be displayed on the screen
         */
        incrtbox = new JLabel(incrementer + " ms");
        Font myFont = new Font("Dialog", Font.BOLD, 20);
        incrtbox.setFont(myFont);
        incrtbox.setForeground(Color.black);
        /**
         * gives the arrowpanel the specified layout
         */
        arrowpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,300));

        arrowpanel.add(upButton);
        arrowpanel.add(downButton);
        arrowpanel.add(incrtbox);

        /**
         * removes the default panel background
         */
        arrowpanel.setBackground(null);

    }

    public void UpArrow(){
        Font myFont = new Font("Dialog", Font.BOLD, 50);
        /**
         * makes upbutton a global variable
         */
        upButton = new JButton("Λ");
	    upButton.setFont(myFont);
	    upButton.setForeground(Color.black);
	    upButton.setContentAreaFilled(false);

        /**
         * makes upButton be added to the listener
         */
        upButton.addActionListener(this);
    }

    public void DownArrow(){
        Font myFont = new Font("Dialog", Font.BOLD, 50);
        /**
         * makes downbutton a global variable
         */
        downButton = new JButton("V");
	    downButton.setFont(myFont);
	    downButton.setForeground(Color.black);
	    downButton.setContentAreaFilled(false);
        /**
         * lets the downButton communicate with the listener
         */
        downButton.addActionListener(this);
    }
    /**
     * creates the actionPerformed method
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(incrementer);
        /**
         * conditional if upbutton is clicked and limit is less or equal to 2
         */
        if (e.getSource() == upButton && incrementer <= 2.0) {
            /**
             * increments + .1
             */
            incrementer += 0.1;
            /**
             * @param Math.floor rounds the output of adding .1 down
             */
            if (Math.floor(incrementer) == 2.0) {
                upButton.setText("MAX");
            }
        }
        /**
         * conditional if downButton is clicked and limit is greater or equal to 1
         */
        if (e.getSource() == downButton && incrementer >= 1.0) {
            /**
             * increments - .1
             */
            incrementer -= 0.1;
            /**
             * @param Math.ceil rounds number up with .1
             */
            if (Math.ceil(incrementer) == 1.0) {
                downButton.setText("MAX");
            }
        }
    }
    /**
     * returns the JButton
     * @return creates the upbutton
     */
    public JButton getUpbutton() {return upButton;}
    /**
     * returns the JButton
     * @return creates the downbutton
     */
    public JButton getDownbutton() {return downButton;}
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