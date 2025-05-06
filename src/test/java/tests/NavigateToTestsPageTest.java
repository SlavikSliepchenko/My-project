
package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import pages.DashboardPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.*;

public class NavigateToTestsPageTest extends BaseTest {

    @Test
    public void testNavigationToTestsPage() {
        context.driver.get(ConfigurationReader.get("url"));

        SkillMainPage loginPage = new SkillMainPage(context);
        DashboardPage dashboardPage = loginPage.login();

        dashboardPage.openTestsSection();

        String currentUrl = context.driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/dashboard/tests"), "Ожидался переход на страницу /dashboard/tests, но был: " +