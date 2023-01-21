package amazon.tests;

import amazon.utilities.TestBaseReport;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import amazon.pages.AmazonPage;
import amazon.utilities.ConfigReader;
import amazon.utilities.Driver;
import amazon.utilities.ReusableMethods;

public class MulakatAmazonTest extends TestBaseReport {

    @Test
    public void amazonTest() {
        extentTest = extentReports.createTest("amazonTest",
                "Kullanici Amazon Sitesine Login Sepete Olup Urun Ekleyip Cikarabilmeli ve Cikis Yapabilmeli ");

        //1. https://www.amazon.com.tr/ sitesi açılır.
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon Sitesi Açıldı");

        //2. Ana sayfanın açıldığı kontrol edilir.
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("amazonUrl");
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.info("Ana Sayfanın Açıldığı Kontrol Edildi");

        //3. Çerez tercihlerinden Çerezleri kabul et seçilir.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.txtCookies.click(); // cookies`i kabul ettik.
        extentTest.info("Çerez Tercihlerinden Çerezler Kabul Edildi");

        //4. Siteye login olunur.
        ReusableMethods.moveToElementHover(amazonPage.txtGirisYapinPencere);
        ReusableMethods.waitForVisibility(amazonPage.txtGirisYap);

        amazonPage.txtemailBox.sendKeys(ConfigReader.getProperty("amazonEmail") + Keys.ENTER);
        amazonPage.txtPasswordBox.sendKeys(ConfigReader.getProperty("amazonPassword")+Keys.ENTER);
        extentTest.info("Siteye Kullanıcı Bilgileriyle Login Olundu");

        //5. Login işlemi kontrol edilir.
        String actualLoginResult = amazonPage.loginTextYazisi.getText();
        Assert.assertFalse(actualLoginResult.contains("Merhaba"));
        extentTest.info("Login İşlemi Kontrol Edildi");

        //6. Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        Select select = new Select(amazonPage.searchDropdownBox);
        select.selectByVisibleText("Bilgisayarlar");
        extentTest.info("Bilgisayarlar Kategorisi Seçildi");

        //7. Bilgisayar kategorisi seçildiği kontrol edilir.
        String actualSelect = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelect, "Bilgisayarlar");
        extentTest.info("Bilgisayar Kategorisi Seçildiği Kontrol Edildi");

        //8. Arama alanına MSI yazılır ve arama yapılır.
        amazonPage.txtSearchbox.sendKeys("MSI"+Keys.ENTER);
        extentTest.info("MSI Araması Yapıldı");

        //9. Arama yapıldığı kontrol edilir.
        String aramaSonucYazisi = amazonPage.aramaSonucYazisi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("MSI"));
        extentTest.info("MSI Araması Yapıldığı Kontrol Edildi");

        //10. Arama sonuçları sayfasından 2. sayfa açılır.
        ReusableMethods.javaScriptExcecuter(amazonPage.ikinciSayfa);
        extentTest.info("İkinci Sayfaya Geçildi");

        //11. 2. sayfanın açıldığı kontrol edilir.
        String actualIkinciSayfaUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualIkinciSayfaUrl.contains("page=2"));
        extentTest.info("İkinci Sayfanın Açıldığı Kontrol Edildi");

        //12. Sayfadaki 2. ürün favorilere eklenir.
        amazonPage.secondProduct.click();
        amazonPage.favoriekle.click();
        extentTest= extentReports.createTest("İkinci Sayfadan İkinci Ürün Favorilere Eklendi");

        //13. 2. Ürünün favorilere eklendiği kontrol edilir.
        Assert.assertTrue(amazonPage.wishList.getText().contains("ürün şuraya eklendi:"));
        extentTest= extentReports.createTest("Ürünün Eklendiği Kontrol Edildi");


        //14. Hesabım > Favori Listem sayfasına gidilir.
        amazonPage.listDisplayed.click();
        extentTest= extentReports.createTest("Favori Listem Sayfasına Gidildi");

        //15. “Favori Listem” sayfası açıldığı kontrol edilir.
        String favoriListemUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(favoriListemUrl.contains("wishlist"));
        extentTest= extentReports.createTest("Favori Listem Sayfasının Açıldığı Kontrol Edildi");

        //16. Eklenen ürün favorilerden silinir.
        amazonPage.deleteButon.click();
        extentTest= extentReports.createTest("Ürün Favorilerden Silindi");

        //17. Silme işleminin gerçekleştiği kontrol edilir.
        Assert.assertTrue(amazonPage.silindi.isDisplayed());
        extentTest= extentReports.createTest("Silme İşleminin Gerçekleştiği Kontrol Edildi");

        //18. Üye çıkış işlemi yapılır.
        ReusableMethods.locateUzerindeBekle(amazonPage.txtGirisYapinPencere);
        ReusableMethods.yukleneneKadarBekle(amazonPage.exitbutton);
        extentTest= extentReports.createTest("Üye Çıkış İşlemi Yapıldı");

        //19. Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertTrue(amazonPage.girisButon.isDisplayed());
        extentTest= extentReports.createTest("Çıkış İşleminin Yapıldığı Kontrol Edili");


        Driver.closeDriver();
        extentTest= extentReports.createTest("Browser Kapatıldı");
    }
}
