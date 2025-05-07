
package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import pages.DashboardPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateToSettingsPageTest extends BaseTest {

    @Test
    public void testNavigationToSettingsPage() {
        context.driver.get(ConfigurationReader.get("url"));

        SkillMainPage loginPage = new SkillMainPage(context);
        DashboardPage dashboardPage = loginPage.login();

        dashboardPage.openSettingsSection();

        // Проверка URL
        String currentUrl = context.driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/dashboard/settings"),
                "Ожидался переход на /dashboard/settings, но текущий URL: " + currentUrl);

        // Проверка заголовка "Настройки"
        WebElement heading = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(), 'Настройки')]")));
        assertTrue(heading.isDisplayed(), "Заголовок 'Настройки' не отображается.");

        // Проверка, что активна вкладка "Профиль"
        WebElement activeTab = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@data-state='active' and contains(., 'Профиль')]")));
        assertTrue(activeTab.isDisplayed(), "Вкладка 'Профиль' не активна.");
    }
}