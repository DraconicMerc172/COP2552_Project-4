import javax.swing.JOptionPane;

public class MenuOptionSix {
    
    public void execute(HurricaneData hurricaneData) {

        int[] yearCounts = new int[71];

        for (Hurricane hurricane : hurricaneData.getHurricanes()) {

            int year = hurricane.getDate().getYear();
            yearCounts[year - 1950]++;
        }

        int maxCount = 0;
        
        for (int count : yearCounts) {

            maxCount = Math.max(maxCount, count);
        }

        StringBuilder result = new StringBuilder("Most Active Year(s):\n");
        
        for (int year = 1950; year <= 2020; year++) {

            if (yearCounts[year - 1950] == maxCount) {

                result.append(year).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
}
