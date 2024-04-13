
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static  ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> q= new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int vertex=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int root=Integer.parseInt(st.nextToken());

        graph= new ArrayList[vertex+1];
        for (int i = 1; i <= vertex; i++)
            graph[i]=new ArrayList<>();

        visited= new boolean[vertex+1];
        for (int i = 1; i <=edge; i++) {
            st= new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(root);
        visited= new boolean[vertex+1];
        sb.append("\n");
        bfs(root);

        System.out.println(sb);
    }
    static private void dfs(int vertex){
        visited[vertex]=true;
        sb.append(vertex+" ");
        Collections.sort(graph[vertex]);

        for (int i = 0; i <graph[vertex].size() ; i++) {
            int nextVertex=graph[vertex].get(i);
            if(!visited[nextVertex])
                dfs(nextVertex);
        }
    }
    static private void bfs(int vertex){
        visited[vertex]=true;
        sb.append(vertex+" ");
        q.offer(vertex);

        while (!q.isEmpty()){
            int current=q.poll();
            Collections.sort(graph[current]);
            for (int i = 0; i <graph[current].size() ; i++) {
                int nextVertex= graph[current].get(i);
                if(!visited[nextVertex]){
                    visited[nextVertex]=true;
                    q.offer(nextVertex);
                    sb.append(nextVertex+" ");
                }
            }
        }


    }
}
