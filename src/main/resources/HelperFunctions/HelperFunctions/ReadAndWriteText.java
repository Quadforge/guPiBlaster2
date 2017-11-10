/*
 * Created by IntelliJ IDEA.
 * User: otakusenseihig
 * Date: 11/3/17
 * Time: 5:21 PM
 */
package HelperFunctions;

import java.io.*;

public class ReadAndWriteText {

    private String dataOutpuPath = "src/DataOutput/";
    private String fileExtension = ".txt";

    private File filePath;
    //Write
    private PrintWriter writeToText;
    //Read
    private String linesToRead = null;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public void write(String FileName, double dataValues) throws FileNotFoundException {
        filePath = new File(dataOutpuPath + FileName + fileExtension);
        writeToText = new PrintWriter(FileName + fileExtension);
        writeToText.println(dataValues);
        writeToText.close();
    }

    public String read(String fileName) throws IOException {
        fileReader = new FileReader( dataOutpuPath + fileName + fileExtension);
        bufferedReader = new BufferedReader(fileReader);
        while ((linesToRead = bufferedReader.readLine()) != null){
            System.out.println(linesToRead);
        }
        return fileName;
    }

}