
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //백준
    static int n,m;
    static int[][] graph;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int maxSafe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(maxSafe);
    }

    static void dfs(int wall) {
        if(wall == 3){
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 0){
                    graph[i][j] = 1;
                    dfs(wall+1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[][] wallGraph = new int[n][m];

        for (int i = 0; i < n; i++) {
            wallGraph[i] = graph[i].clone();
            for(int j = 0; j < m; j++){
                if(wallGraph[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m){
                    if(wallGraph[ny][nx] == 0){
                        wallGraph[ny][nx] = 2;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(wallGraph[i][j] == 0){
                    safeArea++;
                }
            }
        }
        maxSafe = Math.max(safeArea, maxSafe);
    }
}
