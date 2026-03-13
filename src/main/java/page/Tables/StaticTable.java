package page.Tables;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;

import java.util.List;

public class StaticTable extends BasePage {

    public StaticTable(WebDriver driver) {
        super(driver);
    }

    private final By staticTableHeaderID = By.xpath("//*[@id=\"usersTable\"]/thead/tr/th[1]");
    private final By staticTableHeaderName = By.xpath("//*[@id=\"usersTable\"]/thead/tr/th[2]");
    private final By staticTableHeaderEmail = By.xpath("//*[@id=\"usersTable\"]/thead/tr/th[3]");
    private final By staticTableHeaderStatus = By.xpath("//*[@id=\"usersTable\"]/thead/tr/th[4]");
    private final By staticTableHeaderActions = By.xpath("//*[@id=\"usersTable\"]/thead/tr/th[5]");
    private final By staticTableGroupData = By.cssSelector("#usersTable > tbody");
    private final By staticTableRowsData = By.cssSelector("tbody tr");


    @Step("Получение названия заголовка ID")
    public String getStaticTableHeaderID(){
        return driver.findElement(staticTableHeaderID).getText();
    }
    @Step("Получение названия заголовка Name")
    public String getStaticTableHeaderName(){
        return driver.findElement(staticTableHeaderName).getText();
    }
    @Step("Получение названия заголовка Email")
    public String getStaticTableHeaderEmail(){
        return driver.findElement(staticTableHeaderEmail).getText();
    }
    @Step("Получение названия заголовка Status")
    public String getStaticTableHeaderStatus(){
        return driver.findElement(staticTableHeaderStatus).getText();
    }
    @Step("Получение названия заголовка Actions")
    public String getStaticTableHeaderActions(){
        return driver.findElement(staticTableHeaderActions).getText();
    }
    @Step("Прокрутка до элемента")
    public void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    @Step("Получение колличества строк в таблице")
    public int getStaticTableGroupDataSize(){
        WebElement tbody = driver.findElement(staticTableGroupData);
        return tbody.findElements(By.tagName("tr")).size();
    }
    @Step("Получение айди по таблице")
    public String getStaticTableDataID(int index){
        List<WebElement> rows = driver.findElements(staticTableRowsData);
        WebElement row = rows.get(index);
        List<WebElement>cells = row.findElements(By.tagName("td"));
        return cells.get(0).getText();
    }
    @Step("Получение имени по таблице")
    public String getStaticTableDataName(int index){
        List<WebElement> rows = driver.findElements(staticTableRowsData);
        WebElement row = rows.get(index);
        List<WebElement>cells = row.findElements(By.tagName("td"));
        return cells.get(1).getText();
    }
    @Step("Получение email по таблице")
    public String getStaticTableDataEmail(int index){
        List<WebElement> rows = driver.findElements(staticTableRowsData);
        WebElement row = rows.get(index);
        List<WebElement>cells = row.findElements(By.tagName("td"));
        return cells.get(2).getText();
    }
    @Step("Получение статуса по таблице")
    public String getStaticTableDataStatus(int index){
        List<WebElement> rows = driver.findElements(staticTableRowsData);
        WebElement row = rows.get(index);
        List<WebElement>cells = row.findElements(By.tagName("td"));
        return cells.get(3).getText();
    }
}
