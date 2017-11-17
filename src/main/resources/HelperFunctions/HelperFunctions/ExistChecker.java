/*
 * Created by IntelliJ IDEA.
 * User: otakusenseihig
 * Date: 11/10/17
 * Time: 5:06 PM
 */
package HelperFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExistChecker {

    /*private ReadAndWrite confirm = new ReadAndWrite();
    private String fileName = confirm.getFileName();
    private String fileType = confirm.getFileType();
    private File file = new File(fileName + fileType);
    private JButton oW = new JButton("Overwrite");
    private JButton rN = new JButton("Rename");
    private JButton cancel = new JButton("Cancel");
    private JButton aO = new JButton("Add On");
    private JButton c = new JButton("Cancel");


    public void writeGui() throws FileNotFoundException, IOException{

        confirm.create(fileName);

        //ButtonGroup group = new ButtonGroup();
        oW.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    confirm.setFos(file, false);
                    confirm.write(confirm.getWords());
                } catch (Exception e) {

                }
            }
        });
        rN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton rename = new JButton("Rename");
                /*rename.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        file.renameTo(new File(confirm.getDirectory()));
                            return;
                        } else if (s == null) {
                            //The text is valid.
                            JOptionPane.showMessageDialog(null,
                                    "You must enter some text.",
                                    "",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });*/
                //JLabel label = new JLabel(confirm.getFileName() + "(1)" + confirm.getFileType());
                /*Object[] word = {confirm.getFileName() + "(1)" + confirm.getFileType()};
                Object[] page2 = {rename, cancel};
                JOptionPane.showInputDialog(
                        null,
                        "What would you like to rename the file to? \n",
                        "Rename File",
                        0,
                        null,
                        word,
                        page2[0]);
            }
        });
        aO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    confirm.write(confirm.getWords());
                }catch (Exception e){

                }
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        if(confirm.exist()){
            Object[] page1 = new Object[]{oW, rN, aO, c};
            JOptionPane.showOptionDialog(null,
                    "The file already exists.",
                    "",
                    0,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    page1,
                    page1[0]);

        }else {
            confirm.write(confirm.getWords());
        }
    }*/
}