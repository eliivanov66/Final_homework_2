import java.util.ArrayList;

public class Main { 
    public static void main(String[] args) {
        Counter counter = new Counter();
        ArrayList<Animal> animalShelter = new ArrayList<>();
        AnimalSubclass animalSubclasses = new AnimalSubclass();
        Commands animalCommands = new Commands();


        animalSubclasses.add("Собака");
        animalSubclasses.add("Кошка");

        animalCommands.add("Голос");
        animalCommands.add("Сидеть");
        animalCommands.add("Лапу");
        animalCommands.add("Лежать");
        
        animalShelter.add(new Animal("Муся", "Кошка", false, "2010-01-31"));
        counter.add();
        animalShelter.add(new Animal("Дуся", "Кошка", false, "2011-02-28"));
        counter.add();
        animalShelter.add(new Animal("Куся", "Собака", false, "2012-03-30"));
        counter.add();
        animalShelter.add(new Animal("Буся", "Собака", false, "2013-04-31"));
        counter.add();

        Logic.Contoller(animalShelter, animalSubclasses, animalCommands, counter);

    }
}
