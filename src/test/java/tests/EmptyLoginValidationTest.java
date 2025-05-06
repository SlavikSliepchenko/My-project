
package tests;

import org.junit.jupiter.api.Test;
import pages.SkillMainPage;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class EmptyLoginValidationTest extends BaseTest {

    @Test
    public void testEmptyLoginValidationMessages() {
        context.driver.get(ConfigurationReader.get("url"));

        SkillMainPage loginPage = new SkillMainPage(context);
        loginPage.submitEmptyLoginForm();

        // Ждём ошибки под полями
        WebElement usernameError = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Имя пользователя обязательно']")
        ));

        WebElement passwordError = context.wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Пароль обязателен']")
        ));

        assertTrue(usernameError.isDisplayed(), "Ожидалась ошибка под полем логина.");
        assertTrue(passwordError.isDisplayed(), "Ожидалась ошибка под полем пароля.");