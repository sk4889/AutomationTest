package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import static org.junit.Assert.assertEquals;



public class Test1 {
    WebDriver driver = new ChromeDriver();
    Properties prop = new Properties();
    String path = System.getProperty("user.dir") +"\\src\\test\\java";

    public void launch(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String title = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println(path);
    }

    public void close(){
        driver.quit();
    }

    public void test() {
        try {

            InputStream file = new FileInputStream(path + "\\"+"xpath.properties");

            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebElement textBox = driver.findElement(By.name(prop.getProperty("textBox")));
        WebElement submitButton = driver.findElement(By.cssSelector(prop.getProperty("submitButton")));
        textBox.sendKeys(prop.getProperty("text"));
        submitButton.click();
    }
     public void verify()  {
         WebElement message = driver.findElement(By.id(prop.getProperty("msg")));
         String value = message.getText();
         assertEquals(prop.getProperty("verify"), value);
         //wait(5000);
         close();
     }
}
