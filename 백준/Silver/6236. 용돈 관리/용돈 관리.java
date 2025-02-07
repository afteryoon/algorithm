
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//혼자 안됐음
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		int left = 0;
		int right = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right += arr[i];
			left = Math.max(left, arr[i]);
		}

		while(left <= right) {
			int mid = (left + right) / 2;
			if(check(arr, mid, m)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	static boolean check(int[] arr, int mid, int m) {
		int count = 1;
		int sum = 0;
		for(int money : arr) {
			if(sum + money > mid) {
				count++;
				sum = money;
			} else {
				sum += money;
			}
		}
		return count <= m;
	}
}
