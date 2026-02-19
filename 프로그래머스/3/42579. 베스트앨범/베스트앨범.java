import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            total.put(genre, total.getOrDefault(genre, 0)+play);
        }

        HashMap<String, ArrayList<int[]>> detail = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            if(!detail.containsKey(genre))detail.put(genre, new ArrayList<>());
            detail.get(genre).add(new int[]{i, play});
        }

        /*
        Stream<Map.Entry<String,Integer>> sg = total.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        sg.forEach(s -> System.out.println(s.getKey() + " : " + s.getValue()));
        */

        Stream<String> sortedGenre = total.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())).map(Map.Entry::getKey);

        ArrayList<Integer> answer = new ArrayList<>();
        sortedGenre.forEach(s -> {
            Stream<int[]> sortedSong = detail.get(s).stream().sorted((o1, o2) -> Integer.compare(o2[1], o1[1])).limit(2);
            sortedSong.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}