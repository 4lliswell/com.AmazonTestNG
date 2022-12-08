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
    Default constructor class`dan obje olsturuldugunda otomatik olarak calisir
    Default constructor, parametresizdir goremesek bile ihtiyac oldugunda calisir.

    Class icerisinde parametreli veya parametresiz herhangi bir constructor olusturursak java default constructor`i siler

    Bizim olusturdugumuz parametresiz contructor Default constructor ile 1-1 aynidir.
    ama biz olusturdugumuz icin buna default constructor dememyiz parametresiz constructor deriz.
     */


    // VARIABLE`I YAZDIRMA
     /*
    Herhangi bir obje uzerinden bir variable`i yazdirmaya calistigimizda
    Java degeri su siralama ile arar:
    1- O obje olusturulduktan sonra bir deger atandi mi?
    2- Objenin olusturuldugu classda variable`a bir deger atanmis mi?
    3- O zaman data turune gore Java default deger atar.
     */



    // "this()" -> Constructor icinden baska bir constructoru cagirmak icin this(); kullanilir.
    /*
    1) Constructor icinden baska bir Constructor cagirmak icin "this()" kullanirsaniz mutlaka ilk satira yazmalisiniz.
       Aksi takdirde Compile Time Error alirsiniz.
    2) Bir Constructor icinden sadece bir tane Constructor cagirisi yapabilirsiniz.Cunku iki tane cagri yaprsaz
       birisi ilk satirda olamayacaktir, bu da ilk kuralla celisir.

       Bir Classta birden cok Constructor call edilebilir
    */



    //     ***** STATIC BLOCK ****
    /*
        Static block class uyelerinin tamamindan once calisir. (main method`dan bile once)

        static blocklarin class icerisinde nerede oldugu onemli degildir once static blocklar calisir.

        birden fazla static blocklar varsa, yukaridan asagi dogru calisir.
         */



}
