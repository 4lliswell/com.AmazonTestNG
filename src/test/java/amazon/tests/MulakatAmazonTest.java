package amazon.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import amazon.pages.AmazonPage;
import amazon.utilities.ConfigReader;
import amazon.utilities.Driver;
import amazon.utilities.ReusableMethods;

public class MulakatAmazonTest  {

    @Test
    public void amazonTest() {

        //1. https://www.amazon.com.tr/ sitesi açılır.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //2. Ana sayfanın açıldığı kontrol edilir.
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("amazonUrl");
        Assert.assertEquals(actualUrl,expectedUrl);

        //3. Çerez tercihlerinden Çerezleri kabul et seçilir.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.txtCookies.click(); // cookies`i kabul ettik.

        //4. Siteye login olunur.
        ReusableMethods.locateUzerindeBekle(amazonPage.txtGirisYapinPencere);
        ReusableMethods.yukleneneKadarBekle(amazonPage.txtGirisYap);

        amazonPage.txtemailBox.sendKeys(ConfigReader.getProperty("amazonEmail") + Keys.ENTER);
        amazonPage.txtPasswordBox.sendKeys(ConfigReader.getProperty("amazonPassword")+Keys.ENTER);

        //5. Login işlemi kontrol edilir.
        String actualLoginResult = amazonPage.loginTextYazisi.getText();
        Assert.assertTrue(actualLoginResult.contains(" ")); // Amazon Kullanici adinizi yaziniz

        //6. Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        Select select = new Select(amazonPage.searchDropdownBox);
        select.selectByVisibleText("Bilgisayarlar");

        //7. Bilgisayar kategorisi seçildiği kontrol edilir.
        String actualSelect = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelect, "Bilgisayarlar");

        //8. Arama alanına MSI yazılır ve arama yapılır.
        amazonPage.txtSearchbox.sendKeys("MSI"+Keys.ENTER);

        //9. Arama yapıldığı kontrol edilir.
        String aramaSonucYazisi = amazonPage.aramaSonucYazisi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("MSI"));

        //10. Arama sonuçları sayfasından 2. sayfa açılır.
        ReusableMethods.javaScriptExcecuter(amazonPage.ikinciSayfa);

        //11. 2. sayfanın açıldığı kontrol edilir.
        String actualIkinciSayfaUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualIkinciSayfaUrl.contains("page=2"));

        //12. Sayfadaki 2. ürün favorilere eklenir.
        amazonPage.secondProduct.click();
        amazonPage.favoriekle.click();

        //13. 2. Ürünün favorilere eklendiği kontrol edilir.
        Assert.assertTrue(amazonPage.wishList.getText().contains("1"));


        //14. Hesabım > Favori Listem sayfasına gidilir.
        amazonPage.listDisplayed.click();

        //15. “Favori Listem” sayfası açıldığı kontrol edilir.
        String favoriListemUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(favoriListemUrl.contains("wishlist"));

        //16. Eklenen ürün favorilerden silinir.
        amazonPage.deleteButon.click();

        //17. Silme işleminin gerçekleştiği kontrol edilir.
        Assert.assertTrue(amazonPage.silindi.isDisplayed());

        //18. Üye çıkış işlemi yapılır.
        ReusableMethods.locateUzerindeBekle(amazonPage.txtGirisYapinPencere);
        ReusableMethods.yukleneneKadarBekle(amazonPage.exitbutton);

        //19. Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertTrue(amazonPage.girisButon.isDisplayed());


        Driver.closeDriver();
    }
}
