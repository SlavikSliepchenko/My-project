package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import pages.DashboardPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.*;

public class NavigateToCandidatesPageTestVisibility extends BaseTest {

    @Test
    public void testCandidatesAreVisible() {
        context.driver.get(ConfigurationReader.get("url"));

        SkillMainPage loginPage = new SkillMainPage(context);
        DashboardPage dashboardPage = loginPage.login();

        dashboardPage.openCandidatesSection();

        assertTrue(dashboardPage.isCandidatePresent("John Doe"),
                "Кандидат 'John Doe' не найден.");
    }
}
