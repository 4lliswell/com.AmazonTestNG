package Team10Work.Calisma01;

public class Soru01 {
    public static void main(String[] args) {
        /*
        Soru 1) iki String array olusturunuz ve bu array'lerdeki ortak elemanlari For-each loop kullanarak bulunuz.
                Sonucu ekrana yazdiriniz. Ortak eleman yoksa ekrana "Ortak eleman yok" yazdiriniz.
         */

        String arr[]={"Enise","Hakan","Yunus","Merve"};
        String arr1[]={"Ali","Musa","Sena","Merve"};

        // 1.YOL:
        int count = 0;
        for (String ortak : arr) {
            for (String ortak2 : arr1) {
                if (ortak2.equals(ortak)) {
                    count++;
                    System.out.println(ortak);
                }
            }
        }
        if (count == 0) {
            System.out.println("ortak eleman yok");
        }


        //2.YOL:
        count=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr[i].equals(arr1[j])){
                    System.out.println(arr[i]);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("ortak eleman yok");
        }


    }
}
