package queue;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
//        for(int i = 0 ; i <10;i++){
//            System.out.println(i + "= " + (i%3));
//        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

    }
}
