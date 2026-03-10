package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormWithValidation extends BasePage {

    public FormWithValidation(WebDriver driver) {
        super(driver);
    }

    private final By withValidationUsernameField = By.xpath("//*[@id=\"val-username\"]");
    private final By withValidationEmailField= By.xpath("//*[@id=\"val-email\"]");
    private final By withValidationPasswordField = By.xpath("//*[@id=\"val-password\"]");
    private final By withValidationRepeatPasswordField = By.xpath("//*[@id=\"val-confirm-password\"]");
    private final By withValidationCheckAndSendButton = By.xpath("//*[@id=\"valSubmitBtn\"]");
    private final By withValidationErrorMessage = By.xpath("//*[@id=\"valFormResult\"]/div/p");
    private final By withValidationErrorUsernameMessage = By.xpath("//*[@id=\"username-error\"]");
    private final By withValidationErrorEmailMessage = By.xpath("//*[@id=\"email-error\"]");
    private final By withValidationErrorPasswordMessage = By.xpath("//*[@id=\"password-error\"]");
    private final By withValidationErrorRepeatPasswordMessage = By.xpath("//*[@id=\"confirm-password-error\"]");
    private final By withValidationSuccessMessage = By.xpath("//*[@id=\"valFormResult\"]/div/p");

    @Step("Заполнение username в форме с валидацией")
    public void fillingWithValidationUsernameField(String username){
        driver.findElement(withValidationUsernameField).sendKeys(username);
    }
    @Step("Заполнение email в форме с валидацией")
    public void fillingWithValidationEmailField(String email){
        driver.findElement(withValidationEmailField).sendKeys(email);
    }
    @Step("Заполнение password в форме с валдиацией")
    public void fillingWithValidationPasswordField(String password){
        driver.findElement(withValidationPasswordField).sendKeys(password);
    }
    @Step("Заполнение Подтвердите Password в форме с валдиацией")
    public void filingWithValidationRepeatPasswordField(String password){
        driver.findElement(withValidationRepeatPasswordField).sendKeys(password);
    }
    @Step("Нажатие кнопки Проверить и отправить на форме с валидацией")
    public void clickWithValidationCheckAndSendButton(){
        driver.findElement(withValidationCheckAndSendButton).click();
    }
    @Step("Получение общего сообщения об ошибке на форме с валидацией")
    public boolean findWithValidationErrorMessage(){
        return driver.findElement(withValidationErrorMessage).isDisplayed();
    }
    @Step("Отображение сообщения об ошибке username на форме с валидацией")
    public boolean findWithValidationErrorUsernameMessage(){
        return driver.findElement(withValidationErrorUsernameMessage).isDisplayed();
    }
    @Step("Получение сообщения об ошибке username на форме с валидацией ")
    public String getWithValidationErrorUsernameMessage(){
        return driver.findElement(withValidationErrorUsernameMessage).getText();
    }
    @Step("Отображение сообщение об ошибке email на форме с валидацией")
    public boolean findWithValidationErrorEmailMessage(){
        return driver.findElement(withValidationErrorEmailMessage).isDisplayed();
    }
    @Step("Получение сообщение об ошибке email на форме с валидацией")
    public String getWithValidationErrorEmailMessage(){
        return driver.findElement(withValidationErrorEmailMessage).getText();
    }
    @Step("Отображние сообщения об ошибке password на форме с валидацией")
    public boolean findWithValidationErrorPasswordMessage(){
        return driver.findElement(withValidationErrorPasswordMessage).isDisplayed();
    }
    @Step("Получение сообщения об ошибке password на форме с валидацие")
    public String getWithValidationErrorPasswordMessage(){
        return driver.findElement(withValidationErrorPasswordMessage).getText();
    }
    @Step("Отображение сообщения об ошибке Подтвердите Password на форме с валидацией")
    public boolean findWithValidationErrorRepeatPasswordMessage(){
        return driver.findElement(withValidationErrorRepeatPasswordMessage).isDisplayed();
    }
    @Step("Получение сообщения об ошибке Подтвердите Password на форме с валидацией")
    public String getWithValidationErrorRepeatPasswordMessage(){
        return driver.findElement(withValidationErrorRepeatPasswordMessage).getText();
    }
    @Step("Отображение сообщения об успешной ргистрации")
    public boolean findWithValidationSuccessMessage(){
        return driver.findElement(withValidationSuccessMessage).isDisplayed();
    }
    @Step("Получение сообщения об успешной регистрации")
    public String getWithValidationSuccessMessage(){
        return driver.findElement(withValidationSuccessMessage).getText();
    }
}
