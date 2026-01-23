

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                } else { // "D"
                    if (map.isEmpty()) continue;

                    if (x == 1) {
                        // delete max
                        int key = map.lastKey();
                        int cnt = map.get(key);
                        if (cnt == 1) map.remove(key);
                        else map.put(key, cnt - 1);
                    } else {
                        // delete min (x == -1)
                        int key = map.firstKey();
                        int cnt = map.get(key);
                        if (cnt == 1) map.remove(key);
                        else map.put(key, cnt - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
