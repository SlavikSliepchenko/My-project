package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CandidatePage extends BasePage{

    public CandidatePage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.visibilityOf(header));
    }
    @FindBy(xpath = "//h1[contains(text(), 'Кандидаты')]")
    public WebElement header;
}
