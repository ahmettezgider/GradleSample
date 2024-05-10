package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Config;
import util.ConfigReader;
import webdriver.Driver;

import java.io.IOException;
import java.time.Duration;

public class Stepdefs {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void before() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void after() {
        driver.quit();
    }

    By lSearchInput = By.cssSelector("#search input");
    By lListedProducts = By.cssSelector(".product-thumb");

    @Given("user on main page")
    public void userOnMainPage() throws IOException {
        Config config = ConfigReader.instance().getTestConfiguration();
        String url = config.getApplication().getUrl();
        driver.get(url);
    }

    @When("user search for {string}")
    public void userSearchFor(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchInput)).sendKeys(text, Keys.ENTER);
    }

    @Then("results should be listed")
    public void resultsShouldBeListed() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lListedProducts, 0));
    }
}
