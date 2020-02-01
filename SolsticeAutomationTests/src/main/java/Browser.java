import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    static WebDriver driver = new ChromeDriver();

    /***
     * Used WebDriver to navigate to url
     * @param url url path
     */
    public static void goTo(String url){
        driver.get(url);
    }

    public static WebElement searchTextBox(){
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    /***
     * Closed webdriver instance
     */
    public static void close() {
        driver.close();
    }

    public static WebElement searchButton() {
        var elm = driver.findElement(By.cssSelector("div[class='nav-search-submit nav-sprite']"));
        return elm.findElement(By.tagName("input"));
    }

    public static WebElement paginationSecondPage() {
        var elm = paginationUL().findElements(By.tagName("li"));
        return elm.get(2);
    }

    private static WebElement paginationComponent() {
        return driver.findElement(By.cssSelector("span[data-component-type='s-pagination"));
    }

    private static WebElement pagination(){
        return paginationComponent().findElement(By.cssSelector("span[cel_widget_id='PAGINATION-PAGINATION']"));
    }

    private static WebElement paginationTextCenter(){
        return pagination().findElement(By.className("a-text-center"));
    }

    private static WebElement paginationUL(){
        return paginationTextCenter().findElement(By.tagName("ul"));
    }
}
