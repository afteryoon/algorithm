
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i <n ; i++) {
            String cmd= br.readLine();
            if(cmd.equals("0")){
                int answer=pq.isEmpty()?-1:pq.poll();
                sb.append(answer+"\n");
            }else {
                StringTokenizer st= new StringTokenizer(cmd);
                int m=Integer.parseInt(st.nextToken());
                for (int j = 0; j <m ; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
