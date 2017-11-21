/*
 * Created by IntelliJ IDEA.
 * User: otakusenseihig
 * Date: 11/3/17
 * Time: 5:21 PM
 */
package HelperFunctions;

import java.io.*;

public class ReadAndWriteText {

    private String dataOutpuPath = "DataOutput/";
    private String fileExtension = ".txt";

    private File filePath;
    //Write
    private PrintWriter writeToText;
    //Read
    private String linesToRead = null;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private String FileName;
    private double DataValue;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
    public double getDataValue() {
        return DataValue;
    }

    public void setDataValue(double dataValue) {
        DataValue = dataValue;
    }

    public void write() throws FileNotFoundException {
        filePath = new File(dataOutpuPath + FileName + fileExtension);
        writeToText = new PrintWriter(filePath);
        writeToText.println(DataValue + "\n");
        writeToText.close();
    }

    public void read() throws IOException {
        fileReader = new FileReader( dataOutpuPath + fileReader + fileExtension);
        bufferedReader = new BufferedReader(fileReader);
        while ((linesToRead = bufferedReader.readLine()) != null){
            System.out.println(linesToRead);
        }
    }
    /*public void write(String FileName, double dataValues) throws FileNotFoundException {
        filePath = new File(dataOutpuPath + FileName + fileExtension);
        writeToText = new PrintWriter(FileName + fileExtension);
        writeToText.println(dataValues +"\n");
        writeToText.close();
    }

    public String read(String fileName) throws IOException {
        fileReader = new FileReader( dataOutpuPath + fileName + fileExtension);
        bufferedReader = new BufferedReader(fileReader);
        while ((linesToRead = bufferedReader.readLine()) != null){
            System.out.println(linesToRead);
        }
        return fileName;
    }*/

}