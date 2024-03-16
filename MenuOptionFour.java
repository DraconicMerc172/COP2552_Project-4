import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuOptionFour {
    
    public void execute(HurricaneData hurricaneData) {
        
        String sortOrderInput = JOptionPane.showInputDialog(null, "Major Florida Hurricanes 1950 - 2020\n" + 
                                                                                    "Sort by Hurricane Month\n" + 
                                                                                    "Enter 1 for Ascending Order\n" +
                                                                                    "Enter 2 for Descending Order:");

        int sortOrder = Integer.parseInt(sortOrderInput);
        String order = (sortOrder == 1) ? "ascending" : "descending";

        hurricaneData.sortByStormMonth(order);

        StringBuilder sortedHurricanesInfo = new StringBuilder();

        sortedHurricanesInfo.append("Sorted Hurricanes by Category:\n").append("Name           Category    Date\n");

        for (Hurricane hurricane : hurricaneData.getHurricanes()) {

            sortedHurricanesInfo.append(String.format("%-15s%-12d%s\n", hurricane.getName(), hurricane.getCategory(), hurricane.getDate()));
        }

        JTextArea textArea = new JTextArea(sortedHurricanesInfo.toString());
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, textArea.getFont().getSize()));
        textArea.setEditable(false);

        JOptionPane.showMessageDialog(null, textArea);

        String outputFileName = "SortByMonth.txt";
        String outputFilePath = System.getProperty("user.dir") + File.separator + outputFileName;
        
        writeToFile(outputFilePath, sortedHurricanesInfo.toString());
    }

    private static void writeToFile(String outputFilePath, String data) {

        try {
         
            Path path = Paths.get(outputFilePath);
            Files.createDirectories(path.getParent());

            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(data);
            writer.close();
        }
        
        catch (IOException e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage());
        }
    }
}