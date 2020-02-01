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
}
