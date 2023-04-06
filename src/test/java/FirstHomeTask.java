import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class FirstHomeTask {

    @Test
    public void testFirst() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://172.24.120.5:8081/login");
        // Поиск By.id
        //driver.findElement(By.id("login-input")).sendKeys("Selenium Test");
        // Поиск By.xpath
        //driver.findElement(By.xpath("//div[@id='login-control-container']/input[@class='form-control']")).sendKeys("Selenium Test");
        // Поиск By.cssSelector
        driver.findElement(By.cssSelector("div>input#login-input")).sendKeys("Selenium Test");
        driver.quit();
    }

}
