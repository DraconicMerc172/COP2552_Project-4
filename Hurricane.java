import java.time.LocalDate;

public class Hurricane {

    private String name;
    private int category;
    private LocalDate date;

    public Hurricane(String name, int category, LocalDate date) {

        this.name = name;
        this.category = category;
        this.date = date;
    }


    public String getName() {

        return name;
    }

    public int getCategory() {

        return category;
    }

    public LocalDate getDate() {
        
        return date;
    }
}
