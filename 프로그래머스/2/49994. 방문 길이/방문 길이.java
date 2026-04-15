import java.util.*;
class Solution {
    private static boolean isValid(int x, int y){
        return 0 <= x && x < 11 && 0 <= y && y < 11;
    }
    private static HashMap<Character, int[]> movement;
    private static void initMovement(){
        movement = new HashMap<>();
        movement.put(Character.toUpperCase('u'), new int[]{-1, 0});
        movement.put(Character.toUpperCase('d'), new int[]{1, 0});
        movement.put(Character.toUpperCase('l'), new int[]{0, -1});
        movement.put(Character.toUpperCase('r'), new int[]{0, 1});
    }
    
    public int solution(String dirs) {
        int x = 5, y = 5;
        initMovement();
        HashSet<String> set = new HashSet<>();
        for(char c : dirs.toCharArray()){
            int[] mv = movement.get(c);
            int nx = x + mv[0];
            int ny = y + mv[1];
            if(!isValid(nx, ny))continue;
            set.add(x + " " + y + " " + nx + " " + ny);
            set.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }
        return set.size()/2;
    }
}