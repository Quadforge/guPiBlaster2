import java.io.*;

public class RunTerminal {
    public static void main(String args[]) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("/bin/sh", "launchServod.sh");
        pb.directory(new File("/home/pi/PiBits/ServoBlaster.ServoBlaster/user/"));
        final Process p = pb.start();

    }
}
