package Team10Work.Maps;

import java.util.Arrays;
import java.util.HashMap;

public class C01_Map {
    public static void main(String[] args) {

        // Stringdeki harflerin Stringde kac defa gectigini bulan code create ediniz (map kullanalim)

        String str= "Hellooo";

        HashMap<String,Integer> map=new HashMap<>();
        String [] arr = str.split("");
        System.out.println(Arrays.toString(arr));

        for (String w:arr) {
            if (!map.containsKey(w)){
                map.put(w,1);
            }else {
                map.put(w,map.get(w)+1);
            }
        }
        System.out.println("map = " + map);
    }
}
