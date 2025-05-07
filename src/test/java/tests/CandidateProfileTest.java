package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import pages.DashboardPage;
import pages.CandidatePage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateProfileTest extends BaseTest {

    @Test
    public void testCandidateProfileDisplaysCorrectly() {
        context.driver.get(ConfigurationReader.get("url"));

        SkillMainPage loginPage = new SkillMainPage(context);
        DashboardPage dashboardPage = loginPage.login();

        dashboardPage.openCandidatesSection();

        assertTrue(dashboardPage.isCandidatePresent("John Doe"), "Кандидат 'John Doe' не найден.");

        dashboardPage.clickCandidateByName("John Doe");

        CandidatePage candidatePage = new CandidatePage(context);

        assertTrue(candidatePage.header.isDisplayed(), "Заголовок не отображается.");
        assertEquals("john.doe@example.com", candidatePage.email.getText(), "Неверный email.");
        assertEquals("Frontend Developer", candidatePage.position.getText(), "Неверная должность.");
        assertEquals("JavaScript Fundamentals", candidatePage.activeTestTitle.getText(), "Неверный активный тест.");
    }
}