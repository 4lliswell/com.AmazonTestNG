package amazon.pages;

import amazon.utilities.ConfigReader;
import amazon.utilities.Driver;
import amazon.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    @FindBy(id = "sp-cc-accept")
    WebElement cookiesAccept;

    @FindBy(id = "nav-link-accountList")
    WebElement girisYapinMenusu;

    @FindBy(xpath = "//a[@class='nav-action-signin-button']")
    WebElement girisYapButton;

    @FindBy(id = "ap_email")
    WebElement emailBox;

    @FindBy(id = "ap_password")
    WebElement passwordBox;

    @FindBy(id = "searchDropdownBox")
    WebElement dropDownSelect;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    Select select;

    public void goToUrl(String URL) {
        Driver.getDriver().get(ConfigReader.getProperty(URL));
        LOG.info(ConfigReader.getProperty(URL) + " sitesi açıldı");
    }

    public void verifyUrl(String expectedUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        LOG.info("Ana sayfanın açıldığı kontrol edildi");
    }

    public void cookiesAccept() {
        cookiesAccept.click();
        LOG.info("Çerez tercihlerinden Çerezleri kabul et seçildi.");
    }

    public void loginProfile(String email, String password) {
        ReusableMethods.moveToElementHover(girisYapinMenusu);
        ReusableMethods.waitForVisibility(girisYapButton);
        sendText(emailBox, email);
        sendText(passwordBox, password);
        LOG.info("Siteye login olundu");
    }

    public void sendText(WebElement element, String text) {

        element.sendKeys(ConfigReader.getProperty(text) + Keys.ENTER);
    }

    public void verifyLogin() {
        String actualLoginResult = girisYapinMenusu.getText();
        Assert.assertFalse(actualLoginResult.contains("Merhaba"));
        LOG.info("Login işlemi kontrol edildi.");
    }

    public void selectCategory(String kategori) {
        select = new Select(dropDownSelect);
        select.selectByVisibleText(kategori);
        LOG.info("Arama butonu yanındaki kategoriler tabından bilgisayar seçildi.");
    }

    public void verifyCategory(String expectedCategori) {
        String actualSelect = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelect, expectedCategori);
        LOG.info("Bilgisayar kategorisi seçildiği kontrol edildi.");
    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product + Keys.ENTER);
        LOG.info("Arama alanına " + product + " yazılır ve arama yapıldı.");
    }
}
