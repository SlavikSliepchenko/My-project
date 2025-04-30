package pages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;

import java.time.Duration;

public class SkillMainPage extends BasePage{
    public SkillMainPage(TestContext context) {
        super(context);
    }
    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement userName;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement enterButton;



    public DashboardPage login(){

        userName.sendKeys(ConfigurationReader.get("userName"));
        userPassword.sendKeys(ConfigurationReader.get("userPassword"));
        enterButton.click();
        return new DashboardPage(context);


    }

    public String getLoginErrorToastText() {
        userName.sendKeys(ConfigurationReader.get("userName"));
        userPassword.sendKeys(ConfigurationReader.get("wrongPassword"));
        enterButton.click();

        WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(5));
        WebElement errorToast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error-toast')]")));
        return errorToast.getText();
    }
}
