

import java.util.*;
import java.io.*;

public class  Main {
    static int[] choices;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int test=0; test<cases; test++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            // 선택 배열 초기화
            choices = new int[n+1];
            for(int i=1; i<=n; i++) {
                choices[i] = Integer.parseInt(st.nextToken());
            }
            
            // 방문 배열 초기화
            visited = new boolean[n+1];
            finished = new boolean[n+1]; // 사이클 검사가 완료된 노드
            count = 0;
            
            // 각 학생에 대해 DFS 수행
            for(int i=1; i<=n; i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
            
            // 팀에 속하지 않은 학생 수 = 전체 학생 수 - 팀에 속한 학생 수
            sb.append(n - count).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        
        int next = choices[node];
        
        if(!visited[next]) {
            // 다음 노드를 아직 방문하지 않았으면 계속 진행
            dfs(next);
        } else if(!finished[next]) {
            // 다음 노드를 방문했지만 아직 완료되지 않았다면 사이클 발견
            // 사이클에 포함된 노드 수 세기
            count++;
            for(int i = next; i != node; i = choices[i]) {
                count++;
            }
        }
        
        // 현재 노드에 대한 탐색 완료
        finished[node] = true;
    }
}