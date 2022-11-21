package Team10Work;

public class MdArrayZorSoru {
    public static void main(String[] args) {

        /*
         Asagidaki multi dimensional array’lerin ic array’lerinde ayni index’e sahip
         elemanlarin toplamini ekrana yazdiran bir program yaziniz.
                arr1 = { {1,2}, {3,4,5}, {6} } ve
                arr2 = { {7,8,9}, {10,11}, {12} }
        */

        int arr1[][]= { {1,2}, {3,4,5}, {6} };
        int arr2[][]= { {7,8,9}, {10,11}, {12} };

         int i,j,k,l;
        for ( i = 0; i <arr1.length; i++) {
            for ( j = 0; j<arr1[i].length; j++){
                for ( k = 0; k<arr2.length;k++) {
                    for ( l = 0; l<arr2[k].length; l++) {
                        if(i==k && j==l){
                            System.out.println("arr1["+i+"]["+j+"] ve arr2["+k+"]["+j+"] nin toplami : "+ (arr1[i][j]+arr2[k][l]));
                        }
                    }
                }
            }
        }
    }
}
