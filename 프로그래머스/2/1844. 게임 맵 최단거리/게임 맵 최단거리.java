import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{0, 0, 1}); // y, x, distance
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int distance = current[2];
            
            if (y == n - 1 && x == m - 1) {
                return distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && maps[ny][nx] == 1) {
                    queue.offer(new int[]{ny, nx, distance + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return -1; 
    }
}