class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, idx = 0, location = 1;
        while(location <= n){
            if(idx < stations.length && location >= stations[idx] - w){
                location = stations[idx++] + w + 1;
            }
            else{
                answer++;
                location += 2 * w + 1;
            }
        }
        return answer;
    }
}