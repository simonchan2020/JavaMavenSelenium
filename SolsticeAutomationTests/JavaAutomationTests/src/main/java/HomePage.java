import org.junit.Assert;

public class HomePage {

    static String url = "http://www.amazon.com";

    /***
     * Launch the Web site
     */
    public void launch(){
        Browser.goTo(url);
        Assert.assertTrue("The user unable navigates to " + url + ", but she should.", Browser.driver.getTitle().toLowerCase().contains("amazon.com"));
    }

    /***
     * Allow to type in a text in search filed text box and click search button
     * @param text pass-in search string
     */
    public void searchItemAndSubmit(String text) {
        Browser.searchTextBox().sendKeys(text);
        Browser.searchButton().click();
        String result = Browser.searchResult();
        Assert.assertEquals("Search results does not seems to be for items " + text, result, text);
    }

    /***
     * Navigate to Second Page
     */
    public void navigateToSecondPage() {
        Browser.paginationSecondPage().click();
        String url = Browser.driver.getCurrentUrl();
        Assert.assertTrue("Clicked the 2nd page does not seems to be on Page 2", url.contains("page=2"));
    }

    /***
     * Select the third item from the product list
     */
    public void selectTheThirdItem() {
        Browser.selectThirdItem().click();
    }

    /***
     * Verify whether the selected item is available in stock or exclusively by invitation or not available
     * @return true if the item is in stock, else false
     */
    public boolean isSelectedItemAvailableInStock() {
        String actual = Browser.itemAvailability().getText();
        return (actual.trim().equals("In Stock.") || actual.trim().equals("Available exclusively by invitation"));
    }

    /***
     * Verify Add to cart button display
     */
    public boolean isAddCartButtonDisplay(){
        return Browser.addCartButton().isDisplayed();
    }

    /***
     * Add item to Cart
     */
    public void AddItemToCart(){
        Browser.addCartButton().click();
    }
}
