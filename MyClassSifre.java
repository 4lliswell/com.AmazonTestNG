package j99_Team10;

import java.util.Scanner;

public class MyClassSifre {

    public static void main(String[] args) {
        /*
        Kullanicidan bir sifre girmesini isteyin. Girilen sifreyi asagidaki sartlara gore kontrol
        edin ve sifredeki hatalari yazdirin.
        Kullanici gecerli bir sifre girinceye kadar bu islemi tekrar edin ve gecerli sifre
        girdiginde “Sifreniz Kabul edilmistir” yazdirin.
                   - Sifre kucuk harf icermelidir
                   - Sifre buyuk harf icermelidir
                   - Sifre ozel karakter icermelidir
                   - Sifre en az 8 karakter olmalidir.
         */

        Scanner sc=new Scanner(System.in);

        int sayac=0;

       do {
           System.out.print("Pin kodunuzu Girin: ");
           String  sifre= sc.nextLine();
           sayac=0;

           if (sifre.length()>=8){ // Sifre en az 8 karakter olmalidir. sarti kontrol edildi
               sayac++;

               String yeniSifre = sifre.replaceAll("\\d", "");
               System.out.println(yeniSifre);

               for (int i = 0; i < yeniSifre.length(); i++) {

                   if ((yeniSifre.charAt(i)>='A' && yeniSifre.charAt(i)<='Z')){
                       sayac++;
                   }else{
                       System.out.println("Sifre buyuk harf icermelidir");
                   }

                   if ((yeniSifre.charAt(i)>='a' && yeniSifre.charAt(i)<='z')){
                       sayac++;
                   }else{
                       System.out.println("Sifre kucuk harf icermelidir");
                   }



               }

           }else{ // pin kodu enaz 8 karakter degilse uyari verme kismi
               System.out.println("Sifre en az 8 karakter olmalidir.");

           }

            //sayac++;

       }while (sayac!=3);

        if (sayac==3){
            System.out.println("Sifreniz Kabul edilmistir");
        }
        System.out.println(sayac);






    }

}
