package demo;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        driver.get("https://www.irctc.co.in/nget/train-search");
        // Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys("hyd");
        // Thread.sleep(3000);
        // // WebDriverWait wait=new WebDriverWait(driver, 10);
        WebElement city = driver.findElement(By.xpath("//span[text()='HYDERABAD DECAN - HYB']"));
        // - HYB']"));
        String cityname = city.getText();
        System.out.println("name of the city is" + cityname);

    }

    public void testCase02() throws InterruptedException {

        // Maximize window driver.windows().manage().maximize();
        // Handle Sync issue using implicityWait()
        // driver.windows().timeouts().implicityWait(30,TimeUnit.SECOND)
        // Load URL https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to top frame by using switchTo().frame name
        // //frame[@name='frame-top']
        driver.switchTo().frame("frame-top");
        // Switch to the left frame by using SwitchTo().frame name
        // Thread.sleep(3000);
        driver.switchTo().frame("frame-left");
        // get text by using getText() method and sysout it Using Locator "XPath"
        // //body[contains(text(),' LEFT')]
        // Thread.sleep(2000);
        WebElement lefttext = driver.findElement(By.xpath(" //body[contains(text(),' LEFT')]"));
        System.out.println("Text inside left frame is" + lefttext.getText());
        // Thread.sleep(2000);
        // driver.switchTo().frame("frame-top");
        driver.switchTo().parentFrame();
        // Switch to the left frame by using SwitchTo().frame name
        // Thread.sleep(2000);
        driver.switchTo().frame("frame-middle");
        // get text by using getText() method and sysout it Using Locator "XPath"
        // //body[contains(text(),' LEFT')]
        // Thread.sleep(2000);
        WebElement middletext = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println("Text inside middle frame is" + middletext.getText());
        driver.switchTo().parentFrame();
        // driver.switchTo().defaultContent();
        // Thread.sleep(2000);
        // Switch to the left frame by using SwitchTo().frame name
        driver.switchTo().frame("frame-right");
        // Thread.sleep(3000);
        // get text by using getText() method and sysout it Using Locator "XPath"
        // //body[contains(text(),' LEFT')]
        WebElement righttext = driver.findElement(By.xpath(" //body[contains(text(),' RIGHT')]"));
        System.out.println("Text inside right frame is" + righttext.getText());
        // Thread.sleep(3000);
        // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        // Thread.sleep(3000);
        WebElement bottomtext = driver.findElement(By.tagName("body"));
        System.out.println("Text inside bottom  frame is" + bottomtext.getText());

    }

    public void testCase03() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement searchbox = driver.findElement(By.className("gLFyf"));

        searchbox.sendKeys("amazon");
        searchbox.submit();
        Thread.sleep(2000);
        String name = driver.findElement(By.xpath("(//span[contains(text(),'Amazon.in')])[1]")).getText();
        System.out.println("search of amazon is" + " " + name);
    }

    public void testCase04() throws InterruptedException {
        // Load URL https://www.redbus.in/
        driver.get("https://www.redbus.in/");
        // use Thread.sleep() method
        Thread.sleep(5000);
        // Type text in the text box of source with id as locator and send keys as
        // bangalore Using Locator "ID":"src"
        driver.findElement(By.id("src")).sendKeys("bengaluru");
        Thread.sleep(3000);

        // Type text in the text box of destination with id as locator and send keys as
        // chennai. Using Locator "ID" "dest"
        driver.findElement(By.id("dest")).sendKeys("chennai");
        // click on date field and select date by id="onward_cal"
        driver.findElement(By.id("onward_cal")).click();
        Thread.sleep(3000);
        // select date by class classname="current day"
        // driver.findElement(By.className("current day")).click();
        driver.findElement(By.xpath("//td[@class='current day']")).click();
        // click on search button by identifying locator for search button by
        // id="search_btn".
        Thread.sleep(3000);
        driver.findElement(By.id("search_btn")).click();
        Thread.sleep(3000);
        List<WebElement> numofbus = driver.findElements(By.xpath("//span[@class='f-bold busFound']"));
        Thread.sleep(3000);
        System.out.println(numofbus);

    }

    public void testCase05() throws InterruptedException {
        driver.get("https://in.bookmyshow.com/");
        System.out.println(driver.findElement(By.xpath("//a[@href]")).getAttribute("href"));

        // Get the Hyperlink for movie DADA Using Locator "XPath" //div[text()='Dada']
        // driver.findElement(By.xpath("//div[text()='Dada']"));

        // Count the number of hyperlinks Using Locator "XPath" //a[@href]
        List<WebElement> noofhyp = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("number of hypelinks present are " + " " + noofhyp.size());

        // Total number of hyperlinks present Using Locator "XPath" //link
        List<WebElement> links = driver.findElements(By.xpath("//link"));
        // links.size();

        System.out.println("Total number of hyperlinks present==" + links.size());

    }

    public void testCase06() throws InterruptedException {
        // Load URL driver.get("https://www.irctc.co.in/")
        driver.get("https://www.irctc.co.in/");
        // find the number of iframes by using find elements and print the number of
        // iframes in the page Using Locator "XPath" //iframe
        List<WebElement> noofframes = driver.findElements(By.xpath("//iframe"));
        System.out.println("number of frames are " + " " + noofframes.size());
        // By using the size() Using Locator "XPath"

    }

    public void testCase07() throws InterruptedException {
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        // WebElement iframe =
        // driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame("iframeResult");

        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        driver.switchTo().alert().sendKeys("waheeda");

        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String str = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        System.out.println(str);

    }

    public void testCase08() throws InterruptedException {
        driver.get("https://finance.yahoo.com/quote/AAPL/history?guccounter=1");
        String share = driver.findElement(By.xpath("(//table)[1]/tbody/tr[count((//table)[1]/tbody/tr)]/td[5]/span"))
                .getText();
        System.out.println("value of share is" + share);
    }

    public void testCase09() throws InterruptedException {
        driver.get("https://www.imdb.com/chart/top");
        // Wait for URL to Load

        // Clickon the total number of movies
        driver.findElement(By.tagName("select")).click();
        // Select options
        driver.findElement(By.xpath(" //select//option[2]")).click();
        // wait
        Thread.sleep(3000);
        // Print the total number of movies

        String text = driver.findElement(By.xpath("//h1[text()='IMDb Top 250 Movies']")).getText();
        System.out.println("Total number of movies=" + text);
        // Print the Highest rating movie
        String text1 = driver.findElement(By.xpath("(//td[@class='titleColumn'])[1]//a")).getText();
        System.out.println("Highest rating movie=" + text1);
        // Print the lowest rating movie
        driver.findElement(By.xpath("//span[@title='Descending order']")).click();
        String text2 = driver.findElement(By.xpath("(//td[@class='titleColumn'])[1]//a")).getText();
        System.out.println("Lowest rating movie=" + text2);
    }

    public void testCase10() throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        // Locate the Email text box and enter email Using Locator "ID" id="session_key"
        driver.findElement(By.id("session_key")).sendKeys("waheeda8@gmail.com");

        // Locate the Password textbox and enter password Using Locator "ID"
        // id="session_password"
        driver.findElement(By.id("session_password")).sendKeys("waheedaasif12");
        // Click on sign in button Using Locator "XPath"
        // //button[@data-id="sign-in-form__submit-btn"]
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
        // Locate the name present by using getText() Using Locator "XPath"
        // //div[text()='Welcome, waheeda!']
        String heading = driver.findElement(By.xpath("//div[text()='Welcome, waheeda!']")).getText();
        System.out.println(heading);
        // get the number of connections Using Locator "XPath"
        // //span[text()='Connections']
        String numofconnections = driver.findElement(By.xpath("//span[text()='Connections']")).getText();
        System.out.println(numofconnections);

        // System.out.println(getAttribute("numofconnections"));

        // Click on post Using Locator "XPath" //span[text()='Start a post']
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        // Create a post Using Locator "XPath" //div[@role="textbox"]
        // Print the text
        // Locate post button Using Locator "XPath" //span[text()='Post']
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("post from automation");
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        // wait for the post to be posted Thread.sleep(5000);
        // Confirm post is visible and inspect the post Using Locator "XPath"
        // //span[text()='Good morning! This is a automated text.']
        // Select and click on image icon Using Locator "XPath"
        // //button[@class='artdeco-hoverable-trigger
        // artdeco-hoverable-trigger--content-placed-top
        // artdeco-hoverable-trigger--is-hoverable ember-view
        // select and send path to image data Using Locator "XPath"
        // //div[@class='relative full-width
        // image-sharing-detour-image-carousel__image-view-model-container']
        // click on done button Using Locator "XPath"
        // //button[@class="share-box-footer__primary-btn artdeco-button
        // artdeco-button--2 artdeco-button--primary ember-view"]
        // click o post button Using Locator "XPath"
        // //button[@class="share-actions__primary-action artdeco-button
        // artdeco-button--2 artdeco-button--primary ember-view"]
        // verify if post is uploaded Using Locator "XPath"
        // //div[@class="scaffold-finite-scroll__content"]/div/div
        // close and quit browser

    }

    public void testCase11() throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        // Locate the Email text box and enter email Using Locator "ID" id="session_key"
        driver.findElement(By.id("session_key")).sendKeys("waheeda8@gmail.com");

        // Locate the Password textbox and enter password Using Locator "ID"
        // id="session_password"
        driver.findElement(By.id("session_password")).sendKeys("xxxxxxxxx");
        // Click on sign in button Using Locator "XPath"
        // //button[@data-id="sign-in-form__submit-btn"]
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
        driver.findElement(By.xpath("//li-icon[@type='image']")).click();
        // driver.findElement(By.xpath("//div[@class='image-sharing-detour-container__upload-media-button']")).sendKeys("C:\Users\91636\OneDrive\Desktop\green.jpg");
        Thread.sleep(3000);
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:/Users/91636/OneDrive/Desktop/green.jpg");

        driver.findElement(By.xpath("//span[text()='Done']")).click();
        driver.findElement(By.xpath("//span[text()='Post']")).click();
    }
}
