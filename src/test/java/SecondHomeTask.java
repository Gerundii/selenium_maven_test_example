import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SecondHomeTask {

    @Test
    public void testSecond() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://172.24.120.5:8081/login");
        String Text = driver.findElement(By.className("form_auth_block_head_text")).getText();
        //System.out.println(Text);
        driver.findElement(By.xpath("//div[@id='login-control-container']/input[@class='form-control']")).sendKeys(Text);
        String Value = driver.findElement(By.xpath("//div[@id='login-control-container']/input[@class='form-control']")).getAttribute("value");
        //System.out.println(Value);
        driver.findElement(By.id("password-input")).sendKeys(Value);
        driver.findElement(By.id("password-input")).clear();
        String Css = driver.findElement(By.xpath("//button[@id='form_auth_button']")).getCssValue("text-align");
        //System.out.println(Css);
        driver.findElement(By.id("password-input")).sendKeys(Css);
        //driver.findElement(By.xpath("//button[@id='form_auth_button']")).click();
        driver.quit();
    }
}
