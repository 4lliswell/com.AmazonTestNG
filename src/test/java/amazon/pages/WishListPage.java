package amazon.pages;

import amazon.utilities.Driver;
import amazon.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WishListPage {

    public WishListPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(WishListPage.class);

    @FindBy(id = "profile-list-name")
    WebElement wishListTitle;

    @FindBy(name = "submit.deleteItem")
    WebElement deleteButon;

    @FindBy(xpath = "//div[.='Silindi']")
    WebElement silindiText;

    @FindBy(xpath = "//span[.='Çıkış Yap']")
    WebElement exitButton;

    @FindBy(xpath = "//h1")
    WebElement girisYapText;

    HomePage hp = new HomePage();

    public void verifyWishList() {
        Assert.assertTrue(wishListTitle.isDisplayed());
        LOG.info("“Favori Listem” sayfası açıldığı kontrol edildi.");
    }

    public void deleteProduct() {
        deleteButon.click();
        LOG.info("Eklenen ürün favorilerden silindi.");
    }

    public void verifyDeleteProduct() {
        Assert.assertTrue(silindiText.isDisplayed());
        LOG.info("Silme işleminin gerçekleştiği kontrol edildi.");
    }

    public void logoutProfile() {
        ReusableMethods.moveToElementHover(hp.girisYapinMenusu);
        ReusableMethods.waitForVisibility(exitButton);
        LOG.info("Üye çıkış işlemi yapıldı.");
    }

    public void verifyLogout() {
        Assert.assertTrue(girisYapText.isDisplayed());
        LOG.info("Çıkış işleminin yapıldığı kontrol edildi.");
    }

}
