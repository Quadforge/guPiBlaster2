/*
 * Created by IntelliJ IDEA.
 * User: otakusenseihig
 * Date: 11/3/17
 * Time: 5:21 PM
 */
package HelperFunctions;

import java.io.*;

public class Write {

    public static void writer(String line, String line2, String path, String fileName) throws FileNotFoundException{

        File create = new File(path + "/" + fileName + ".txt");
        PrintStream output = new PrintStream(create);             //allows user to write to file
        output.println(line);           //writes to file
        output.println(line2);
        output.close();             //closes the file after writing

    }
}

/*
 * Requires the user to throw a FileNotFoundException within the file using the function.
 */