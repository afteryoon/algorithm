
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //백준 1916
    static int n,m;
    static int[] dist;
    static List<List<Bus>> graph = new ArrayList<>();

    static class Bus implements Comparable<Bus> {
        int end , price;

        Bus( int end, int price) {
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Bus o) {
            return this.price - o.price;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
           graph.add(new ArrayList<>());
        }
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st ;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Bus(end, price));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus current = pq.poll();
            int cur = current.end;

            if(dist[cur] < current.price) continue;

            for (Bus next : graph.get(cur)) {
                if(dist[next.end] > dist[cur] + next.price) {
                    dist[next.end] = dist[cur] + next.price;
                    pq.offer(new Bus(next.end, dist[next.end]));
                }
            }

        }
    }
}
