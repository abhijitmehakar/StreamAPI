package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfString {
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Banana");
        listOfStrings.add("Mango");
        listOfStrings.add("Rasberi");
        listOfStrings.add("Sitaphal");
        listOfStrings.add("Watermelon");

        Collections.sort(listOfStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        System.out.println("String is sorted by length");

        for(String list:listOfStrings){
            System.out.println(list);
        }
    }
}
