
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static boolean[] isVisit;
	static int[] arr;
	static int[] arr2;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		arr2 = new int[m];
		isVisit = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		backTracking(0);
		System.out.println(sb);
	}

	private static void backTracking(int depth) {
		if(depth == m){
			for (int val : arr2){
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!isVisit[i]){
				isVisit[i]=true;
				arr2[depth]=arr[i];
				backTracking(depth + 1);
				isVisit[i]=false;
			}
		}
	}
}
