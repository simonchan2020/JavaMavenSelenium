import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTest {

    @Test
    public void sampleNavigateToPageTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");
        Assert.assertTrue(driver.getPageSource().contains("amazon"));
    }
}
