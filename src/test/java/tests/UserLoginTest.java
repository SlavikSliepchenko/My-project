package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import utils.ConfigurationReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoginTest extends BaseTest {


    @Test
    public void LoginTest() {
        context.driver.get(ConfigurationReader.get("url"));
        String headerText;
        SkillMainPage skillMainPage = new SkillMainPage(context);
        headerText = skillMainPage.login().header.getText();
        assertEquals("Панель управления", headerText);
    }

    }

