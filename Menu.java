import javax.swing.JOptionPane;

public class Menu {


    public static void menuIntro() {

        int userOption = 0;
        String option = showMenu(userOption);
        handleMenuOption(option);

    }

    private static String showMenu(int userOption) {

        return JOptionPane.showInputDialog(null,
                        String.format("Florida Major Hurricanes 1950 - 2020\n\n" +
                                                "Press 1 to Sort by Storm Name\n" +
                                                "Press 2 to Sort by Storm Category\n" +
                                                "Press 3 to Sort by Storm Year\n" + 
                                                "Press 4 to Sort by Storm Month\n" +
                                                "Press 5 to Display Average Storm Category\n" +
                                                "Press 6 to Display the Most Active Year\n" +
                                                "Press 7 to Display Total by Category\n" +
                                                "Press 8 to Display Total by Year\n" +
                                                "Press 9 to Exit.", userOption));

    }

    private static void handleMenuOption(String option) {

        switch (option) {
            case "1":
                MenuOptionOne.menuOptions();
                break;

            case "2":
                MenuOptionTwo.menuOptions();
                break;
            
            case "3":
                MenuOptionThree.menuOptions();
                break;
            
            case "4":
                MenuOptionFour.menuOptions();
                break;
            
            case "5":
                MenuOptionFive.menuOptions();
                break;
            
            case "6":
                MenuOptionSix.menuOptions();
                break;

            case "7":
                MenuOptionSeven.menuOptions();
                break;

            case "8":
                MenuOptionEight.menuOptions();
                break;

            case "9":
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Please enter a numerical value between 1 - 6.");
                menuIntro();
        }
    }
}
