package amazon.tests;

import amazon.pages.HomePage;
import amazon.pages.SearchResultsPage;
import amazon.pages.WishListPage;
import amazon.utilities.TestBaseReport;

import org.testng.Assert;
import org.testng.annotations.Test;
import amazon.utilities.ConfigReader;
import amazon.utilities.Driver;
import amazon.utilities.ReusableMethods;


public class AmazonTest extends TestBaseReport {

    @Test
    public void amazonTest() {
        HomePage hp = new HomePage();
        SearchResultsPage sp = new SearchResultsPage();
        WishListPage wp = new WishListPage();

        extentTest = extentReports.createTest("AmazonTest",
                "Kullanici Amazon Sitesine Login Olup Sepete Urun Ekleyip, Cikarabilmeli ve Cikis Yapabilmeli");

        hp.goToUrl("amazonUrl");
        extentTest.info("Amazon Sitesi Açıldı");

        hp.verifyUrl(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Ana Sayfanın Açıldığı Kontrol Edildi");

        hp.cookiesAccept();
        extentTest.info("Çerez Tercihlerinden Çerezler Kabul Edildi");

        hp.loginProfile("amazonEmail","amazonPassword");
        extentTest.info("Siteye Kullanıcı Bilgileriyle Login Olundu");

        hp.verifyLogin();
        extentTest.info("Login İşlemi Kontrol Edildi");

        hp.selectCategory("Bilgisayarlar");
        extentTest.info("Bilgisayarlar Kategorisi Seçildi");

        hp.verifyCategory("Bilgisayarlar");
        extentTest.info("Bilgisayar Kategorisi Seçildiği Kontrol Edildi");

        hp.searchProduct("MSI");
        extentTest.info("MSI Araması Yapıldı");

        sp.verifySearchedProduct("MSI");
        extentTest.info("MSI Araması Yapıldığı Kontrol Edildi");

        sp.clickPage("2");
        extentTest.info("İkinci Sayfaya Geçildi");

        sp.verifyPage("page=2");
        extentTest.info("İkinci Sayfanın Açıldığı Kontrol Edildi");

        sp.clickProduct("2");
        extentTest.info("İkinci Sayfadan İkinci Ürün Favorilere Eklendi");

        sp.verifyWishList();
        extentTest.info("Ürünün Eklendiği Kontrol Edildi");

        sp.goToWishList();
        extentTest.info("Favori Listem Sayfasına Gidildi");

        wp.verifyWishList();
        extentTest.info("Favori Listem Sayfasının Açıldığı Kontrol Edildi");

        wp.deleteProduct();
        extentTest.info("Ürün Favorilerden Silindi");

        wp.verifyDeleteProduct();
        extentTest.info("Silme İşleminin Gerçekleştiği Kontrol Edildi");

        wp.logoutProfile();
        extentTest.info("Üye Çıkış İşlemi Yapıldı");

        wp.verifyLogout();
        extentTest.info("Çıkış İşleminin Yapıldığı Kontrol Edili");

        Driver.closeDriver();
        extentTest.pass("Browser Kapatıldı");
    }
}
