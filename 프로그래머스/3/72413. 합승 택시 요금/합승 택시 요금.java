import java.util.*;
class Solution {
    static class Move implements Comparable<Move> {
        int to;
        int cost;
        
        public Move(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Move other) {
            return this.cost - other.cost;
        }
    }
    static List<List<Move>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            
            graph.get(from).add(new Move(to, cost));
            graph.get(to).add(new Move(from, cost));
        }
        
        int[] fromStart = dijkstra(n, s);
        int[] fromA = dijkstra(n, a);
        int[] fromB = dijkstra(n, b);
        
        int minCost = Integer.MAX_VALUE;
        for(int k = 1; k <= n; k++) {
            if(fromStart[k] != Integer.MAX_VALUE && fromA[k] != Integer.MAX_VALUE && fromB[k] != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, fromStart[k] + fromA[k] + fromB[k]);
            }
        }
        
        return minCost;
    }
    
    private int[] dijkstra(int n, int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.add(new Move(start,0));
        
        while(!pq.isEmpty()){
            Move cur = pq.poll();
            int curNode = cur.to;
            int curCost = cur.cost;
            
            if(curCost > dist[curNode] ) continue;
            
            for(Move next : graph.get(curNode)) {
                int nextCost = curCost+next.cost;
                
                if(nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.add(new Move(next.to,nextCost));
                }
            }
            
        }
        
        return dist;
    }
}