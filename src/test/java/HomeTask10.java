import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DisplayName(value = "Домашнее задание к уроку #10")
public class HomeTask10 {

    WebDriver driver;
    WebDriverWait wait;
    String login = "Les4Ex";
    String pass = "Les4Ex";
    String noteTitle = "Это заметка номер ";
    String noteContent = "А это содержание заметки номер ";
    int forCounter = 3;
    int whileDoCounter = 1;
    int whileCounter = 1;

    @BeforeEach
    public void initDriver() {

        driver = new ChromeDriver();

        // Явное ожидание
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Открытие стенда
        driver.get("http://172.24.120.5:8081/login");

        // Ввод текста в поле ЛОГИН
        driver.findElement(By.id("login-input")).sendKeys(login);

        // Ввод текста в поле ПАРОЛЬ
        driver.findElement(By.id("password-input")).sendKeys(pass);

        // Нажатие кнопки ВОЙТИ
        driver.findElement(By.id("form_auth_button")).click();

    }

    @Test
    @DisplayName(value = "Создание и вывод заголовка и содержания заметки")
    public void noteTitleTest() {

        //Создание заметок
        for (int i = 1; i <= forCounter; i++) {

            //Создание новой заметки
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Card_containerNew__adAai"))).click();

            //Заполнение заголовка
            driver.findElement(By.id("note-modal-title-new_empty")).sendKeys(noteTitle + i);

            //Заполнение содержания
            driver.findElement(By.id("note-modal-content-new_empty")).sendKeys(noteContent + i);

            //Клик по кнопке Ок
            driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
        }

        //Вывод заголовка и содержания заметки до изменения
        do {
            String titleBefore = noteTitle + whileDoCounter;
            String contentBerfore = noteContent + whileDoCounter;

            System.out.println(driver.findElement(By.xpath("//p[contains(text(),'" + titleBefore + "')]")).getText());
            System.out.println(driver.findElement(By.xpath("//div[contains(text(),'" + contentBerfore + "')]")).getText());
            System.out.println();
            whileDoCounter++;
        } while (whileDoCounter <= forCounter);

        while (whileCounter <= forCounter) {
            String titleBefore = noteTitle + whileCounter;
            // Поиск номера заметки
            String noteNum = driver.findElement(By.xpath("//p[contains(text(),'" + titleBefore + "')]")).getAttribute("id").substring(11);

            //Вывод номера заметки
            //System.out.println(noteNum);

            //Открытие заметки
            driver.findElement(By.xpath("//img[contains(@id,'note-edit-btn-" + noteNum + "')]")).click();

            //Заполнение заголовка
            driver.findElement(By.xpath("//div[contains(@id,'note-modal-title-" + noteNum + "')]")).clear();
            driver.findElement(By.xpath("//div[contains(@id,'note-modal-title-" + noteNum + "')]")).sendKeys(noteTitle + (10 * whileCounter));

            //Заполнение содержания
            driver.findElement(By.xpath("//div[contains(@id,'note-modal-content-" + noteNum + "')]")).clear();
            driver.findElement(By.xpath("//div[contains(@id,'note-modal-content-" + noteNum + "')]")).sendKeys(noteContent + (10 * whileCounter));

            //Клик по кнопке Ок
            driver.findElement(By.xpath("//button[contains(@id,'note-modal-save-btn-" + noteNum + "')]")).click();

            //Вывод заголовка и содержания заметки
            System.out.println(driver.findElement(By.xpath("//p[contains(@id,'note-title-" + noteNum + "')]")).getText());
            System.out.println(driver.findElement(By.xpath("//div[contains(@id,'note-content-" + noteNum + "')]/div")).getText());
            System.out.println();
            whileCounter++;
        }
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
