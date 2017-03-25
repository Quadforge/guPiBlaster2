import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NkemOhanenye on 3/24/17.
 */
public class GUIMenu extends JPanel {
    private GUIArrows arrowpanel;
    private GUIExit exitpanel;
    private GUIAM ampanel;
    private GUIPanels currenttext;
    private GUIPanels voltagetext;
    private GUIPanels temptext;
    private GUIPanels forcetext;
    //the called panels from each file

    public GUIMenu(){

        //creates the panels for the project
        arrowpanel = new GUIArrows();
        exitpanel = new GUIExit();
        ampanel = new GUIAM();
        currenttext = new GUIPanels();
        voltagetext = new GUIPanels();
        temptext = new GUIPanels();
        forcetext = new GUIPanels();

        //creates the methods for the file
        addActionListener();
        addToPanel();

    }

    //creates the actionlisteners for the buttons
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

        ActionListener upButtonListener = new AddUpButtonListener();
        ActionListener downButtonListener = new AddDownButtonListener();
        ActionListener autoButtonListener = new AddAutoButtonListener();
        ActionListener manButtonListener = new AddManButtonListener();
        ActionListener exitButtonListener = new AddExitButtonListener();

        //arrowpanel.getUpbutton().addActionListener(upButtonListener);
        //arrowpanel.getDownbutton().addActionListener(downButtonListener);
        exitpanel.getExitbutton().addActionListener(exitButtonListener);
        ampanel.getAutobutton().addActionListener(autoButtonListener);
        ampanel.getManbutton().addActionListener(manButtonListener);

    }

    public void addToPanel(){

        setLayout(new BorderLayout());
        //add(arrowpanel.getUpbutton());
        //add(arrowpanel.getDownbutton());
        add(exitpanel.getExitpanel(), BorderLayout.EAST);
        add(ampanel.getAmpanel());
        add(currenttext.getCurrenttext());
        add(voltagetext.getVoltagetext());
        add(temptext.getTemptext());
        add(forcetext.getForcetext());

    }
}
