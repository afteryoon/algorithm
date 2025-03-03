import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static int[] isVisit;
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        isVisit = new int [n+1];
        Arrays.fill(isVisit,-1);
        for(int[] e : edge) {
            graph.get(e[1]).add(e[0]);
            graph.get(e[0]).add(e[1]);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1,0});
        isVisit[1] = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int from = cur[0];
            int dist = cur[1];
           
            for(int next : graph.get(from)) {
                if(isVisit[next] == -1) {
                    isVisit[next] = dist+1;
                    q.offer(new int[] {next,dist+1});
                }
            }
        }
        int max = Arrays.stream(isVisit).max().orElse(0);
        int answer = 0;
        
        for(int i : isVisit) {
            if(i == max) answer++;
        }
        
        return answer;
    }
}