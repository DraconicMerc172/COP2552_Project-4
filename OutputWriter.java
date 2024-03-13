import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {

    public static void writeToFile(String filename, String data) {
        
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(data);
            writer.close();
            System.out.println("Data has been written to the file: " + filename);
        }

        catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
