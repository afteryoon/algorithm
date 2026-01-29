

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static int n, limit, edges;
    static List<List<Edge>> graph;
    static int[] items;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) items[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, l));
            graph.get(b).add(new Edge(a, l));
        }

        int ans = 0;
        for (int s = 1; s <= n; s++) {
            ans = Math.max(ans, collectItemsWithinLimit(s));
        }
        System.out.println(ans);
    }

    static int collectItemsWithinLimit(int s) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{s, 0}); // {node, dist}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (d != dist[u]) continue;
            for (Edge e : graph.get(u)) {
                int v = e.to;
                int nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new int[]{v, nd});
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) if (dist[i] <= limit) sum += items[i];
        return sum;
    }
}
