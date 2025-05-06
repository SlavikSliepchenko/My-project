package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import pages.DashboardPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.*;

public class NavigateToCandidatesPageTest extends BaseTest {

    @Test
    public void testNavigationToCandidatesPage() {
        context.driver.get(ConfigurationReader.get("url"));

        SkillMainPage loginPage = new SkillMainPage(context);
        DashboardPage dashboardPage = loginPage.login();

        dashboardPage.openCandidatesSection();

        String currentUrl = context.driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/dashboard/candidates"),
                "Ожидался переход на /dashboard/candidates, но был: " + currentUrl);
    }
}
