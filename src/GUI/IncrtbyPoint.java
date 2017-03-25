import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NkemOhanenye on 3/10/17.
 */

public class IncrtbyPoint extends JFrame{
    private JButton upbutton, downbutton;
    //creates the 2 buttons
    private JPanel buttonpanel;
    //creates the panel

    public IncrtbyPoint(){
        buttonpanel = new JPanel();

        setSize(500, 500);
        //sets the window size
        setTitle("TO THE MAX!!!");
        //creates the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonCreate();

        setVisible(true);
    }

    public static void main(String args[]){new IncrtbyPoint();}

    public void ButtonCreate(){
        GridBagConstraints gbc = new GridBagConstraints();
        buttonpanel.setLayout(new GridBagLayout());

        upbutton = new JButton("button1");
        Font myFont = new Font("Dialog", Font.BOLD, 30);
        //changes the font of the text of the upbutton
        upbutton.setFont(myFont);
        //implements the font
        upbutton.setForeground(Color.BLACK);
        //colors the text


        ActionClass upper = new ActionClass();
        upbutton.addActionListener(upper);
        //creates the actionlistener for the up button
        buttonpanel.add(upbutton, gbc);
        //adds the button to the panel
        add(buttonpanel);

        downbutton = new JButton("button2");
        Font myFont2 = new Font("Dialog", Font.BOLD, 30);
        downbutton.setFont(myFont2);
        downbutton.setForeground(Color.BLACK);

        downbutton.addActionListener(upper);
        buttonpanel.add(downbutton, gbc);
        add(buttonpanel);
    }

    private class ActionClass implements ActionListener{
        private double Incrementer = 1.0;
        private JPanel TextPanel;
        private JTextField incrthere;
        public void actionPerformed(ActionEvent e){
            TextPanel = new JPanel();
            incrthere = new JTextField();
            incrthere.setText("Increment: " + Incrementer);
            TextPanel.add(incrthere);
            add(TextPanel);
            setVisible(true);

            if(e.getSource() == upbutton && Incrementer <= 2.0){
                    Incrementer += 0.1;
                    System.out.println(Incrementer);
                if (Math.floor(Incrementer) == 2.0) {
                    //System.out.println("hi");
                    upbutton.setText("MAX");
                }
            }
            if(e.getSource() == downbutton && Incrementer >= 1.0){
                Incrementer -= 0.1;
                System.out.println(Incrementer);
                if (Math.ceil(Incrementer) == 1.0) {
                    //Math.floor rounds number down
                    downbutton.setText("MAX");
                }
            }
        }
    }
}
