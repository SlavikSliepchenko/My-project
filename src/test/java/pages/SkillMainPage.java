package pages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

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
        By toastLocator = By.xpath("//li[contains(@class,'destructive') and @role='status']");
        WebElement toast = context.wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastLocator)
        );
        return toast.getText().trim();
    }
}
