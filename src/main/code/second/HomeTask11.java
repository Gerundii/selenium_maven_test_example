package code.second;

public class HomeTask11 {

    public static void main(String[] args) {
        System.out.println("Первое задание");
        taskOne();
        System.out.println("Второе задание");
        taskTwo();
        System.out.println("Третье задание");
        taskThree();
        System.out.println("Четвертое задание");
        taskFour();
    }

    private static void taskOne(){
        String str1 = "Я помню чудное мгновение";
        String str2 = "Передо мной явилась ты";
        String str3 = "Как мимолетное видение";
        String str4 = "Как гений чистой красоты!";

        System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n" + str4);
        System.out.println();
    }

    private static void taskTwo(){
        String str1 = "Java";
        String str2 = "лучший";
        String str3 = "язык";
        String str4 = "программирования";

        System.out.println(str1 + " - " + str2 + " " + str3 + " " + str4 + "!");
        System.out.println();
    }

    private static void taskThree(){
        String textLang ="Обожаю изучать новые языки";

        System.out.println(textLang.substring(7));
        System.out.println(textLang.substring(7,14));
        System.out.println();
    }

    private static void taskFour(){
        String textIndex ="Домашнее задание не проблема";

        System.out.println(textIndex.indexOf("не"));
        System.out.println(textIndex.lastIndexOf("не"));
        System.out.println();
    }
}
