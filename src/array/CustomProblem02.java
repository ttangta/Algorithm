package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomProblem02 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(s2(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(s2(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }
    public static int[] s2(int[] arr){
        Integer[] integers = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(integers,Collections.reverseOrder());
        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    }
}
