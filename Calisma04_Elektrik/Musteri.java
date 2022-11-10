package j99_Team10.Calisma04_Elektrik;

public class Musteri {

    //fields
    String name;
    ElektrikHesap elk;

    public Musteri(String name, ElektrikHesap elk) {
        this.name = name;
        this.elk = elk;
    }

    @Override
    public String toString() {
        return "name= " + name +
                ", elk= " + elk;
    }
}
