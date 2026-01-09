
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, start, end;
    static List<List<Edge>> graph;
    static int[] dist;
    static int[] prev;
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        dist = new int[n + 1];
        prev = new int[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        printAnswer();
    }

    static void dijkstra(int s) {
        Arrays.fill(dist, INF);
        Arrays.fill(prev, 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[s] = 0;
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0]; 
            int d = cur[1];
            if (d != dist[u]) continue; 
            if (u == end) break;        

            for (Edge e : graph.get(u)) {
                int v = e.to;
                int nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    prev[v] = u;
                    pq.add(new int[]{v, nd});
                }
            }
        }
    }

    static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');

        Deque<Integer> path = new ArrayDeque<>();
        int cur = end;
        while (cur != 0) {
            path.push(cur);
            if (cur == start) break;
            cur = prev[cur];
        }
        sb.append(path.size()).append('\n');
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(' ');
        }
        System.out.println(sb);
    }
}
