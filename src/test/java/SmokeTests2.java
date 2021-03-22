import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SmokeTests2 {

    @AfterMethod
    public void afterMethod() {
        DriverFactory.quite();
    }

    @Test(description = "Addition test", groups = {"API"})
    public void addTest2() {
        assertThat(2 + 4, is(equalTo(6)));
    }

    @Test(groups = {"API"})
    public void divDest2() {
        assertThat(4 / 2, is(equalTo(2)));
    }

    @Test(groups = {"API"})
    public void subscriptionTest2() {
        assertThat(9 + 3 + 3, is(equalTo(15)));
    }

    @Test(groups = {"API"})
    public void loginTest2() {
        assertThat("login", is(startsWithIgnoringCase("log")));
    }

    @Test(groups = {"API"})
    public void multipleTest2() {
        assertThat(2 * 4, is(equalTo(8)));
    }

    @Test(description = "This is UI test for screenshot check", groups = {"UI"})
    public void uiTestForScreenShotCheck2() {
        DriverFactory.setUp();
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://novaposhta.ua/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle, equalTo("Nova poshta"));
        driver.quit();
    }

}
