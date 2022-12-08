package Team10Work.Contructor;

public class Runner {

    public static void main(String[] args) {

        Ogretmen ogretmen = new Ogretmen();
        ogretmen.isim= "Hakan";
        ogretmen.soyisim="Yildiz";
        ogretmen.dogumTarihi= "01/11/1985";
        ogretmen.brans= "Fizik";
        ogretmen.tecrube=10;

        System.out.println(ogretmen);

        Ogretmen ogretmen1 =new Ogretmen("Sumeyra","Dogan","Kimya");
        //System.out.println(ogretmen1.isim);
        System.out.println(ogretmen1);
        //System.out.println(ogretmen1.yanBrans("Fizik"));


    }

}
