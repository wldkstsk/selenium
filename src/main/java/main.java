import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class main {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vladyslav Osatskyi\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();


        String url = "https://allegro.pl/";
        driver.get(url);
        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:" + strUrl);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String eTitle = "Allegro - atrakcyjne ceny";
        String actualTitle = driver.getTitle();

        if (eTitle.equals(actualTitle))
        {
            System.out.println("title - correct");
        }
        else
        {
            System.out.println("title -  incorrect");
        }

        WebElement popup = driver.findElement(By.xpath("//*[text()='Ok, zgadzam się']"));
        popup.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        WebElement typing = driver.findElement(By.xpath("//*[@data-role='search-input']"));
        typing.sendKeys("Telewizor");


        WebElement clicking = driver.findElement(By.xpath("//*[@data-role='search-button']"));
        clicking.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String curl =  driver.getCurrentUrl();
        System.out.println("Current Url is:" + curl);

        Select price = new Select(driver.findElement(By.id("allegro.listing.sort")));
        price.selectByVisibleText("cena: od najwyższej");
        System.out.println("Descending order by price" );
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        WebElement used = driver.findElement(By.xpath("//*[text()='używane']"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        used.click();
        System.out.println("used TV" );


        WebElement pierwszy = driver.findElement(By.xpath("//*[@data-analytics-view-custom-index0='2']"));
        pierwszy.click();
        System.out.println("first promo TV" );

        driver.quit();
    }


}



