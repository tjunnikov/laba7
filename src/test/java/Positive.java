import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Positive {
    @DataProvider(name = "NewPers")
    public Object[] NewPers() {
        Person[] res = new Person[1];
        res[0] = new Person(
                "Poli",
                "Po",
                "poli.po@mail.com",
                "qqwweerr",
                1,
                "April",
                2000,
                "SW 26th Rd",
                "Miami",
                "Florida",
                33129,
                21,
                "89023601635"
        );
        return res;
    }


    @Test(dataProvider = "NewPers")
    public void mainTest(Person pers) {
        WebElement signInLink, enter, nameLabel;
        System.setProperty("webdriver.chrome.driver", "C:/Users/HP/AppData/Local/Google/Chrome/User Data/chromedriver.exe");
        WebDriver dr = new ChromeDriver();

        dr.get("http://automationpractice.com/");//открытие сайта
        // переход на страницу регистрации
        signInLink = (new WebDriverWait(dr, 10)).until(presenceOfElementLocated(By.className("login")));
        signInLink.click();
        //email
        (new WebDriverWait(dr, 10)).until(presenceOfElementLocated(By.id("email_create"))).sendKeys(pers.email);
        (new WebDriverWait(dr, 10)).until(presenceOfElementLocated(By.id("create-account_form"))).submit();

        enter = (new WebDriverWait(dr, 10)).until(presenceOfElementLocated(By.id("firstnm")));
        enter.sendKeys(pers.firstName);// имя
        enter = dr.findElement(By.id("lastnm"));
        enter.sendKeys(pers.lastName);// фамилия
        enter = dr.findElement(By.id("password"));
        enter.sendKeys(pers.password);// пароль
        enter = dr.findElement(By.id("days"));
        enter.sendKeys(Integer.toString(pers.dayBirth));
        enter = dr.findElement(By.id("months"));
        enter.sendKeys(pers.monthBirth);
        enter = dr.findElement(By.id("years"));
        enter.sendKeys(Integer.toString(pers.yearBirth));
        enter = dr.findElement(By.id("firstname"));
        enter.sendKeys(pers.firstName);
        enter = dr.findElement(By.id("lastname"));
        enter.sendKeys(pers.lastName);
        enter = dr.findElement(By.id("addr"));
        enter.sendKeys(pers.address);
        enter = dr.findElement(By.id("city"));
        enter.sendKeys(pers.city); //город
        enter = dr.findElement(By.id("id_country"));
        enter.sendKeys(Integer.toString(pers.country));//страна
        enter = (new WebDriverWait(dr, 10)).until(presenceOfElementLocated(By.id("id_state")));
        enter.sendKeys(pers.state);//штат
        enter = dr.findElement(By.id("index"));
        enter.sendKeys(Integer.toString(pers.zip));//индекс
        enter = dr.findElement(By.id("number"));
        enter.sendKeys(pers.phone);

        //регистрация
        dr.findElement(By.id("reg")).click();
        nameLabel = (new WebDriverWait(dr, 10)).until(presenceOfElementLocated(By.cssSelector("a.account > span")));
        assertThat(nameLabel.getText(), equalTo(pers.firstName + " " + pers.lastName));
    }
}
