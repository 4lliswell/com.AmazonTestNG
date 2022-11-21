package Team10Work.Calisma04_Elektrik;

public class Runner {
    public static void main(String[] args) {

        ElektrikHesap obj1 = new ElektrikHesap();

        //obj1.tuketimEkle(150);

        //obj1.tuketimEkle(200);

        //System.out.println("obj1.odenecekTutar() = " + obj1.odenecekTutar());

        Musteri musteri = new Musteri("Hakan",obj1);

        musteri.elk.tuketimEkle(200);
        musteri.elk.tuketimEkle(150);
        //System.out.println("Odenecek Tutar= " + musteri.elk.odenecekTutar());
        System.out.println("musteri = " + musteri);

        ElektrikHesap fatura = new ElektrikHesap();

        //Musteri musteri2 = new Musteri("Enise", fatura);

    }
}
