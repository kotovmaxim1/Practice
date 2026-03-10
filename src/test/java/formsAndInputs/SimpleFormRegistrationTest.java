package formsAndInputs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SimpleFormRegistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.URL.URL_SAND_BOX;

@DisplayName("Простая форма авторизации")
public class SimpleFormRegistrationTest {

    private WebDriver driver;
    SimpleFormRegistration simpleFormRegistration;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL_SAND_BOX);

        simpleFormRegistration = new SimpleFormRegistration(driver);
    }

    @Test
    @DisplayName("Проверка простой формы регистрации")
    public void SimpleFormRegistrationTest(){
        simpleFormRegistration.filingUsernameSimpleFormRegistration("maxim");
        simpleFormRegistration.filingSimpleEmailField("test@test.ru");
        simpleFormRegistration.filingSimplePasswordField("12345");
        simpleFormRegistration.clickSimpleCountry();
        simpleFormRegistration.clickSimpleCountryRussia();
        simpleFormRegistration.clickSimpleCheckBoxTermsAndCondition();
        simpleFormRegistration.clickButtonSimpleRegister();
        String actualText = simpleFormRegistration.findSimpleRegisterSuccessText();
        String expectedText = "Форма успешно отправлена!";
        assertEquals(expectedText, actualText);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
