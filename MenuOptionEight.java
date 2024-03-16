import javax.swing.JOptionPane;

public class MenuOptionEight {
    
    public void execute(HurricaneData hurricaneData) {

        int[] yearCounts = hurricaneData.aggregateTotalByYear();

        StringBuilder message = new StringBuilder("Major Florida Hurricanes 1950 - 2020\n\n" + "Aggregate Total by Year:\n");

        for (int year = 1950; year <= 2020; year++) {

            message.append(year).append(": ").append(yearCounts[year - 1950]).append("\n");
        }

        JOptionPane.showMessageDialog(null, message.toString());
    }
}
