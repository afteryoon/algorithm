
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    2178 미로탐색
    메모리
    시간
 */
public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map= new int[n][m];
        visited=new boolean[n][m];

        for (int i = 0; i < map.length; i++) {
            String cmd= br.readLine();
            for (int j = 0; j <map[i].length ; j++) {
                map[i][j]= cmd.charAt(j) - '0'; // 문자열을 정수로 변환하여 저장
            }
        }

        System.out.println(bfs(0,0));

    }
    private static int bfs(int startx, int starty){
        int count=1;
        Queue<int[]> q= new LinkedList<>();
        visited[startx][starty]=true;
        q.offer(new int[]{startx,starty});

        while(!q.isEmpty()){
            int size = q.size(); // 큐의 현재 크기를 저장 for에 q.size() 쓰면 틀림..
            for (int i = 0; i <size ; i++) {
                int[] current=q.poll();
                int x=current[0];
                int y=current[1];

                if(x==n-1 && y==m-1) //끝점에 도착 하면 return
                    return count;

                for (int j = 0; j < 4; j++) {
                    int nx=x+dx[j];
                    int ny=y+dy[j];

                    if(nx>=0 && nx<n && ny>=0 && ny<m//배열 범위 안
                            && map[nx][ny]==1 && !visited[nx][ny] ){ //이동가능한 칸이고, 방문 x면
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }
                }

            }

            count++;
        }


        return -1; //도착지에 도착 불가
    }
}
