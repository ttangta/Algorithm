import java.util.*;
class Solution {
    private static HashMap<Character, int[]> movement;
    private static void initMovement(){
        movement = new HashMap<>();
        movement.put('U', new int[]{0,1});
        movement.put('D', new int[]{0,-1});
        movement.put('L', new int[]{-1,0});
        movement.put('R', new int[]{1,0});
    }
    private static boolean possibleMove(int nx, int ny){
        if(Math.abs(nx) < 6 && Math.abs(ny) < 6)return true;
        return false;
    }
    public int solution(String dirs) {
        initMovement();
        HashSet<String> moveHistory = new HashSet<>();
        int x=0;
        int y=0;
        for(char c : dirs.toCharArray()){
            int nx = x + movement.get(c)[0];
            int ny = y + movement.get(c)[1];
            
            if(possibleMove(nx, ny)){
                moveHistory.add(x + ", " + y + " -> " + nx + ", " + ny);
                moveHistory.add(nx + ", " + ny + " -> " + x + ", " + y);
                x = nx;
                y = ny;
            }else{
                continue;
            }
        }
        return moveHistory.size()/2;
    }
} 