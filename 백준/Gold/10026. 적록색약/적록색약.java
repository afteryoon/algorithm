import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] graph;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int normalCount = countRegions(false);
        int colorBlindCount = countRegions(true);

        System.out.println(normalCount + " " + colorBlindCount);
    }

    private static int countRegions(boolean isColorBlind) {
        visited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph[i][j], isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char color, boolean isColorBlind) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]) {
                if (isSameColor(color, graph[ny][nx], isColorBlind)) {
                    dfs(ny, nx, graph[ny][nx], isColorBlind);
                }
            }
        }
    }

    private static boolean isSameColor(char c1, char c2, boolean isColorBlind) {
        if (isColorBlind) {
            if (c1 == 'B') return c2 == 'B';
            return c2 != 'B';
        }
        return c1 == c2;
    }
}