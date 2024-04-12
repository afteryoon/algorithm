
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
            if(Math.abs(a)==Math.abs(b))
                return a-b;
            return Math.abs(a)-Math.abs(b);
        });
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i <n ; i++) {
            int cmd=Integer.parseInt(br.readLine());
            if(cmd==0){
                int print=pq.isEmpty()?0:pq.poll();
                sb.append(print+"\n");
            }else{
                pq.offer(cmd);
            }
        }

        System.out.println(sb);
    }
}
