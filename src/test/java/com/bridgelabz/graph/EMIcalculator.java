package com.bridgelabz.graph;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class EMIcalculator {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");

        WebDriver driver = new ChromeDriver(co);
        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        String verticalXpath = "//*[local-name()='svg']//*[name()='g' and " +
                "@class = 'highcharts-series-group']//*[name()='rect']";
        String textXpath = "//*[local-name()='svg']//*[name()='g' and " +
                "@class='highcharts-label highcharts-tooltip highcharts-color-undefined']" +
                "//*[name()='text']";

        List<WebElement> barsList = driver.findElements(By.xpath(verticalXpath));
        System.out.println("Total Bars on Graph: " +barsList.size());

        Actions act = new Actions(driver);
        for(WebElement e : barsList){
            act.moveToElement(e).perform();
            Thread.sleep(500);
            String text = driver.findElement(By.xpath(textXpath)).getText();
            System.out.println(text);
        }

    }




}
