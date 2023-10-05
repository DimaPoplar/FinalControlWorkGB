package ReestrPets.Model;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.DONKEY);
    }
}
