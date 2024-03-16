import javax.swing.JOptionPane;

public class MenuOptionSeven {
    
    public void execute(HurricaneData hurricaneData) {

        int[] categoryCounts = new int[6];
        int totalHurricanes = 0;
        
        for (Hurricane hurricane : hurricaneData.getHurricanes()) {

            int category = hurricane.getCategory();
            categoryCounts[category - 1]++;
            totalHurricanes++;
        }

        StringBuilder result = new StringBuilder("Major Florida Hurricanes 1950 - 2020\n\n" + "Aggregate Total by Category:\n\n");
        result.append("Total Hurricanes: ").append(totalHurricanes).append("\n\n");

        for (int category = 1; category <= 5; category++) {

            result.append("Category ").append(category).append(": ").append(categoryCounts[category - 1]).append("\n");
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
}
