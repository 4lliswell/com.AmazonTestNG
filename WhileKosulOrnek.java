package Team10Work;

import java.util.Scanner;

public class WhileKosulOrnek {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int i=1;
        int adet=0;
        int toplam=0;

        while (i!=0){
            System.out.println("sayı giriniz");
            i= sc.nextInt();
            toplam+=i;
            adet++;
        }
        System.out.println("0 (sıfır) girilene kadar girilen tum sayıların adedi : " +adet+
                           "\n0 (sıfır) girilene kadar girilen tum sayıların adedi : "+toplam);
    }
}
