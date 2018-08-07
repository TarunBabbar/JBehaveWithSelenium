package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UISteps extends Steps {

    private static WebDriver driver = null;

    @Given("I open a browser")
    public void openABrowser()
    {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "/src/ChromeDriver.driver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-extensions");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }

        driver.manage().deleteAllCookies();
    }

    @When("I enter $url and hit the enter key")
    public void LaunchGoogleBrowser(String url)
    {
        driver.get(url);
    }

    @Then("$title is displayed")
    public void lookingForPageTitle(String title)
    {
        Assert.assertEquals(title, driver.getTitle());
    }
}
