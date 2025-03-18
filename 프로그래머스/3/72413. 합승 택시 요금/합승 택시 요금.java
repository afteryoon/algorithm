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
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Move>> graph = new ArrayList<>();
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
        
        int[] fromStart = dijkstra(n, s, graph);
        int[] fromA = dijkstra(n, a, graph);
        int[] fromB = dijkstra(n, b, graph);
        
        int minCost = Integer.MAX_VALUE;
        for(int k = 1; k <= n; k++) {
            if(fromStart[k] != Integer.MAX_VALUE && fromA[k] != Integer.MAX_VALUE && fromB[k] != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, fromStart[k] + fromA[k] + fromB[k]);
            }
        }
        
        return minCost;
    }
    
    private int[] dijkstra(int n, int start, List<List<Move>> graph) {
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        
        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.offer(new Move(start, 0));
        
        while(!pq.isEmpty()) {
            Move current = pq.poll();
            int currentNode = current.to;
            int currentCost = current.cost;
            
            if(currentCost > distances[currentNode]) continue;
            
            for(Move next : graph.get(currentNode)) {
                int nextCost = currentCost + next.cost;
                
                if(nextCost < distances[next.to]) {
                    distances[next.to] = nextCost;
                    pq.offer(new Move(next.to, nextCost));
                }
            }
        }
        
        return distances;
    }
}