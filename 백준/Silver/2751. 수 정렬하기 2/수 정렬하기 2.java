import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        StringBuilder sb= new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()+"\n");
        }
        System.out.println(sb);
    }
}
