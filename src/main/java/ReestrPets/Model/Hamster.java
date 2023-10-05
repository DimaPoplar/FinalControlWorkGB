package ReestrPets.Model;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.HAMSTER);
    }
}
