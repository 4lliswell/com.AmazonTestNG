package Team10Work.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C02_Map {
    public static void main(String[] args) {

        //Verilen mapte istenen proglamlama dilini bilen kisileri list olarak donduren bir method yazin...
        //{101=Ali,Can,java, 102=Veli,Yan,java, 103=Ali,Yan,C#}

        String istenenDil= "JAVA";

        Map<Integer,String> map1=new HashMap<>();
        map1.put(101,"Ali, Can, Java");
        map1.put(102,"Veli, Yan, Java");
        map1.put(103,"Ali, Yan, C#");

        List<String> isimListesi=new ArrayList<>();

        for (String each : map1.values()) {
            String arr[]=each.split(", ");

            if (arr[2].equalsIgnoreCase(istenenDil)){
               isimListesi.add(arr[0]);
            }
        }
        System.out.println("isimListesi = " + isimListesi);

    }
}
