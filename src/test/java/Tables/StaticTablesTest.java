package Tables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ScreenshotHelper;
import page.Tables.StaticTable;
import util.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Статическая таблица")
public class StaticTablesTest {

    private WebDriver driver;
    StaticTable staticTable;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL.URL_SAND_BOX);

        staticTable = new StaticTable(driver);
    }

    @Test
    @DisplayName("Проверка элементов хедера статической таблицы")
    public void checkStaticTableHeaderTest(){
        staticTable.scrollToElement(driver.findElement(By.xpath("//*[@id=\"tables\"]/div[2]")));
        String actualID = staticTable.getStaticTableHeaderID();
        String actualName = staticTable.getStaticTableHeaderName();
        String actualEmail = staticTable.getStaticTableHeaderEmail();
        String actualStatus = staticTable.getStaticTableHeaderStatus();
        String actualActions = staticTable.getStaticTableHeaderActions();
        assertEquals("ID", actualID);
        assertEquals("Name", actualName);
        assertEquals("Email", actualEmail);
        assertEquals("Status", actualStatus);
        assertEquals("Actions", actualActions);
        ScreenshotHelper.takeScreenshot(driver);
    }

    @Test
    @DisplayName("Проверка данных в статической таблице")
    public void checkStaticTableDataTest(){
        int actualInt = staticTable.getStaticTableGroupDataSize();
        assertEquals(3, actualInt);
        assertEquals("1", staticTable.getStaticTableDataID(0));
        assertEquals("John Doe", staticTable.getStaticTableDataName(0));
        assertEquals("john@example.com", staticTable.getStaticTableDataEmail(0));
        assertEquals("Active", staticTable.getStaticTableDataStatus(0));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
