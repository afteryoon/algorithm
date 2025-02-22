
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static boolean[] selected;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 집과 치킨집 위치 저장
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) houses.add(new int[]{i, j});
				else if(value == 2) chickens.add(new int[]{i, j});
			}
		}

		selected = new boolean[chickens.size()];
		// m개의 치킨집 선택
		combination(0, 0);

		System.out.println(answer);
	}

	// 조합으로 치킨집 선택
	static void combination(int start, int count) {
		if(count == m) {
			// 선택된 치킨집으로 도시의 치킨 거리 계산
			answer = Math.min(answer, calculateChickenDistance());
			return;
		}

		for(int i = start; i < chickens.size(); i++) {
			selected[i] = true;
			combination(i + 1, count + 1);
			selected[i] = false;
		}
	}

	// 도시의 치킨 거리 계산
	static int calculateChickenDistance() {
		int totalDistance = 0;

		for(int[] house : houses) {
			int minDistance = Integer.MAX_VALUE;
			for(int i = 0; i < chickens.size(); i++) {
				if(selected[i]) {
					int[] chicken = chickens.get(i);
					int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
					minDistance = Math.min(minDistance, distance);
				}
			}
			totalDistance += minDistance;
		}

		return totalDistance;
	}
}
