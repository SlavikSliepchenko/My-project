package pages;


import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

    public class DashboardPage extends BasePage {
        public DashboardPage(TestContext context) {
            super(context);
            context.wait.until(ExpectedConditions.visibilityOf(header));
        }
        @FindBy(xpath = "//h1[contains(text(), 'Панель управления')]")
        public WebElement header;

    }

