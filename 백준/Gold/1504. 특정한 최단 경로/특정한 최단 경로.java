
import java.io.*;
import java.util.*;

public class Main {
    static int N, E, v1, v2;
    static List<Node>[] graph;
    static final int INF = 200_000_000; // 최대 거리를 고려한 INF 값 설정

    static class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int res1 = getPath(1, v1, v2, N);
        int res2 = getPath(1, v2, v1, N);
        int result = Math.min(res1, res2);

        System.out.println(result >= INF ? -1 : result);
    }

    static int getPath(int start, int mid1, int mid2, int end) {
        int path1 = dijkstra(start, mid1);
        int path2 = dijkstra(mid1, mid2);
        int path3 = dijkstra(mid2, end);

        if (path1 == INF || path2 == INF || path3 == INF) {
            return INF;
        }
        return path1 + path2 + path3;
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.to == end) return cur.cost;
            if (dist[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        return dist[end];
    }
}