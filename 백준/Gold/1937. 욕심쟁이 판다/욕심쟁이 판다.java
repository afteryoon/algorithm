

import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dp; // 메모이제이션을 위한 배열
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n][n]; // 각 위치에서 시작했을 때 최대 이동 거리
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxDays = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                maxDays = Math.max(maxDays, dfs(i, j));
            }
        }
        
        System.out.print(maxDays);
    }
    
    public static int dfs(int x, int y) {
        // 이미 계산된 값이 있으면 반환
        if(dp[x][y] != 0) {
            return dp[x][y];
        }
        
        // 기본값은 1일(자기 자신)
        dp[x][y] = 1;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            
            // 대나무가 더 많은 곳으로만 이동 가능
            if(graph[nx][ny] > graph[x][y]) {
                // 현재 위치에서의 최대 이동일 = max(현재 최대일, 다음 위치의 최대일 + 1)
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        
        return dp[x][y];
    }
}