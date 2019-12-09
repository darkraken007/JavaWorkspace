package threadex;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String args[]) {
        List<Integer> arr =  new ArrayList<Integer>();
        System.out.println(arr.size());
        arr.add(0,1);
        arr.add(1,2);
        System.out.println(arr.size());
    }
}
