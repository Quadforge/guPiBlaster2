/*
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

*/
/**
 * Created by NkemOhanenye on 3/24/17.
 *//*

public class GUIMenu extends JPanel{
    */
/**
     * the called panels from each file
     *//*

    private GUIArrows arrowpanel;
    private GUIExit exitpanel;
    private GUIAS aspanel;
    private GUIPanels datapanel;

    public GUIMenu(){
        */
/**
         * creates the panels for the project
         *//*

        arrowpanel = new GUIArrows();
        exitpanel = new GUIExit();
        aspanel = new GUIAS();
        datapanel = new GUIPanels();

        */
/**
         * creates the methods for the file
         *//*

        addActionListener();
        addToPanel();

    }

    */
/**
     * creates the actionlisteners for the buttons
     *//*

    public void addActionListener(){

        class AddUpButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                arrowpanel.UpArrow();
            }
        }

        class AddDownButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                arrowpanel.DownArrow();
            }
        }

        class AddAutoButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                aspanel.AutoButton();
            }
        }

        class AddStopButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                aspanel.StopButton();
            }
        }

        class AddExitButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                exitpanel.ExitButton();
                System.exit(0);
            }
        }

        */
/**
         * makes the actionlisteners a variable
         *//*

        ActionListener upButtonListener = new AddUpButtonListener();
        ActionListener downButtonListener = new AddDownButtonListener();
        ActionListener autoButtonListener = new AddAutoButtonListener();
        ActionListener stopButtonListener = new AddStopButtonListener();
        ActionListener exitButtonListener = new AddExitButtonListener();

        */
/**
         * add the listeners to the panel
         *//*

        arrowpanel.getUpbutton().addActionListener(upButtonListener);
        arrowpanel.getDownbutton().addActionListener(downButtonListener);
        aspanel.getAutoButton().addActionListener(autoButtonListener);
        aspanel.getStopButton().addActionListener(stopButtonListener);
        exitpanel.getExitbutton().addActionListener(exitButtonListener);

    }

    public void addToPanel(){
        */
/**
         * creates the layout for the panel
         *//*

        setLayout(new BorderLayout(20,0));

        */
/**
         * calls all the panels to a single panel
         *//*

        add(arrowpanel.getArrowpanel());
        add(aspanel.getAsPanel(), BorderLayout.NORTH);
        add(exitpanel.getExitpanel(), BorderLayout.EAST);
        add(datapanel.getDatapanel(), BorderLayout.WEST);
    }
}
class GUIFrame {

    public static void main(String args[]){
        JFrame frame = new JFrame();

        */
/**
         * colors the background white
         *//*

        frame.getContentPane().setBackground(Color.white);
        */
/**
         * removes window bar
         *//*

        frame.setUndecorated(true);
        */
/**
         * sets fullscreen and removes taskbar
         *//*

        GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice().setFullScreenWindow(frame);
        */
/**
         * on the off chance the screen is messed with, it cant be resized
         *//*

        frame.setResizable(false);

        */
/**
         * calls the GUIMenu file
         *//*

        GUIMenu guimenu = new GUIMenu();
        */
/**
         * adds the guimenu to the frame
         *//*

        frame.add(guimenu);
        */
/**
         * removes the guimenu background
         *//*

        guimenu.setBackground(null);

        */
/**
         * closes program upon clicking x button
         *//*

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        */
/**
         * makes the program visible
         *//*

        frame.setVisible(true);
    }
}
*/
