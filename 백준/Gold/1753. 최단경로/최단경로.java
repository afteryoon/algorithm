
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int distance;

        Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }
        static int v, e;
        static List<List<Node>> graph = new ArrayList<>();
        static int[] dist;


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            dist = new int[v+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }
            int start = Integer.parseInt(br.readLine());

            for (int i = 0; i < e; i++) {
               st = new StringTokenizer(br.readLine());
               graph.get(Integer.parseInt(st.nextToken()))
                       .add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            dijkstra(start);
            for (int i = 1; i < dist.length; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println("INF");
                }else
                    System.out.println(dist[i]);
            }
        }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;  // 시작 노드의 거리를 0으로 초기화

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curTo = current.to;
            int curDist = current.distance;

            if (dist[curTo] < curDist) continue;

            for (Node nextNode : graph.get(curTo)) {
                int newDist = dist[curTo] + nextNode.distance;  // 현재 노드를 거쳐 다음 노드로 가는 거리
                if (newDist < dist[nextNode.to]) {
                    dist[nextNode.to] = newDist;
                    pq.add(new Node(nextNode.to, newDist));
                }
            }
        }
    }


}
