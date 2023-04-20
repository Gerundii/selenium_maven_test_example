package code;

public class HomeTask8 {
    public static void main(String[] args) {
        short shortNum = 7778;
        System.out.println("Значение целочисленной переменной - " + shortNum);
        float floatNum = 876.351f;
        System.out.println("Значение переменной с плавающей точкой - " + floatNum);
        String name = "Игорь";
        System.out.println("Значение строковой переменной - " + name);
        String smth = "‘ny’";
        System.out.println("Значение строковой переменной - " + smth);
        boolean trustMe = true;
        System.out.println("Значение булевой переменной - " + trustMe);

        //Неявное преобразование
        char chL = 'L';
        int chToInt = chL;
        System.out.println(chToInt);

        //Явное преобразование
        int intL = 76;
        char intToCh = (char) intL;
        System.out.println(intToCh);
    }

}
