/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autologin;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoLogin {
    static private WebDriver driver;
    

    public static void login(String isikukood) {
        
        if(!(isikukood.length() == 11)) {
            System.out.println("enter isikukood!");
            return;
        }
        
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://tahvel.edu.ee/");
        
        WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/md-toolbar/div[2]/div[2]/div/button"));
        loginBtn.click();
        
        WebElement smartIdBtn = driver.findElement(By.xpath("//*[@id=\"dialogContent_13\"]/div/div/div/div[1]/button[2]"));
        smartIdBtn.click();
        
        WebElement loginSmartIdBtn = driver.findElement(By.xpath("//*[@id=\"dialogContent_13\"]/div/md-content[4]/a"));
        loginSmartIdBtn.click();
        
        WebElement smartIdOptionBtn = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/nav/ul/li[3]/a"));
        smartIdOptionBtn.click();
        
        WebElement isikukoodInput = driver.findElement(By.id("sid-personal-code"));
        isikukoodInput.sendKeys("", isikukood);
        
        WebElement smartIdLoginBtn = driver.findElement(By.xpath("//*[@id=\"smartIdForm\"]/table/tbody/tr[2]/td[2]/button"));
        smartIdLoginBtn.click();
    }
}
