import javax.swing.JOptionPane;

public class MenuOptionFive {
    
    public void execute(HurricaneData hurricaneData) {

        double averageCategory = hurricaneData.calculateAverageCategory();
        
        JOptionPane.showMessageDialog(null, String.format("Major Florida Hurricanes 1950 - 2020\n\n" + 
                                                                            "Average Storm Category by Saffir-Simpson Scale\n\n" + 
                                                                            "Average Storm Category: %.2f", averageCategory));
    }
}
