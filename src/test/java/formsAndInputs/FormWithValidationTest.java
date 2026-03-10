package formsAndInputs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FormWithValidation;

import static org.junit.jupiter.api.Assertions.*;
import static util.URL.URL_SAND_BOX;

@DisplayName("Форма регистрации с валидацией")
public class FormWithValidationTest {

    private WebDriver driver;
    FormWithValidation formWithValidation;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL_SAND_BOX);

        formWithValidation = new FormWithValidation(driver);
    }

    @Test
    @DisplayName("Позитивная проверка формы регистрации с валидацией")
    public void formWithValidationTest(){
        formWithValidation.fillingWithValidationUsernameField("maxim");
        formWithValidation.fillingWithValidationEmailField("test@test.ru");
        formWithValidation.fillingWithValidationPasswordField("qwe12345");
        formWithValidation.filingWithValidationRepeatPasswordField("qwe12345");
        formWithValidation.clickWithValidationCheckAndSendButton();
        assertFalse(formWithValidation.findWithValidationErrorUsernameMessage());
        assertFalse(formWithValidation.findWithValidationErrorEmailMessage());
        assertFalse(formWithValidation.findWithValidationErrorPasswordMessage());
        assertFalse(formWithValidation.findWithValidationErrorRepeatPasswordMessage());
        assertTrue(formWithValidation.findWithValidationSuccessMessage());
        String actualText = formWithValidation.getWithValidationSuccessMessage();
        String expectedText = "Все проверки пройдены! Форма валидна.";
        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Проверка получения ошибки Username")
    public void formWithValidationErrorUsernameTest(){
        formWithValidation.fillingWithValidationUsernameField("max");
        formWithValidation.fillingWithValidationEmailField("test@test.ru");
        formWithValidation.fillingWithValidationPasswordField("qwe12345");
        formWithValidation.filingWithValidationRepeatPasswordField("qwe12345");
        formWithValidation.clickWithValidationCheckAndSendButton();
        assertTrue(formWithValidation.findWithValidationErrorUsernameMessage());
        String actualText = formWithValidation.getWithValidationErrorUsernameMessage();
        String expectedText = "Username должен содержать минимум 5 символов";
        assertEquals(expectedText, actualText);
        assertTrue(formWithValidation.findWithValidationSuccessMessage());
        actualText = formWithValidation.getWithValidationSuccessMessage();
        expectedText = "Форма содержит ошибки. Исправьте их и попробуйте снова.";
        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Проверка получения ошибки Email")
    public void formWithValidationErrorEmailTest(){
        formWithValidation.fillingWithValidationUsernameField("maxim");
        formWithValidation.fillingWithValidationEmailField("test.ru");
        formWithValidation.fillingWithValidationPasswordField("qwe12345");
        formWithValidation.filingWithValidationRepeatPasswordField("qwe12345");
        formWithValidation.clickWithValidationCheckAndSendButton();
        assertTrue(formWithValidation.findWithValidationErrorEmailMessage());
        String actualText = formWithValidation.getWithValidationErrorEmailMessage();
        String expectedText = "Email должен содержать символ @";
        assertEquals(expectedText, actualText);
        actualText = formWithValidation.getWithValidationSuccessMessage();
        expectedText = "Форма содержит ошибки. Исправьте их и попробуйте снова.";
        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Проверка получения ошибки повторного пароля")
    public void formWithValidationRepeatTest(){
        formWithValidation.fillingWithValidationUsernameField("maxim");
        formWithValidation.fillingWithValidationEmailField("test@test.ru");
        formWithValidation.fillingWithValidationPasswordField("qwe12345");
        formWithValidation.filingWithValidationRepeatPasswordField("qwe123");
        formWithValidation.clickWithValidationCheckAndSendButton();
        assertTrue(formWithValidation.findWithValidationErrorRepeatPasswordMessage());
        String actualText = formWithValidation.getWithValidationErrorRepeatPasswordMessage();
        String expectedText = "Пароли не совпадают";
        assertEquals(expectedText, actualText);
        actualText = formWithValidation.getWithValidationSuccessMessage();
        expectedText = "Форма содержит ошибки. Исправьте их и попробуйте снова.";
        assertEquals(expectedText, actualText);
    }

    @ParameterizedTest (name = "- {0}")
    @ValueSource(strings = {"qwe1234", "qwertyas", "12345678"})
    @DisplayName("Проверка получения ошибки пароля")
    public void formWithValidationPasswordTest(String password){
        formWithValidation.fillingWithValidationUsernameField("maxim");
        formWithValidation.fillingWithValidationEmailField("test@test.ru");
        formWithValidation.fillingWithValidationPasswordField(password);
        formWithValidation.filingWithValidationRepeatPasswordField(password);
        formWithValidation.clickWithValidationCheckAndSendButton();
        assertTrue(formWithValidation.findWithValidationErrorPasswordMessage());
        String actualText = formWithValidation.getWithValidationErrorPasswordMessage();
        String expectedText = "Password должен содержать минимум 8 символов, включая буквы и цифры";
        assertEquals(expectedText, actualText);
        actualText = formWithValidation.getWithValidationSuccessMessage();
        expectedText = "Форма содержит ошибки. Исправьте их и попробуйте снова.";
        assertEquals(expectedText, actualText);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
