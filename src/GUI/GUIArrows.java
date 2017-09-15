package GUI;

import main.ServoBlaster3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
        /**
         * adds an image to the upbutton
         */
        ImageIcon upArrow = new ImageIcon("/guPiBlaster2/src/upArrow.png");

        /**
         * makes upbutton a global variable
         */
        upButton = new JButton(upArrow);
        upButton.setBorder(BorderFactory.createEmptyBorder());
        upButton.setContentAreaFilled(false);

        /**
         * makes upButton be added to the listener
         */
        upButton.addActionListener(new UpAction());
    }

    public void DownArrow() {
        /**
         * adds an image to the downbutton
         */
        ImageIcon downArrow = new ImageIcon("/guPiBlaster2/src/downArrow.png");

        /**
         * makes downbutton a global variable
         */
        downButton = new JButton(downArrow);
        downButton.setBorder(BorderFactory.createEmptyBorder());
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

class GUIAS {
    /**
     * creates the auto and the stop buttons
     */
    private JButton autoButton;
    private JButton stopButton;
    /**
     * creates the asPanel
     */
    private JPanel asPanel;

    public GUIAS(){
        /**
         * the methods created for the file
         */
        AutoButton();
        StopButton();

        /**
         * creates a panel for the auto and stop and creates the layout
         */
        asPanel = new JPanel();
        asPanel.setLayout(new GridLayout(1, 2,10,10));
        /**
         * adds the buttons to the panel
         */
        asPanel.add(autoButton);
        asPanel.add(stopButton);

        asPanel.setBackground(null);

    }
    public void AutoButton(){
        Font myFont = new Font("Dialog", Font.BOLD, 28);
        autoButton = new JButton("AUTO");
        autoButton.setFont(myFont);
        autoButton.setForeground(Color.black);

        autoButton.addActionListener(new AutoButtonListener());
        /**
         * input code here
         */
    }
    public void StopButton(){
        Font myFont = new Font("Dialog", Font.BOLD, 28);
        stopButton = new JButton("STOP");
        stopButton.setFont(myFont);
        stopButton.setForeground(Color.black);
        /**
         * input code here
         */
    }
    private class AutoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            /**
             * Try and Catch setup for the autoButton's IOExceptions
             */
            ServoBlaster3 auto = new ServoBlaster3();
            try {
                auto.automatic();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**returns the JButton
     *@return creates the autoButton
     */
    public JButton getAutoButton(){return autoButton;}
    /**returns the JButton
     *@return creates the stopButton
     */
    public JButton getStopButton(){return stopButton;}
    /**returns the asPanel
     * @return Aspanel the asPanel. It contains these JButtons
     */
    public JPanel getAsPanel(){return asPanel;}
}

class GUIExit {

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
