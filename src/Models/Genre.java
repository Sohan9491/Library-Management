package Models;

public class Genre {
    String name;
    String description;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Getter
    public String getName() {
        return name;

    }

    public String getDescription() {
        return description;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
