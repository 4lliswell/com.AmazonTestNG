package Team10Work.Contructor;

public class C01 {

    static int sayi= 10; // static v // 11
    int rakam= 5; // instance ver.

    public static void main(String[] args) {

        C01 obj1 =new C01();
        System.out.println("obj1.sayi = " + obj1.sayi); //10
        System.out.println("obj1.rakam = " + obj1.rakam); //5

        sayi++; // 10+1= 11
        obj1.rakam++; // 5+1 = 6

        System.out.println("obj1 bir arttiginda.sayi = " + obj1.sayi); // 11
        System.out.println("obj1 bir arttiginda.rakam = " + obj1.rakam); // 6


        C01 obj2=new C01();
        System.out.println("obj2.sayi = " + obj2.sayi); // 11
        System.out.println("obj2.rakam = " + obj2.rakam); // 5

        sayi++; // 11+1=12
        obj2.rakam++; // 5+1=6

        System.out.println("obj2 bir arttiginda.sayi = " + obj2.sayi); //
        System.out.println("obj2 bir arttiginda.rakam = " + obj2.rakam); //


    }


}
