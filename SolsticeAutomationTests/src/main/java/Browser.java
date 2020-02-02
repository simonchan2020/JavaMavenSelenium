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
        driver.manage().window().maximize();
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

    public static String searchResult(){
        var elm = driver.findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']"));
        return elm.findElements(By.tagName("span")).get(2).getText().replace("\"", "");
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

    public static WebElement selectThirdItem() {
        var elms = searchResultList().findElements(By.tagName("div"));
        WebElement result = null;
        for (WebElement item: elms) {
            if(item.getAttribute("data-index") != null){
                if(item.getAttribute("data-index").equals("2")){
                    result = item.findElement(By.tagName("a"));
                    break;
                }
            }
        }
        return result;
    }
    
    private static WebElement searchResultComponent(){
        return driver.findElement(By.cssSelector("span[data-component-type='s-search-results']"));
    }
    
    private static WebElement searchResultList(){
        return searchResultComponent().findElement(By.cssSelector("div[class='s-result-list s-search-results sg-row']"));
    }

    public static WebElement itemAvailability() {
        return driver.findElement(By.id("availability"));
    }

    public static WebElement addCartButton(){
        return driver.findElement(By.id("add-to-cart-button"));
    }
}
