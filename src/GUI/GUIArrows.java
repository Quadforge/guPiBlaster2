import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        arrowpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,550));

        arrowpanel.add(upButton);
        arrowpanel.add(downButton);
        arrowpanel.add(incrtbox);

        /**
         * removes the default panel background
         */
        arrowpanel.setBackground(null);

    }

    public void UpArrow(){
        /**
         * makes the inner class ServoIncrt a variable
         */
        ServoIncrt listener = new ServoIncrt();
        /**
         * adds an image to the upbutton
         */
        ImageIcon upArrow = new ImageIcon("enter upArrow.png location here");
        /**
         * makes upbutton a global variable
         */
        upButton = new JButton(upArrow);

        /**
         * makes upButton be added to the listener
         */
        upButton.addActionListener(listener);

        /**
         * removes the border of upbutton
         */
        upButton.setBorder(BorderFactory.createEmptyBorder());
        /**
         * removes the area around the button
         */
        upButton.setContentAreaFilled(false);

    }

    public void DownArrow(){
        /**
         * makes the inner class ServoIncrt a variable
         */
        ServoIncrt listener = new ServoIncrt();
        /**
         * adds an image to the downbutton
         */
        ImageIcon downArrow = new ImageIcon("enter downArrow.png location here");
        /**
         * makes downbutton a global variable
         */
        downButton = new JButton(downArrow);
        /**
         * lets the downButton communicate with the listener
         */
        downButton.addActionListener(listener);
        /**
         * removes the border of downbutton
         */
        downButton.setBorder(BorderFactory.createEmptyBorder());
        /**
         * removes the area around the button
         */
        downButton.setContentAreaFilled(false);

    }

    /**
     * the inner class ServoIncrt
     * increments ActionListener
     */
    public class ServoIncrt implements ActionListener {
        /**
         * creates the actionPerformed method
         */
        public void actionPerformed(ActionEvent e) {
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
