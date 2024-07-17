package amazon.pages;

import amazon.utilities.Driver;
import amazon.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultsPage {

    public SearchResultsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(SearchResultsPage.class);

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    WebElement aramaSonucuYazisi;

    @FindBy(id = "add-to-wishlist-button-submit")
    WebElement listeyeEkle;

    @FindBy(xpath = "//span[@class='huc-atwl-header-small']")
    WebElement wishListProductTitle;

    @FindBy(xpath = "//button[@data-action='a-popover-close']")
    WebElement wishListCloseButton;

    @FindBy(xpath = "//span[.='Alışveriş Listesi']")
    WebElement productList;

    String expectedProductTitle;
    HomePage hp = new HomePage();

    public void verifySearchedProduct(String product) {
        String aramaSonucYazisi = aramaSonucuYazisi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains(product));
        LOG.info("Arama yapıldığı kontrol edildi.");
    }

    public void clickPage(String pageNumber) {
        WebElement page = Driver.getDriver().findElement(By.xpath("//a[@aria-label='" + pageNumber + " sayfasına git']"));
        ReusableMethods.clickElementByJS(page);
        LOG.info("Arama sonuçları sayfasından " + pageNumber + ". sayfa açıldı.");
    }

    public void verifyPage(String urlPageNumber) {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains(urlPageNumber));
        LOG.info(urlPageNumber + ". sayfasının açıldığı kontrol edildi.");
    }

    public void clickProduct(String urunSirasi) {
        WebElement product = Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + urunSirasi + "]"));
        expectedProductTitle = product.getText();
        product.click();
        ReusableMethods.waitForVisibility(listeyeEkle);
        LOG.info("Sayfadaki " + urunSirasi + ". ürün favorilere eklenir.");
    }

    public void verifyWishList() {
        String actualProductTitle = wishListProductTitle.getText();
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
        wishListCloseButton.click();
        LOG.info("2. Ürünün favorilere eklendiği kontrol edilir.");
    }

    public void goToWishList() {
        ReusableMethods.moveToElementHover(hp.girisYapinMenusu);
        ReusableMethods.waitForVisibility(productList);
        LOG.info("Hesabım > Favori Listem sayfasına gidildi.");
    }

}
