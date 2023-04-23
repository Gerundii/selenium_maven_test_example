package code.pet;

import code.person.Person;

public class Program {
    public static void main(String[] args) {

        Pet cat = new Pet();
        cat.petInfo();
        cat.petSay();

        Pet cow = new Pet("Корова",  "Мурка", 5, "Пятнышко", "Травка");
        cow.petInfo();
        cow.petSay();

        Pet dog = new Pet("Собака", 10);
        dog.petInfo();
        dog.petSay();
    }
}
