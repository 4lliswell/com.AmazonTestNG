package Team10Work.Calisma01;

public class Soru04 {
    public static void main(String[] args) {

        /*
        Soru 4) Asagidaki multi dimensional array'in ic array'lerindeki son elemanlarin carpimini
            ekrana yazdiran bir program yaziniz
            { {1,2,3}, {4,5}, {6} }
         */

        int arr[][]={ {1,2,3}, {4,5}, {6}  };

        int carpim=1;

        // carpim=arr[0][2]*arr[1][1]*arr[2][0];

        for (int k = 0; k < arr.length; k++) {

            carpim *= arr[k][arr[k].length-1];
        }

        System.out.println(carpim);


    }
}
