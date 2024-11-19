import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.ritikapractise.PageComponents.MultiTrip;
import org.ritikapractise.PageComponents.RoundTrip;
import org.ritikapractise.PageObjects.TravelHomePage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {

    WebDriver driver;
    TravelHomePage th;

    @BeforeTest
    public void setUp() {
        driver = intializeSetUp();
        th = new TravelHomePage(driver);
    }

    @DataProvider
    public Object[][] getTestData() throws IOException {
        List<HashMap<String, String>> l = dataReader(System.getProperty("user.dir") + "//src//test//java//reservationDetails.json");
        return new Object[][]{
                {l.get(0)}, {l.get(1)}
        };
    }

    @Test(dataProvider = "getTestData")
    public void flightTest(HashMap<String, String> reservationDetails) {

        th.goTo();
        //System.out.println(th.getFooterNavigation().selectFlight());
        //System.out.println(th.getHeaderNavigation().selectFlight());
        th.searchFlightStrategy("multitrip").checkAvailability(reservationDetails);


    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}

