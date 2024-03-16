import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

public class HurricaneData {

    private ArrayList<Hurricane> hurricanes = new ArrayList<>();

    public ArrayList<Hurricane> getHurricanes() {

        return hurricanes;
    }

    public void readInputFile() {

        try (Scanner hurricaneDataScanner = new Scanner(new File("NamedFloridaHurricanes.txt"));) {
            
            while (hurricaneDataScanner.hasNextLine()) {
                
                String line = hurricaneDataScanner.nextLine().trim();

                //String[] parts = line.split("[,\\s]*:[,\\s]*");
                String[] parts = line.split(",");

                if (parts.length != 2) {

                    System.err.println("Invalid input format: " + line);
                    continue;
                }

                //System.out.println("Category part: " + parts[1].split(":")[0].trim());

                String name = parts[0].trim();
                String categoryPart = parts[1].trim();
                //String categoryString = parts[1].split(":")[0].trim();
                //int category = Integer.parseInt(categoryString);

                int colonIndex = categoryPart.indexOf(":");

                //int category = Integer.parseInt(parts[1].split(":")[0].trim());
                int category = Integer.parseInt(categoryPart.substring(0, colonIndex).trim());
                
                //String dateString = parts[1].split(":")[1].trim();
                String dateString = categoryPart.substring(colonIndex + 1).trim();
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                hurricanes.add(new Hurricane(name, category, date));
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByStormName(String order) {

        Collections.sort(hurricanes, new Comparator<Hurricane>() {

            public int compare(Hurricane h1, Hurricane h2) {
                if (order.equals("ascending")) {
                    return h1.getName().compareTo(h2.getName());
                }

                else {
                    return h2.getName().compareTo(h1.getName());
                }
            }
            
        });
    }

    public void sortByStormCategory(String order) {

        Comparator<Hurricane> categoryComparator = new Comparator<Hurricane>() {

            public int compare(Hurricane h1, Hurricane h2) {
                return h1.getCategory() - h2.getCategory();
            }
        };

        Collections.sort(hurricanes, categoryComparator);

        if (order.equals("descending")) {

            Collections.reverse(hurricanes);
        }
    }

    public void sortByStormYear(String order) {

        Comparator<Hurricane> yearComparator = new Comparator<Hurricane>() {
            
            public int compare(Hurricane h1, Hurricane h2) {

                return h1.getDate().getYear() - h2.getDate().getYear();
            }
        };

        Collections.sort(hurricanes, yearComparator);

        if (order.equals("descending")) {

            Collections.reverse(hurricanes);
        }
    }

    public void sortByStormMonth(String order) {

        Comparator<Hurricane> monthComparator = new Comparator<Hurricane>() {
            
            public int compare(Hurricane h1, Hurricane h2) {

                int month1 = h1.getDate().getMonthValue();
                int month2 = h2.getDate().getMonthValue();
                
                if (order.equals("descending")) {

                    return Integer.compare(month1, month2);
                }

                else {
                    return Integer.compare(month2, month1);
                }
            }
        };

        Collections.sort(hurricanes, monthComparator);
    }

    public double calculateAverageCategory() {

        if (hurricanes.isEmpty()) {

            return 0.0;
        }

        int totalCategories = 0;

        for (Hurricane hurricane : hurricanes) {
            
            totalCategories += hurricane.getCategory();
        }

        return (double) totalCategories / hurricanes.size();
    }

    public int[] calculateMostActiveYear() {

        int[] yearCounts = new int[LocalDate.now().getYear() + 1];

        for (Hurricane hurricane : hurricanes) {

            int year = hurricane.getDate().getYear();
            yearCounts[year]++;
        }

        int mostActiveYear = 0;
        int maxCount = 0;

        for (int year = 0; year < yearCounts.length; year++) {

            int count = yearCounts[year];
            if (count > maxCount) {
                
                mostActiveYear = year;
                maxCount = count;
            }
        }

        return new int[]{mostActiveYear, maxCount};
    }

    public int[] aggregateTotalByCategory() {

        int[] categoryCounts = new int[6];

        for (Hurricane hurricane : hurricanes) {

            int category = hurricane.getCategory();
            
            if (category >= 1 && category <= 5) {

                categoryCounts[category - 1]++;
            }
        }

        return categoryCounts;
    }

    public int[] aggregateTotalByYear() {

        int[] yearCounts = new int[2021 - 1950];

        for (Hurricane hurricane : hurricanes) {

            int year = hurricane.getDate().getYear();
            yearCounts[year - 1950]++;
        }

        return yearCounts;
    }
}
