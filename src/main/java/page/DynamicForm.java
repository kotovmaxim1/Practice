package page;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicForm extends BasePage{



    public DynamicForm(WebDriver driver) {
        super(driver);
    }

    private final By dynamicFormNameField = By.xpath("//*[@id=\"dyn-name\"]");
    private final By dynamicFormAddEmailButton = By.xpath("//*[@id=\"addEmailBtn\"]");
    private final By dynamicFormAddPhoneButton = By.xpath("//*[@id=\"addPhoneBtn\"]");
    private final By dynamicFormSendFormButton = By.xpath("//*[@id=\"dynSubmitBtn\"]");
    private final By dynamicFormGroupEmail = By.cssSelector(".email-field-group");
    private final By dynamicFormGroupPhone = By.cssSelector(".phone-field-group");
    private final By dynamicFormRemoveEmailButton = By.cssSelector(".email-field-group button");
    private final By dynamicFormRemovePhoneButton = By.cssSelector(".phone-field-group button");
    private final By dynamicFormEmailField = By.cssSelector(".email-field-group input[type='email']");
    private final By dynamicFormPhoneField = By.cssSelector("#phoneFields > div > input");
    private final By dynamicFormSuccessMessage = By.xpath("//*[@id=\"dynFormResult\"]/div");

    @Step("Получение колличества полей Email")
    public int getDynamicFormEmailFiledCount(){
        return driver.findElements(dynamicFormGroupEmail).size();
    }
    @Step("Нажатие кнопки добавления Email")
    public void clickDynamicFormAddEmailButton(){
        driver.findElement(dynamicFormAddEmailButton).click();
    }
    @Step("Нажатие кнопки добавления Номера телефонов")
    public void clickDynamicFormAddPhoneButton(){
        driver.findElement(dynamicFormAddPhoneButton).click();
    }
    @Step("Получение колличества полей Номера телефонов")
    public int getDynamicFormPhoneFieldCount(){
      return driver.findElements(dynamicFormGroupPhone).size();
    }
    @Step("Удаление поля email {index}")
    public void removeDynamicFormEmailField(int index){
        List<WebElement> removeButtonList = driver.findElements(dynamicFormRemoveEmailButton);
        removeButtonList.get(index).click();
    }
    @Step("Удаление поля номер телефона {index}")
    public void removeDynamicFormPhonedField(int index){
        List<WebElement> removeButtonList = driver.findElements(dynamicFormRemovePhoneButton);
        removeButtonList.get(index).click();
    }
    @Step("Получение текста алерта")
    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    @Step("Заполнение имени в динамической форме")
    public void fillingDynamicFormNameField(String name){
        driver.findElement(dynamicFormNameField).sendKeys(name);
    }
    @Step("Заполнение email в динамической форме")
    public void fillingDynamicFormEmailField(int index, String email){
        List<WebElement> emailFieldList = driver.findElements(dynamicFormEmailField);
        emailFieldList.get(index).sendKeys(email);
    }
    @Step("Заполнение номера телефона в динамической форме")
    public void fillingDynamicFormPhoneField(int index, String phone){
        List<WebElement> phoneFieldList = driver.findElements(dynamicFormPhoneField);
        phoneFieldList.get(index).sendKeys(phone);
    }
    @Step("Отображение сообщение о успешной регистрации")
    public boolean dynamicFormCheckSuccessMessage(){
        return driver.findElement(dynamicFormSuccessMessage).isDisplayed();
    }
    @Step("Получение текста о успешной регистрации")
    public String getDynamicFormSuccessMessage(){
        return driver.findElement(dynamicFormSuccessMessage).getText();
    }
    @Step("Нажатие кнопки Отправить форму")
    public void clickDynamicFormSendFormButton(){
        driver.findElement(dynamicFormSendFormButton).click();
    }

}
