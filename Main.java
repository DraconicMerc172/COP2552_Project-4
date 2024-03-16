public class Main {
    
    public static void main(String[] args) {

        HurricaneData hurricaneData = new HurricaneData();

        hurricaneData.readInputFile();

        Menu menu = new Menu();
        menu.menuIntro(hurricaneData);

    }
}
