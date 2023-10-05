package ReestrPets.Model;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.DOG);
    }
}

