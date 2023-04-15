import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

@DisplayName(value = "Домашнее задание к уроку #4")
public class FourthHomeTask {

    WebDriver driver;
    String login = "Les4Ex";
    String pass = "Les4Ex";

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName(value = "Тест авторизации и клика по корзине с неявным ожиданием")
    public void implicitExpectationTest() {
        // Неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.id("login-input")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.id("password-input")).sendKeys(pass);

        // Нажатие кнопки ВОЙТИ
        driver.findElement(By.id("form_auth_button")).click();

        //Клик по корзине
        driver.findElement(By.xpath("//span[text()='Удаленные']")).click();
    }

    @Test
    @DisplayName(value = "Тест авторизации и клика по корзине с явным ожиданием")
    public void explicitExpectationTest() {
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

        //Клик по корзине
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Удаленные']")));
        driver.findElement(By.xpath("//span[text()='Удаленные']")).click();
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }


}
