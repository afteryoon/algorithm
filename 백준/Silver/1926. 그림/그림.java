

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static  int n,m;
    static  int[][] map;
    static boolean visited[][];
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new  int[n][m];
        visited= new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        int maxWeight=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==1 && !visited[i][j]){
                    count++;
                    maxWeight=Math.max(maxWeight,dfs(i,j));
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        sb.append(count+"\n"+maxWeight);
        System.out.println(sb);

    }
    private static int dfs(int x,int y){
        int count=1;
        visited[x][y]=true;

        for (int i = 0; i <4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==1 &&!visited[nx][ny]){
                count+=dfs(nx,ny);
            }
        }

        return count;
    }
}
