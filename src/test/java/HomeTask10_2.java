import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

@DisplayName(value = "Создание и удаление заметок")
public class HomeTask10_2 {

    WebDriver driver;
    WebDriverWait wait;
    String login = "Les4Ex";
    String pass = "Les4Ex";
    String noteTitleText = "Это заметка номер ";
    String noteContent = "А это содержание заметки номер ";
    int forCounter = 6;

    // Подсчет количества заметок
    private int countNote () {
        List<WebElement> notes = driver.findElements(By.xpath("//div[contains(@id,'note-container')]"));
        return notes.size();
    }

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Card_containerNew__adAai")));

        if (countNote() != 0) {
            //Список названий заметок
            List<WebElement> noteTitles = driver.findElements(By.xpath("//p[contains(@id,'note-title')]"));
            //System.out.println(noteTitles.size());
            //Список кнопок "Редактировать"
            List<WebElement> editButtons = driver.findElements(By.xpath("//img[contains(@id,'note-edit-btn')]"));
            //System.out.println(editButtons.size());

            for (int i = 0; i < countNote(); i++) {
                System.out.println("Итерация " + (i + 1));
                String noteTitleOld = noteTitles.get(i).getText();
                System.out.println("Старое название заметки = " + noteTitleOld);
                editButtons.get(i).click();
                driver.findElement(By.xpath("//div[contains(@id,'note-modal-title')]")).clear();
                driver.findElement(By.xpath("//div[contains(@id,'note-modal-title')]")).sendKeys(noteTitleText + (i + 200));
                driver.findElement(By.xpath("//button[contains(@id,'note-modal-save-btn')]")).click();
                String noteTitleNew = noteTitles.get(i).getText();
                System.out.println("Новое название заметки = " + noteTitleNew);
                System.out.println();
            }
        }
        else {
            //Создание заметок
            for (int i = 0; i < forCounter; i++) {
                //Создание новой заметки
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Card_containerNew__adAai"))).click();
                //Заполнение заголовка
                driver.findElement(By.id("note-modal-title-new_empty")).sendKeys(noteTitleText + i);
                //Заполнение содержания
                driver.findElement(By.id("note-modal-content-new_empty")).sendKeys(noteContent + i);
                //Клик по кнопке Ок
                driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
            }

            //Список названий заметок
            List<WebElement> noteTitles = driver.findElements(By.xpath("//p[contains(@id,'note-title')]"));
            System.out.println(noteTitles.size());
            //Список кнопок "Редактировать"
            List<WebElement> editButtons = driver.findElements(By.xpath("//img[contains(@id,'note-edit-btn')]"));
            System.out.println(editButtons.size());

            for (int i = 0; i < countNote(); i++) {

                System.out.println("Итерация " + (i + 1));
                String noteTitleOld = noteTitles.get(i).getText();
                System.out.println("Старое название заметки = " + noteTitleOld);
                editButtons.get(i).click();
                driver.findElement(By.xpath("//div[contains(@id,'note-modal-title')]")).clear();
                driver.findElement(By.xpath("//div[contains(@id,'note-modal-title')]")).sendKeys(noteTitleText + (i + 10));
                driver.findElement(By.xpath("//button[contains(@id,'note-modal-save-btn')]")).click();
                String noteTitleNew = noteTitles.get(i).getText();
                System.out.println("Новое название заметки = " + noteTitleNew);
                System.out.println();
            }
        }
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
