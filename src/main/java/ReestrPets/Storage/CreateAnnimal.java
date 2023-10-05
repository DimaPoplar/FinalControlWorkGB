package ReestrPets.Storage;

import ReestrPets.Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAnnimal implements Create {
    Map<Integer, ParentAnimal> dbAnimals = new HashMap<>();

    public CreateAnnimal() {
        init();
    }

    private void init(){
        Pet cat = new Cat("pop", LocalDate.of(2022, 7, 12));

        int per = cat.getAge();

        cat.learnSkill(new Command("Принести тапки"));
        dbAnimals.put(cat.getId(), cat);

        Pet dog = new Dog("Car", LocalDate.of(2023, 1, 24));
        dog.learnSkill(new Command("Принести тапки"));
        dog.learnSkill(new Command("Дай лапу"));
        dbAnimals.put(dog.getId(), dog);

        Pet hamster = new Hamster("gon", LocalDate.of(2022, 12, 20));
        hamster.learnSkill(new Command("Вертеться в колесе"));
        dbAnimals.put(hamster.getId(), hamster);

        PackAnimal horse = new Horse("qwe", LocalDate.of(2021, 2, 4));
        horse.setLoadCapacity(300);
        horse.learnSkill(new Command("Галоп!"));
        dbAnimals.put(horse.getId(), horse);

        PackAnimal horse2 = new Horse("void", LocalDate.of(2022, 12, 1));
        horse2.setLoadCapacity(400);
        horse2.learnSkill(new Command("Галоп!"));
        dbAnimals.put(horse2.getId(), horse2);

        PackAnimal donkey = new Donkey("ТCa", LocalDate.of(2020, 8, 24));
        donkey.setLoadCapacity(500);
        donkey.learnSkill(new Command("Поклон!"));
        dbAnimals.put(donkey.getId(), donkey);

        PackAnimal camel = new Camel("Fat", LocalDate.of(2020, 5, 20));
        camel.setLoadCapacity(1000);
        camel.learnSkill(new Command("vois!"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<ParentAnimal> getAllAnimals() {
        List<ParentAnimal> result = new ArrayList<>();
        for (ParentAnimal animal: dbAnimals.values()) {
            result.add(animal);
        }
        return result;
    }

    @Override
    public ParentAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(ParentAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(ParentAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        ParentAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}
