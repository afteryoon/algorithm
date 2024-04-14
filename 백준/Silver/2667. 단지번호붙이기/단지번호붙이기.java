
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int n;
    static int map[][];
    static boolean visited[][];
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static ArrayList<Integer> al=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        map=new int[n][n];
        visited=new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j)-'0';
            }
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1 && !visited[i][j]){
                    count++;
                    al.add(dfs(i,j));
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        sb.append(count+"\n");
        Collections.sort(al);

        for(int elem : al)
            sb.append(elem+"\n");

        System.out.println(sb);

    }
    private static int dfs(int row, int col){
        int count=1;
        visited[row][col]=true;

        for (int i = 0; i <4 ; i++) {
            int nx=row+dx[i];
            int ny=col+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==1 && !visited[nx][ny]){
                count+=dfs(nx,ny);
            }
        }
        return count;
    }
}
