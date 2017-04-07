import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIMenu extends JPanel{
    /**
     * the called panels from each file
     */
    private GUIArrows arrowpanel;
    private GUIExit exitpanel;
    private GUIAM ampanel;
    private GUIPanels datapanel;

    public GUIMenu(){
        /**
         * creates the panels for the project
         */
        arrowpanel = new GUIArrows();
        exitpanel = new GUIExit();
        ampanel = new GUIAM();
        datapanel = new GUIPanels();

        /**
         * creates the methods for the file
         */
        addActionListener();
        addToPanel();

    }

    /**
     * creates the actionlisteners for the buttons
     */
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
                ampanel.AutoButton();
            }
        }

        class AddManButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                ampanel.ManButton();
            }
        }

        class AddExitButtonListener implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                exitpanel.ExitButton();
            }
        }

        /**
         * makes the actionlisteners a variable
         */
        ActionListener upButtonListener = new AddUpButtonListener();
        ActionListener downButtonListener = new AddDownButtonListener();
        ActionListener autoButtonListener = new AddAutoButtonListener();
        ActionListener manButtonListener = new AddManButtonListener();
        ActionListener exitButtonListener = new AddExitButtonListener();

        /**
         * add the listeners to the panel
         */
        arrowpanel.getUpbutton().addActionListener(upButtonListener);
        arrowpanel.getDownbutton().addActionListener(downButtonListener);
        ampanel.getAutobutton().addActionListener(autoButtonListener);
        ampanel.getManbutton().addActionListener(manButtonListener);
        exitpanel.getExitbutton().addActionListener(exitButtonListener);

    }

    public void addToPanel(){
        /**
         * creates the layout for the panel
         */
        setLayout(new BorderLayout(20,0));

        /**
         * calls all the panels to a single panel
         */
        add(arrowpanel.getArrowpanel());
        add(ampanel.getAmpanel(), BorderLayout.NORTH);
        add(exitpanel.getExitpanel(), BorderLayout.EAST);
        add(datapanel.getDatapanel(), BorderLayout.WEST);

    }
}
