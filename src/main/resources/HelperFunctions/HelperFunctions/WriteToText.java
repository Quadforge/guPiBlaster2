/*
 * Created by IntelliJ IDEA.
 * User: otakusenseihig
 * Date: 11/3/17
 * Time: 5:21 PM
 */
package HelperFunctions;

import java.io.PrintStream;

public class WriteToText {

    public static void writer(String text, String fileName){
        try{

            PrintStream makeWriter = new PrintStream(fileName);
            makeWriter.println(text);
            makeWriter.close();

        }catch (Exception e){
            System.out.println("File Not Found.");
        }
    }
}