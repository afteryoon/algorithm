
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	//가장 긴 증가하는 부분 수열 11053
	//
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> lis = new ArrayList<>();
		lis.add(A[0]);

		for (int i = 1; i < N; i++) {
			if (A[i] > lis.get(lis.size() - 1)) {
				lis.add(A[i]);
			} else {
				int index = binarySearch(lis, A[i]);
				lis.set(index, A[i]);
			}
		}

		System.out.println(lis.size());
	}

	// 이진 탐색 메서드
	private static int binarySearch(ArrayList<Integer> lis, int target) {
		int left = 0;
		int right = lis.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (lis.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}
}
