package j99_Team10.Calisma01;

import java.util.Arrays;

public class Soru03 {
    public static void main(String[] args) {
        /*
        Soru 3) Asagidaki multi dimensional array'in ic array'lerindeki tum elemanlarin toplam'ni  birer birer
              bulan ve herbi' sonucu yeni bir array'in elemani yapan ve yeni array'i  ekrana  yazdiran bir program yaziniz.
              { {1,2,3}, {4,5}, {6,7} }
       Ornek; { {1,2,3}, {4,5}, {6,7} } ==> 1+2+3=6 4+5=9 6+7=13 ==> output:'{6, 9, 13}
         */

        int arr[][]={ {1,2,3}, {4,5}, {6,7} };
        int yeniArr[]=new int[3];
        int toplam= 0;

        for (int k = 0; k < arr.length; k++) {
            for (int d = 0; d < arr[k].length; d++) {
             toplam += arr[k][d];
            }
            yeniArr[k]=toplam;
            toplam=0;
        }

        System.out.println(Arrays.toString(yeniArr)); // [6, 9, 13]

    }
}
