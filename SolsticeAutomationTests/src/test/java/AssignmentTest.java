import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class AssignmentTest {
    /***
     * GIVEN the user navigates to www.amazon.com
     * AND Searches for 'Alexa'
     * AND navigates to the second page
     * AND selects the third item
     * Expected Result
     *
     * THEN assert that the item would be available for purchase [the user would be able to add it to the cart]
     */
    @Test
    public void canAddItemToCart(){
        Pages.homePage().launch();
        Pages.homePage().searchTextInput("Alexa");
        Pages.homePage().searchButtonClick();
        Pages.homePage().navigateToSecondPage();
        Pages.homePage().selectTheThirdItem();

        Assert.assertTrue(Pages.homePage().isSelectedItemAvailableInStock());
        Assert.assertTrue(Pages.homePage().isAddCartButtonDisplay());
    }

    @AfterClass
    public static void cleanUp(){
        Browser.close();
    }
}
