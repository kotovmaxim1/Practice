package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SimpleFormRegistration extends BasePage {

    public SimpleFormRegistration (WebDriver driver) {
        super(driver);
    }

    // Локатор поля Username
    private final By SimpleUsernameField = By.xpath("//*[@id=\"username\"]");
    //Локатор поля Email
    private final By SimpleEmailField = By.xpath("//*[@id=\"email\"]");
    //Локатор поля Password
    private final By SimplePasswordField = By.xpath("//*[@id=\"password\"]");
    //Локатор выпадающего списка Country
    private final By SimpleCountry = By.xpath("//*[@id=\"country\"]");
    //Локатор Russia в выпадающем списке Country
    private final By SimpleCountryRussia = By.xpath("//*[@id=\"country\"]/option[2]");
    //Локатор чек бокса Simple Terms and Condition
    private final By SimpleCheckBoxTermsAndCondition = By.xpath("//*[@id=\"terms\"]");
    //Локатор кнопки Simple Register
    private final By ButtonSimpleRegister = By.xpath("//*[@id=\"submitBtn\"]");
    //Локатор сообщения успешной регистрации
    private final By SimpleRegisterSuccess = By.xpath("//*[@id=\"formResult\"]/div/p");

    @Step("Заполнение username в простой форме регистрации")
    public void filingUsernameSimpleFormRegistration(String username){
        driver.findElement(SimpleUsernameField).sendKeys(username);
    }
    @Step("Заполнение email в простой форме регистрации")
    public void filingSimpleEmailField(String email){
        driver.findElement(SimpleEmailField).sendKeys(email);
    }
    @Step("Заполнение password в простой форме регистрации")
    public void filingSimplePasswordField(String password){
        driver.findElement(SimplePasswordField).sendKeys(password);
    }
    @Step("Нажатие по выпадающему списку Country")
    public void clickSimpleCountry(){
        driver.findElement(SimpleCountry).click();
    }
    @Step("Нажатие в выпадающем спике по Russia")
    public void clickSimpleCountryRussia(){
        driver.findElement(SimpleCountryRussia).click();
    }
    @Step("Заполнение чек бокса Simple Terms and Condition")
    public void clickSimpleCheckBoxTermsAndCondition(){
        driver.findElement(SimpleCheckBoxTermsAndCondition).click();
    }
    @Step("Нажатие кнопки Simple Register")
    public void clickButtonSimpleRegister(){
        driver.findElement(ButtonSimpleRegister).click();
    }
    @Step("Получение текста успешной регистрации")
    public String findSimpleRegisterSuccessText(){
        String SimpleRegisterSuccessText = driver.findElement(SimpleRegisterSuccess).getText();
        return SimpleRegisterSuccessText;
    }

}
