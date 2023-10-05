package ReestrPets.Controll;

import ReestrPets.Model.*;
import ReestrPets.Storage.Create;

import java.time.LocalDate;
import java.util.List;

public class WorkAnimal {

    private Create dbKennel;

    public WorkAnimal(Create dbKennel) {
        this.dbKennel = dbKennel;
    }

    public List<ParentAnimal> getAnimals() {
        return dbKennel.getAllAnimals();
    }

    public boolean createAnimal(String name, LocalDate birthDay, AnimalType animalGenius) {
        ParentAnimal animal = switch (animalGenius) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };

        return dbKennel.addAnimal(animal);
    }

    public int removeAnimal(ParentAnimal animal) {
        if (animal == null) return -1;
        return  dbKennel.removeAnimal(animal);
    }
}








