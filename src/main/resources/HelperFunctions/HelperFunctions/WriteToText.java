/*
 * Created by IntelliJ IDEA.
 * User: otakusenseihig
 * Date: 11/3/17
 * Time: 5:21 PM
 */
package HelperFunctions;

import java.io.File;
import java.io.PrintStream;

public class WriteToText {
    private double value;
    private String textFileName = "Voltage.txt";

    private String outputDirectory = "src/DataOutput";

    private File dataDirectory = new File(outputDirectory);

    private PrintStream writeToText;

    public void writer(String text, String fileName){

        try{

            PrintStream makeWriter = new PrintStream(fileName);             //allows user to write to file
            makeWriter.println(text);           //writes to file
            makeWriter.close();             //closes the file after writing

        }catch (Exception e){               //catches exception error

            System.out.println("File Not Found.");

        }
    }
}