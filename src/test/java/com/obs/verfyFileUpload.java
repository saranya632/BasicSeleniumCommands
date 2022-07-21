package com.obs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class verfyFileUpload {
    public WebDriver driver;
    public void testInitilizeFile(String browser,String url) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver =new EdgeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }else {
            try {
                throw new Exception("browser not defined");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //  driver.get(url);
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @Test
    public void verfyFileUploadRobot() throws AWTException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("http://my.monsterindia.com/create_account.html");
        // scroll to reach upload button
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("scroll(0,500)");
        // file path passed as parameter to StringSelection
        StringSelection s = new StringSelection("C:\\Users\\HP\\Desktop\\OBZQURA\\Assignment3.txt");
        // Clipboard copy
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
        //identify element and click
        driver.findElement(By.xpath("//*[text()='Choose CV']")).click();
        // Robot object creation
        Robot r = new Robot();
        //pressing enter
        r.keyPress(KeyEvent.VK_ENTER);
        //releasing enter
        r.keyRelease(KeyEvent.VK_ENTER);
        //pressing ctrl+v
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        //releasing ctrl+v
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        //pressing enter
        r.keyPress(KeyEvent.VK_ENTER);
        //releasing enter
        r.keyRelease(KeyEvent.VK_ENTER);
    }
    @BeforeMethod
    public void filesetUp(){
        testInitilizeFile("chrome","http://my.monsterindia.com/create_account.html");
    }
    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
