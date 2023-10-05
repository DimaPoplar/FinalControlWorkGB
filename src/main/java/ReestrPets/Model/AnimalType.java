package ReestrPets.Model;

public enum AnimalType {
    DOG ("Собака"),
    CAT ("Кошка"),
    HAMSTER ("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private String title;
    AnimalType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}























