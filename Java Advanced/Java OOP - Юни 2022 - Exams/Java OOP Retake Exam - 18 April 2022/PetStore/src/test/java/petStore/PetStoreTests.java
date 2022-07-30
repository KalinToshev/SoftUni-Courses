package petStore;

import org.junit.Assert;
import org.junit.Test;

public class PetStoreTests {
    @Test
    public void testReturnCountOfAnimalsAdded() {
        Animal animal = new Animal("test", 20, 20);
        PetStore petStore = new PetStore();

        petStore.addAnimal(animal);

        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        Animal animal1 = new Animal("test1", 20, 20);
        Animal animal2 = new Animal("test2", 20, 30);
        Animal animal3 = new Animal("test3", 30, 40);
        PetStore petStore = new PetStore();

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(1, petStore.findAllAnimalsWithMaxKilograms(20).size());
    }

    @Test
    public void testAddAnimal() {
        Animal animal = new Animal("test", 20, 20);
        PetStore petStore = new PetStore();

        petStore.addAnimal(animal);

        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void getTheMostExpensiveAnimal() {
        Animal animal1 = new Animal("nemska", 20, 20);
        Animal animal2 = new Animal("nemska", 20, 30);
        Animal animal3 = new Animal("ulichna", 30, 40);
        PetStore petStore = new PetStore();

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertTrue(petStore.getTheMostExpensiveAnimal().getPrice() == 40);
    }

    @Test
    public void findAllAnimalBySpecie() {
        Animal animal1 = new Animal("nemska", 20, 20);
        Animal animal2 = new Animal("nemska", 20, 30);
        Animal animal3 = new Animal("ulichna", 30, 40);
        PetStore petStore = new PetStore();

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertTrue(petStore.findAllAnimalBySpecie("nemska").size() == 2);
    }
}

