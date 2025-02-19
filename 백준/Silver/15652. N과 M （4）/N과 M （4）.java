
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static boolean[] isVisit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		isVisit = new boolean[n+1];
		arr = new int[m];

		backTracking(0,1);
		System.out.println(sb);
	}

	public static void backTracking(int depth, int start){
		if(depth == m){
			for (int val : arr){
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n; i++) {

				arr[depth] =i;
				backTracking(depth+1,i);
		}
	}
}
