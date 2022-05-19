package Connection;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public final String URL = "https://www.n11.com/giris-yap";

    public BaseTest() {

    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications")
                .addArguments("start-maximized");
                //.addArguments("--start-fullscreen");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public void getWindowHandle(){
        driver.getWindowHandle();
    }

    public void sendKey(WebElement element, String text) {
        waitForElementVisible(element);
        element.sendKeys(text);
        System.out.println("-> SendKeys: " + text);
    }

    public void click(WebElement element) {
        waitForElementVisible(element);
        element.click();
    }

    public void getUrl(String urlName){
        Assert.assertEquals(driver.getCurrentUrl(), urlName);
        System.out.println(urlName);

    }

    public void elementIsClickableForId(WebElement id){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(id));
            System.out.println("Element is clickable");
        }
        catch(Exception e) {
            System.out.println("Element isn't clickable");
        }
    }
    public void elementIsClickableForClassName(WebElement className){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(className));
            System.out.println("Element is clickable");
        }
        catch(Exception e) {
            System.out.println("Element isn't clickable");
        }
    }
    public void elementIsClickableForXpath(WebElement xpath){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(xpath));
            System.out.println("Element is clickable");
        }
        catch(Exception e) {
            System.out.println("Element isn't clickable");
        }
    }
    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
