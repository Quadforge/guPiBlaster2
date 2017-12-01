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

    //SystenOut
    File dataOut;
    FileOutputStream fos;
    PrintStream ps;

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
        filePath = new File(dataOutpuPath + getFileName() + fileExtension);
        writeToText = new PrintWriter(filePath);
        writeToText.println(getDataValue() + "\n");
        writeToText.close();
    }

    public void read() throws IOException {
        fileReader = new FileReader( dataOutpuPath + fileReader + fileExtension);
        bufferedReader = new BufferedReader(fileReader);
        while ((linesToRead = bufferedReader.readLine()) != null){
            System.out.println(linesToRead);
        }
    }

    public void write2(double dataValue) throws FileNotFoundException {
        dataOut = new File(dataOutpuPath + getFileName() + fileExtension);
        fos = new FileOutputStream(dataOut);
        ps = new PrintStream(fos);
        System.setOut(ps);
        System.out.println(dataValue);

    }
}