package j99_Team10;

import java.util.Scanner;

public class SifreSorusu_MerveHoca {
    public static void main(String[] args) {

        /*
        Kullanicidan bir sifre girmesini isteyin. Girilen sifreyi asagidaki sartlara gore kontrol
        edin ve sifredeki hatalari yazdirin.
        Kullanici gecerli bir sifre girinceye kadar bu islemi tekrar edin ve gecerli sifre
        girdiginde "Sifreniz Kabul edilmistir" yazdirin.
           - Sifre kucuk harf icermelidir
           - Sifre buyuk harf icermelidir
           - Sifre ozel karakter icermelidir
           - Sifre en az 8 karakter olmalidir.
 */

        // while loop task 12 ye bakılabilir
        Scanner scanner = new Scanner(System.in);
        int sayac = 0;
        int sayac1 = 0;
        int sayac2 = 0;
        boolean flag = false;
        while (!flag) {
            System.out.print("Lutfen Sifre giriniz : ");
            String str = scanner.nextLine();
            if (str.length() >= 8) {
                String yeniStr = str.replaceAll("\\d", "");
                System.out.println(yeniStr);
                for (int i = 0; i < yeniStr.length(); i++) {
                    if (yeniStr.charAt(i) >= 'a' && yeniStr.charAt(i) <= 'z') {
                        sayac++;
                        System.out.println(yeniStr.charAt(i));
                        System.out.println("sayac : "+sayac);
                    } else if (yeniStr.charAt(i) >= 'A' && yeniStr.charAt(i) <= 'Z') {
                        sayac1++;
                        System.out.println(yeniStr.charAt(i));
                        System.out.println("sayac1 : "+sayac1);
                    } else {
                        sayac2++;
                        System.out.println(yeniStr.charAt(i));
                        System.out.println("sayac2 : "+sayac2);}
                }
            } else {
                System.out.println(" Hatali Sifre\nSifreniz 8 karakterli degildir ");
            }
            if (sayac > 0 && sayac1 > 0 && sayac2 > 0) {
                System.out.println("Sifreniz Kabul edilmistir");
                flag = true;
            } else {
                if(!(sayac >0)) {
                    System.out.println("Sifreniz kucuk harf içermemektedir. ");
                }
                if(!(sayac1 >0)) {
                    System.out.println("Sifreniz buyuk harf içermemektedir. ");
                }
                if(!(sayac2>0)){
                    System.out.println("Sifreniz özel karakter içermemektedir.");
                }
            }
            System.out.println();
            sayac=0;
            sayac1=0;
            sayac2=0;
        }
    }
}
