package Team10Work.Calisma02_MaasHesabi;

import java.time.LocalDate;

public class CalisanEmployee {

    // fields
    String name;
    double salary;
    int workHours;
    int year;

    public CalisanEmployee(String name, double salary, int workHours, int year) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.year = year;
    }

    public double tax(){
        double hesaplananTax=0;

        if (salary<10000){
            hesaplananTax=0;
        }else {
            hesaplananTax=salary*0.03;
        }

        return hesaplananTax;
    }

    public int bonus(){
        int hesaplananBonus=0;

        if (workHours>40){
            hesaplananBonus=(workHours-40)*50;
        }

        return hesaplananBonus;
    }

    public double maasArtis(){

        double hesaplananMaasArtisi=0;

        LocalDate bugun =LocalDate.now();

        if (bugun.getYear()-year<5){
            hesaplananMaasArtisi=(salary+tax())*0.05;

        } else if (bugun.getYear()-year<15) {
            hesaplananMaasArtisi=(salary+tax())*0.1;

        }else {
            hesaplananMaasArtisi=(salary+tax())*0.2;
        }

        return hesaplananMaasArtisi;
    }



    @Override
    public String toString() {
        return  "\nname= " + name +
                "\nsalary= " + salary +
                "\nworkHours= " + workHours +
                "\nyear= " + year +
                "\nToplamMaas= "+ (salary+bonus()+maasArtis())+
                "\nBonus= "+(bonus()) +
                "\nMaasArtisi= "+ maasArtis()+
                "\nuygulananVergi= "+ tax();
    }


}
