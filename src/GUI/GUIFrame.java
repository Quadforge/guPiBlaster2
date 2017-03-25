/**
 * Created by NkemOhanenye on 3/24/17.
 */

import javax.swing.*;
import java.awt.*;

public class GUIFrame {

    public static void main(String args[]){
        JFrame frame = new JFrame();

        //colors the background red
        frame.getContentPane().setBackground(Color.red.darker().darker().darker());
        //removes window bar
        frame.setUndecorated(true);
        //sets fullscreen and removes taskbar
        GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice().setFullScreenWindow(frame);

        GUIMenu guimenu = new GUIMenu();
        frame.add(guimenu);

        //closes program upon clicking x button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes the program visible
        frame.setVisible(true);
    }
}