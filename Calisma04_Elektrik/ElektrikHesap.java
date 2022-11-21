package Team10Work.Calisma04_Elektrik;

public class ElektrikHesap {

    //fields
    int toplamTuketim; // 350
    double oran = 0.7;
    double fatura; // 350*0.7 = 245

    public ElektrikHesap(int toplamTuketim, double fatura) {
        this.toplamTuketim = toplamTuketim;
        this.fatura = fatura;
    }

    public ElektrikHesap() {
    }

    public int tuketimEkle(int tuketim) {
        toplamTuketim += tuketim;

        return toplamTuketim;
    }

    public double odenecekTutar() {
        fatura = toplamTuketim * oran; //350 * 0.7

        return fatura;
    }

    @Override
    public String toString() {
        return  "toplamTuketim= " + toplamTuketim +
                ", fatura= " + fatura;
    }
}
