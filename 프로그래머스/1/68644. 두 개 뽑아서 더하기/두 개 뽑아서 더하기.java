import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                list.add(numbers[i] + numbers[j]);
            }
        }
        list = list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        list.sort(Comparator.naturalOrder());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}