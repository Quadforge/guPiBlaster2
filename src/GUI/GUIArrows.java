package GUI;

import main.ServoBlaster3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIArrows {
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
        arrowpanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 300));

        arrowpanel.add(upButton);
        arrowpanel.add(downButton);
        arrowpanel.add(incrtbox);

        /**
         * removes the default panel background
         */
        arrowpanel.setBackground(null);

    }

    public void UpArrow() {
        Font myFont = new Font("Dialog", Font.BOLD, 50);
        /**
         * makes upbutton a global variable
         */
        upButton = new JButton("A");
        upButton.setFont(myFont);
        upButton.setForeground(Color.black);
        upButton.setContentAreaFilled(false);

        /**
         * makes upButton be added to the listener
         */
        upButton.addActionListener(new UpAction());
    }

    public void DownArrow() {
        Font myFont = new Font("Dialog", Font.BOLD, 50);
        /**
         * makes downbutton a global variable
         */
        downButton = new JButton("∀");
        downButton.setFont(myFont);
        downButton.setForeground(Color.black);
        downButton.setContentAreaFilled(false);
        /**
         * lets the downButton communicate with the listener
         */
        downButton.addActionListener(new DownAction());
    }

    public class UpAction implements ActionListener {
        /**
         * creates the actionPerformed method
         */
        public void actionPerformed(ActionEvent e) {
            /**
             * creates the DecimalFormat variable
             * @variable dec, makes there be only one decimal
             */
            DecimalFormat dec = new DecimalFormat("#.0");
            /**
             * conditional if upbutton is clicked and limit is less or equal to 2
             */
            ServoBlaster3 up = new ServoBlaster3();
            up.increasePulse();
            if (incrementer < 2.1) {
                /**
                 * overwrites the increment and rounds it
                 * @param dec.format round the number according to the DecimalFormat variable
                 */
                incrtbox.setText(dec.format(incrementer + 0.1) + " ms");
                /**
                 * increments + .1
                 * @param Math.floor rounds the output of adding .1 down
                 */
                Math.floor(incrementer += 0.1);
            }

        }
    }

    /**
     * conditional if downButton is clicked and limit is greater or equal to 1
     */
    public class DownAction implements ActionListener {
        /**
         * creates the actionPerformed method
         */
        public void actionPerformed(ActionEvent e) {
            /**
             * creates the DecimalFormat variable
             * @variable dec, makes there be only one decimal
             */
            DecimalFormat dec = new DecimalFormat("#.0");
            ServoBlaster3 down = new ServoBlaster3();
            down.initialPulse();
            /**
             * conditional if downbutton is clicked and limit is greater or equal to 1.1
             */
            if (incrementer >= 1.1) {
                /**
                 * overwrites the increment and rounds it
                 * @param dec.format round the number according to the DecimalFormat variable
                 */
                incrtbox.setText(dec.format(incrementer - 0.1) + " ms");
                /**
                 * increments - .1
                 * @param Math.floor rounds the output of adding .1 down
                 */
                Math.floor(incrementer -= 0.1);
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
    /**
     * returns the incrtbox
     * @return Incrtbox the incrtbox.
     */
    public JLabel getIncrtbox(){return incrtbox;}

}
