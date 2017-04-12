package GUI; /**
 * Created by NkemOhanenye on 3/24/17.
 */

import javax.swing.*;
import java.awt.*;

public class GUIFrame {

    public static void main(String args[]){
        JFrame frame = new JFrame();

        /**
         * colors the background white
         */
        frame.getContentPane().setBackground(Color.white);
        /**
         * removes window bar
         */
        frame.setUndecorated(true);
        /**
         * sets fullscreen and removes taskbar
         */
        GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice().setFullScreenWindow(frame);
        /**
         * on the off chance the screen is messed with, it cant be resized
         */
        frame.setResizable(false);

        /**
         * calls the GUIMenu file
         */
        GUIMenu guimenu = new GUIMenu();
        /**
         * adds the guimenu to the frame
         */
        frame.add(guimenu);
        /**
         * removes the guimenu background
         */
        guimenu.setBackground(null);

        /**
         * closes program upon clicking x button
         */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * makes the program visible
         */
        frame.setVisible(true);
    }
}