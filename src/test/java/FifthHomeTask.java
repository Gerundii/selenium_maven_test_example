import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;


import java.time.Duration;

@DisplayName(value = "Домашнее задание к уроку #5")
public class FifthHomeTask {

    WebDriver driver;
    String login = "Les4Ex";
    String pass = "Les4Ex";
    String noteTitle = "Здесь могла быть ваша реклама";
    String noteContent = "А еще мы продаем старые покрышки";

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName(value = "Создание и проверка заголовка заметки")
    public void noteTitleTest() {
        // Явное ожидание
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.id("login-input")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.id("password-input")).sendKeys(pass);

        // Нажатие кнопки ВОЙТИ
        driver.findElement(By.id("form_auth_button")).click();

        //Создание заметки
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Card_containerNew__adAai")));
        driver.findElement(By.className("Card_containerNew__adAai")).click();

        //Заполнение заголовка
        driver.findElement(By.xpath("//div[text()='Заголовок...']")).sendKeys(noteTitle);

        //Заполнение содержания
        driver.findElement(By.xpath("//div[text()='Содержание...']")).sendKeys(noteContent);

        //Клик по кнопке выбора цвета заголовки
        driver.findElement(By.id("palette-btn-new_empty")).click();

        //Выбор цвета
        driver.findElement(By.id("palette-color-#e6c9a8")).click();

        //Клик по кнопке Ок
        driver.findElement(By.xpath("//button[text()='Ок']")).click();

        //Проверка заголовка заметки
        String title = driver.findElement(By.xpath("//p[text()='Здесь могла быть ваша реклама']")).getText();
        Assertions.assertEquals("Здесь могла быть ваша реклама", title, "Заголовок неверный");

    }

    @Test
    @DisplayName(value = "Проверка содержания заметки")
    public void noteContentTest() {
        // Явное ожидание
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.id("login-input")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.id("password-input")).sendKeys(pass);

        // Нажатие кнопки ВОЙТИ
        driver.findElement(By.id("form_auth_button")).click();

        //Проверка содержания заметки
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Здесь могла быть ваша реклама']")));
        String content = driver.findElement(By.xpath("//p[text()='Здесь могла быть ваша реклама']/..//div")).getText();
        Assertions.assertEquals("А еще мы продаем старые покрышки", content, "Содежание неверно");

    }

    @Test
    @DisplayName(value = "Проверка цвета заметки")
    public void noteColorTest() {
        // Явное ожидание
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.id("login-input")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.id("password-input")).sendKeys(pass);

        // Нажатие кнопки ВОЙТИ
        driver.findElement(By.id("form_auth_button")).click();

        //Проверка цвета заметки
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Здесь могла быть ваша реклама']")));
        String color = driver.findElement(By.xpath("//p[text()='Здесь могла быть ваша реклама']/../..")).getCssValue("background-color");
        System.out.println(color);
        Assertions.assertEquals("rgba(230, 201, 168, 1)", color, "Цвет неверный");

    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }


}
