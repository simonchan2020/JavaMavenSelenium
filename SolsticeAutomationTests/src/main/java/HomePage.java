public class HomePage {

    static String url = "http://www.amazon.com";

    /***
     * Launch the Web site
     */
    public void launch(){
        Browser.goTo(url);
    }

    /***
     * Input a string into a Search text box
     * @param text
     */
    public void searchTextInput(String text) {
        Browser.searchTextBox().sendKeys(text);
    }

    /***
     * Click the Search button
     */
    public void searchButtonClick() {
        Browser.searchButton().click();
    }

    /***
     * Navigate to Second Page
     */
    public void navigateToSecondPage() {
        Browser.paginationSecondPage().click();
    }

    /***
     * Select the third item from the product list
     */
    public void selectTheThirdItem() {
        Browser.selectThirdItem().click();
    }

    /***
     * Check weather the selected item is available in stock or exclusively by invitation
     * @return
     */
    public boolean isSelectedItemAvailableInStock() {
        String actual = Browser.itemAvailability().getText();
        return (actual.trim().equals("In Stock.") || actual.trim().equals("Available exclusively by invitation"));
    }

    /***
     * Add item to cart
     */
    public boolean isAddCartButtonDisplay(){
        return Browser.addCartButton().isDisplayed();
    }
}
