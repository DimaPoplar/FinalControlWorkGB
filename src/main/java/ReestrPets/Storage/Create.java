package ReestrPets.Storage;


import ReestrPets.Model.ParentAnimal;

import java.util.List;

public interface Create {

    List<ParentAnimal> getAllAnimals();


    ParentAnimal getAnimalById(int animalId);


    boolean addAnimal(ParentAnimal animal);

    int removeAnimal(ParentAnimal animal);
}









