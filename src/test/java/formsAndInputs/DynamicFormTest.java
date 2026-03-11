package formsAndInputs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.DynamicForm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static page.ScreenshotHelper.takeScreenshot;
import static util.URL.URL_SAND_BOX;

@DisplayName("Динамическая форма")
public class DynamicFormTest {

    private WebDriver driver;
    DynamicForm dynamicForm;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL_SAND_BOX);

        dynamicForm = new DynamicForm(driver);
    }

    @Test
    @DisplayName("Проверка добавления поля email")
    public void dynamicFormAddButtonEmailFieldTest(){
        dynamicForm.clickDynamicFormAddEmailButton();
        int actualInt = dynamicForm.getDynamicFormEmailFiledCount();
        assertEquals(actualInt, 2);
        takeScreenshot(driver);
    }

    @Test
    @DisplayName("Проверка добавления поля номер телефона")
    public void dynamicFormAddButtonPhoneFieldTest(){
        dynamicForm.clickDynamicFormAddPhoneButton();
        dynamicForm.clickDynamicFormAddPhoneButton();
        int actualInt = dynamicForm.getDynamicFormPhoneFieldCount();
        assertEquals(actualInt, 3);
        takeScreenshot(driver);
    }

    @Test
    @DisplayName("Проверка удаления поля email")
    public void dynamicFormRemoveEmailFieldTest(){
        dynamicForm.clickDynamicFormAddEmailButton();
        dynamicForm.removeDynamicFormEmailField(1);
        int actualInt = dynamicForm.getDynamicFormEmailFiledCount();
        assertEquals(actualInt, 1);
        takeScreenshot(driver);
    }

    @Test
    @DisplayName("Проверка удаления поля номер телефона")
    public void dynamicFormRemovePhoneFieldTest(){
        dynamicForm.clickDynamicFormAddPhoneButton();
        dynamicForm.removeDynamicFormPhonedField(1);
        int actualInt = dynamicForm.getDynamicFormPhoneFieldCount();
        assertEquals(actualInt, 1);
        takeScreenshot(driver);
    }

    @Test
    @DisplayName("Проверка удаления единственного поля email")
    public void dynamicFormEmailLastOneFieldRemoveTest(){
        dynamicForm.removeDynamicFormEmailField(0);;
        String actualText = dynamicForm.getAlertText();
        String expectedText = "Должен остаться хотя бы один email!";
        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Проверка удаления единственного поля номер телефона")
    public void dynamicFormPhoneLastOneFieldRemoveTest(){
        dynamicForm.removeDynamicFormPhonedField(0);
        String actualText = dynamicForm.getAlertText();
        String expectedText = "Должен остаться хотя бы один телефон!";
        assertEquals(expectedText, actualText);
    }

    @Test
    @DisplayName("Проверка отправки динамической формы")
    public void dynamicFormRegistrationTest(){
        dynamicForm.fillingDynamicFormNameField("Max");
        dynamicForm.clickDynamicFormAddEmailButton();
        dynamicForm.fillingDynamicFormEmailField(0, "test@test.ru");
        dynamicForm.fillingDynamicFormEmailField(1, "test2@test2.ru");
        dynamicForm.clickDynamicFormAddPhoneButton();
        dynamicForm.fillingDynamicFormPhoneField(0, "88005553535");
        dynamicForm.fillingDynamicFormPhoneField(1, "+795281273552");
        dynamicForm.clickDynamicFormSendFormButton();
        assertTrue(dynamicForm.dynamicFormCheckSuccessMessage());
        String actualText = dynamicForm.getDynamicFormSuccessMessage();
        String expectedText = "Форма успешно отправлена!";
        assertTrue(actualText.contains(expectedText));
        takeScreenshot(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
