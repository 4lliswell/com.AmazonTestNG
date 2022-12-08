package Team10Work.Contructor;

public class Notlar {


    //Constructor: javada obje olusturmak icin kullanilan code blogudur.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        blogudur.
    //             Javada bir obje olusturabilmek icin mutlaka contructor kullanmalisiniz.

    /*
    1- constructor ismi Class name ile ayni olmali. Buyuk harf ile baslamali
    2- constructor create edildiginde name`den sonra () {} mutlaka kullanilmalidir
    3- eger parametreli constructor create edilirse java default constructor'u ezer(siler)
    4- constructor"ın return type olmaz metoddan ayiran ozelligidir
    5- class olustugunda java default constructor'ı kendi create eder.
     */


    //    ****** DEFAULT CONSTRUCTOR *****
     /*
    Java ihtiyac halinde kullanilmasi icin her class`da DEFAULT bir contructor koymustur.
    Default constructor class`dan obje olsturuldugunda otomatik olarak calisir.
    Default constructor, parametresizdir goremesek bile ihtiyac oldugunda calisir.

    Class icerisinde parametreli veya parametresiz herhangi bir constructor olusturursak
    java default constructor`i siler

    Bizim olusturdugumuz parametresiz contructor Default constructor ile 1-1 aynidir.
    ama biz olusturdugumuz icin buna default constructor dememyiz parametresiz constructor deriz.
     */


    // VARIABLE`I YAZDIRMA
     /*
    Herhangi bir obje uzerinden bir variable`i yazdirmaya calistigimizda
    Java degeri su siralama ile arar:
    1- O obje olusturulduktan sonra bir deger atandi mi?
    2- Variable`in olusturuldugu anda (satirda) variable`a bir deger atanmis mi?
    3- O zaman data turune gore Java default deger atar.
     */



    // "this()" -> Constructor icinden baska bir constructoru cagirmak icin this(); kullanilir.
    /*
    1) Constructor icinden baska bir Constructor cagirmak icin "this()" kullanirsaniz
       mutlaka ilk satira yazmalisiniz.
       Aksi takdirde Compile Time Error alirsiniz.
    2) Bir Constructor icinden sadece bir tane Constructor cagirisi yapabilirsiniz.
       Cunku iki tane cagri yaprsaz birisi ilk satirda olamayacaktir, bu da ilk kuralla celisir.

       Bir Classta birden cok Constructor call edilebilir
    */


    //         ***** STATIC VARIABLE *****
     /*
        => Class'in icinde methodlarin disinda olusturulan variable'lara "instance variable" denir.
	 	=> Class'in icinde methodlarin disinda olusturulan static variable'lara "Class variable" denir.
	 	=> Instance variable'lar gibi Class variable(Static variable)'lar initial edilmezse(ilk değere ataması) default value ataması yapılır
	 	=> Static variable'lar call etmek  icin object olusturmaya gerek yoktur.
	 	=> Bulunduğu  class icinden static yapılara  ulasilabilir.Farklı class'lardan ClassName.staticYapı class name ile call edilir.
	       farklı class'da obj name ile değl class name ile call edilir.
	 	=> Instance variable(Object Variable)'lar call etmek icin object create edilmesi zorunludur. Object olusturmadan
	       instance variable'a ulasilamaz.
	 	=> Static variable'lara object ile call edilebilir ama tavsiye edilmez.
	 	=> Eger static variable'lara object ile call edilirse Java  sari alt cizgi ikaz eder->.BAD PRACTICE
        => static keyword hafıza opt. için kullanılır ve memory'de 1 kez oluşturulur

        bir obj static variable değeri değişirse tün obj variable değeri değişir
        static obj den bağımsızdır class'a bağımlı Class'ın malıdır.

        Trick-> bir variable, methoda doğrudan calss name ile obj olmadan call etmek için static olmalıdır..
        */

    //     ***** STATIC BLOCK ****

         /*
       1. static block yapilari static variable`lari deger atamasi(update) icin kullanilir
       2. static blocklar Class olusturuldugunda butun methodlardan (main dahil) ONCE calisir.
       3. birden cok statik block varsa yukaridan asagiya sira ile calisir.
        */

}
