import javax.swing.JOptionPane;

public class Menu {


    public void menuIntro(HurricaneData hurricaneData) {


        String menuMessage = ("Florida Major Hurricanes 1950 - 2020\n\n" +
                                    "Press 1 to Sort by Storm Name\n" +
                                    "Press 2 to Sort by Storm Category\n" +
                                    "Press 3 to Sort by Storm Year\n" + 
                                    "Press 4 to Sort by Storm Month\n" +
                                    "Press 5 to Display Average Storm Category\n" +
                                    "Press 6 to Display the Most Active Year\n" +
                                    "Press 7 to Display Total by Category\n" +
                                    "Press 8 to Display Total by Year\n" +
                                    "Press 9 to Exit.");

        String input = JOptionPane.showInputDialog(null, menuMessage);
        int option = Integer.parseInt(input);

        handleMenuOption(hurricaneData, option);
    }


    private void handleMenuOption(HurricaneData hurricaneData, int option) {

        switch (option) {
            case 1:
                MenuOptionOne menuOptionOne = new MenuOptionOne();
                menuOptionOne.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;

            case 2:
                MenuOptionTwo menuOptionTwo = new MenuOptionTwo();
                menuOptionTwo.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;
            
            case 3:
                MenuOptionThree menuOptionThree = new MenuOptionThree();
                menuOptionThree.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;
            
            case 4:
                MenuOptionFour menuOptionFour = new MenuOptionFour();
                menuOptionFour.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;
            
            case 5:
                MenuOptionFive menuOptionFive = new MenuOptionFive();
                menuOptionFive.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;
            
            case 6:
                MenuOptionSix menuOptionSix = new MenuOptionSix();
                menuOptionSix.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;

            case 7:
                MenuOptionSeven menuOptionSeven = new MenuOptionSeven();
                menuOptionSeven.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;

            case 8:
                MenuOptionEight menuOptionEight = new MenuOptionEight();
                menuOptionEight.execute(hurricaneData);

                menuIntro(hurricaneData);
                break;

            case 9:
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Please enter a numerical value between 1 - 6.");
                menuIntro(hurricaneData);
        }
    }
}
