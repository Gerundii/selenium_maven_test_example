import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName(value = "Домашнее задание к уроку #3")
public class ThirdHomeTask {

    WebDriver driver;
    String login = "pumpurum";
    String pass = "pumpurum";

    @BeforeAll
    public static void start() {
        System.out.println("Начало тестирования");
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName(value = "Тест регистрации")
    public void registrationTest() {
        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        //Нажатие кнопки ЗАРЕГИСТРИРОВАТЬСЯ
        driver.findElement(By.xpath("//button[contains(@class,'form_auth_button btn btn-primary')][2]")).click();

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.cssSelector("div>input[placeholder='Логин']")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.cssSelector("div>input[placeholder='Пароль']")).sendKeys(pass);

        //Нажатие кнопки СОЗДАТЬ
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Test
    @DisplayName(value = "Тест авторизации")
    public void authorizationTest() {
        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.id("login-input")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.id("password-input")).sendKeys(pass);

        //Нажатие кнопки ВОЙТИ
        driver.findElement(By.id("form_auth_button")).click();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @AfterAll
    public static void end() {
        System.out.println("Окончание тестирования");
    }

}
