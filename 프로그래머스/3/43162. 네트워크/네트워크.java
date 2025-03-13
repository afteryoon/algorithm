import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>(); 
    static boolean[] isVisit;
    public int solution(int n, int[][] computers) {
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        isVisit = new boolean[n];
        
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }   
        }
        int network = 0;
        
        for(int i=0; i<n; i++) {
            if(!isVisit[i]) {
                dfs(i);
                network++;
            }
        }
        
        return network;
    }
    
    public static void dfs(int node){
        isVisit[node] = true;
        for(int next : graph.get(node)){
            if(!isVisit[next]) {
                dfs(next);
            }
        }
    }
}