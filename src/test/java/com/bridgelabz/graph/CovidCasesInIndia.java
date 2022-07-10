package com.bridgelabz.graph;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CovidCasesInIndia {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");

        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.google.com/search?q=covid+cases+in+india&sxsrf=ALiCzsZUJ9kXLWZJBik3Cy_46-" +
                "t816jJvQ%3A1657504173789&source=hp&ei=rYHLYouMLsecseMPy5ex6Ag&iflsig=AJiK0e8AAAAAYsuPvTR1YD7gFnDDc" +
                "QragnSlGJJpCMfh&oq=covid+cases+&gs_lcp=Cgdnd3Mtd2l6EAMYADILCAAQgAQQsQMQgwEyCAgAEIAEELEDMggIABCABBCx" +
                "AzIICAAQgAQQsQMyCwgAEIAEELEDEIMBMggIABCABBCxAzIFCAAQgAQyCAgAELEDEIMBMggIABCxAxCDATILCAAQgAQQsQMQyQM6" +
                "DQguEMcBEKMCEOoCECc6BwgjEOoCECc6BAgjECc6BQguEIAEOhEILhCABBCxAxCDARDHARDRAzoLCC4QgAQQsQMQ1AI6BQg" +
                "AEJIDUPEBWKYQYIgZaAFwAHgAgAHsAogB2xGSAQgwLjEwLjEuMZgBAKABAbABCg&sclient=gws-wiz");
        driver.manage().window().maximize();
        Thread.sleep(2000);

       WebElement ele = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg' ]) [2]"));
       int getTopLeftY = ((ele.getSize().getHeight())/2) - ele.getSize().getHeight();
       int getTopLeftX = ((ele.getSize().getWidth())/2) - ele.getSize().getWidth();

       Actions act = new Actions(driver);
       act.moveToElement(ele,getTopLeftX,getTopLeftY).perform();

       
    }




}
