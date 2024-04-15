
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int count=0;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int col,row;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while (t-->0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            col=Integer.parseInt(st.nextToken());
            row=Integer.parseInt(st.nextToken());
            int edge=Integer.parseInt(st.nextToken());

            graph=new int[col][row];
            visited= new boolean[col][row];
            for (int i = 0; i <edge ; i++) {
                st = new StringTokenizer(br.readLine());
                graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
            }


            count=0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j <row ; j++) {
                    if(!visited[i][j] && graph[i][j]==1){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static void dfs(int x , int y){
        visited[x][y]=true;

        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx>=0 && nx<col && ny>=0 && ny<row
                            &&!visited[nx][ny] && graph[nx][ny]==1){
                dfs(nx,ny);
            }
        }


    }
}
