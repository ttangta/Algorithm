package array;

import java.util.Arrays;

public class CustomProblem01 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(s1(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(s1(new int[]{2,1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(s1(new int[]{6,1, 7})));
    }

    public static int[] s1(int[] arr){
        return Arrays.stream(arr).sorted().toArray();
    }
}
