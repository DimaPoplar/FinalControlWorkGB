package ReestrPets.Model;
import java.time.LocalDate;



public class Cat extends Pet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalType.CAT);
    }
}


