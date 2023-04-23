package code.pet;

public class Pet {
    String typeOfPet;   // вид питомца
    String name;        // кличка питомца
    int age;            // возраст питомца
    String colour;      // окрас питомца
    String favoriteFood;  // любимая еда

    //Конструктор 1.1
    /*Pet() {
        typeOfPet = "Кошка";
        name = "Мурка";
        age = 2;
        colour = "Рыжая";
        favoriteFood = "Мышки";
    }*/

    //Конструктор 1.2
    Pet()
    {
        this("Кошка", "Мурка", 2, "Рыжая", "Мышки");
    }

    //Конструктор 2
    Pet(String t, String n, int a, String c, String p)
    {
        typeOfPet = t;
        name = n;
        age = a;
        colour = c;
        favoriteFood = p;
    }

    //Конструктор 3
    Pet(String typeOfPet, int age) {
        this(typeOfPet, "Шарик", age, "Черный", "Косточки");
    }

    void petInfo (){
        System.out.printf("Вид: %s \tКличка: %s \tВозраст: %d \tЦвет: %s \tЧто кушает: %s\n", typeOfPet, name, age, colour, favoriteFood);
    }

    void petSay () {
        if (typeOfPet == "Кошка") {
            System.out.println(typeOfPet + " " + "говорит мяяяууу\n");
        }
        if (typeOfPet == "Корова") {
            System.out.println(typeOfPet + " " + "говорит муууууу\n");
        }
        else {
            System.out.println("Молчит\n");
        }
    }
}
