import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class HurricaneData {


    public static void readInputFile() {

        try (Scanner hurricaneDataScanner = new Scanner(new File("NamedFloridaHurricanes.txt"));) {
            
            while (hurricaneDataScanner.hasNextLine()) {
                
                String line = hurricaneDataScanner.nextLine();

                String[] parts = line.split(", ");
                String name = parts[0].trim();
                String[] categoryDate = parts[1].split(":");
                int category = Integer.parseInt(categoryDate[0].trim());
                String dateString = categoryDate[1].trim();

                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                hurricanes.add(new Hurricane(name, category, date));
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByStormName() {

        //to do
    }

    public static void sortByStormYear() {

        //to do
    }

    public static void sortByStormMonth() {

        //to do
    }

    public static double calculateAverageCategory() {

        return 0;
        //to do
    }

    public static int calculateMostActiveYear() {

        return 0;
        //to do
    }

    public static void aggregateTotalByCategory() {

        //to do
    }

    public static void aggregateTotalByYear() {

        //to do
    }
}
