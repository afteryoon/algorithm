

import java.io.*;
import java.util.*;

public class Main {
	static int time = 0;
	static int k;
	static Queue<Integer> q = new LinkedList<>();
	static int[] visited = new int[100001];  // boolean 대신 int 배열 사용

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int count = bfs(n);

		System.out.println(time - 1);  // 마지막 time++ 때문에 1을 빼줌
		System.out.println(count);
	}

	public static int bfs(int n) {
		int count = 0;
		q.offer(n);
		visited[n] = 1;  // 방문 시간을 1부터 시작

		while (!q.isEmpty()) {
			int size = q.size();
			time++;

			for (int i = 0; i < size; i++) {
				int curr = q.poll();

				if (curr == k) {
					count++;
					continue;
				}

				int[] moves = {curr * 2, curr + 1, curr - 1};

				for (int move : moves) {
					if (move < 0 || move > 100000) continue;

					// 방문하지 않았거나, 같은 시간에 방문한 경우
					if (visited[move] == 0 || visited[move] == time + 1) {
						q.offer(move);
						visited[move] = time + 1;
					}
				}
			}

			if (count > 0) {
				return count;
			}
		}
		return 0;
	}
}