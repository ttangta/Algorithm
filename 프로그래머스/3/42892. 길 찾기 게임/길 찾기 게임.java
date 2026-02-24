import java.util.*;
class Solution {
    private static class Node{
        int num;
        int x;
        int y;
        Node left;
        Node right;
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    private static Node[] nodes;
    
    private static Node buildBT(){
        Node root = nodes[0];
        for(int i=1; i<nodes.length; i++){
            Node p = root;
            while(true){
                if(p.x > nodes[i].x){
                    if(p.left == null){
                        p.left = nodes[i];
                        break;
                    }
                    else p = p.left;
                }
                else{
                    if(p.right == null){
                        p.right = nodes[i];
                        break;
                    }
                    else p = p.right;
                }
            }
        }
        return nodes[0];
    }
    
    private static void preOrder(Node curr, ArrayList<Integer> answer){
        if(curr == null)return;
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }
    
    private static void postOrder(Node curr, ArrayList<Integer> answer){
        if(curr == null)return;
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
           if(o1.y == o2.y)return Integer.compare(o1.x, o2.x);
           return Integer.compare(o2.y, o1.y); 
        });
        
        Node root = buildBT();
        
        ArrayList<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        
        ArrayList<Integer> post = new ArrayList<>();
        postOrder(root, post);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}