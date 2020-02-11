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
        System.out.println("Test start.........");
        Pages.homePage().launch();
        Pages.homePage().searchItemAndSubmit("Alexa");
        Pages.homePage().navigateToSecondPage();
        Pages.homePage().selectTheThirdItem();
        Assert.assertTrue("Selected item is not available in stock. ",Pages.homePage().isSelectedItemAvailableInStock());
        Assert.assertTrue("Selected item is available, but the Add Cart button is missing. ",Pages.homePage().isAddCartButtonDisplay());
        Pages.homePage().AddItemToCart();
        System.out.println("Test End........");
    }

    @AfterClass
    public static void cleanUp(){
        Browser.close();
    }
}
