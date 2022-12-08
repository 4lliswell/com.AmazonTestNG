package Team10Work.Contructor;

public class Ogretmen {
    String isim = "Isim belirtilmemis";
    String soyisim= "Soyisim belrtirlmedi";
    String dogumTarihi= "Tarih girilmedi";
    String brans;
    int tecrube;


    public Ogretmen() {
        this("ali","mutlu","tarih");

    }

    public Ogretmen(String isim, String soyisim, String dogumTarihi, String brans, int tecrube) {

        this("ali","mutlu","tarih");


        this.isim = isim;
        this.soyisim = soyisim;
        this.dogumTarihi = dogumTarihi;
        this.brans = brans;
        this.tecrube = tecrube;
    }

    public Ogretmen(String isim, String soyisim, String brans) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.brans = brans;
    }

    public String yanBrans (String yanBras){

       return "ogretmenin yan bransi: "+yanBras;
    }

   @Override
    public String toString() {
        return
                "\nisim='" + isim +
                "\nsoyisim='" + soyisim +
                "\ndogumTarihi='" + dogumTarihi +
                "\nbrans='" + brans +
                "\ntecrube=" + tecrube;
    }
}
