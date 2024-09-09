
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isVisit;
	static int[] arr;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		isVisit = new boolean[n+1];
		backTracking(0,1);
		System.out.println(sb);
	}

	private static void backTracking(int depth, int start) {
		if(depth == m){
			for (int var : arr) {
				sb.append(var).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n ; i++) {
			if(!isVisit[i]){
				isVisit[i]=true;
				arr[depth] = i;
				backTracking(depth+1,i+1);
				isVisit[i]=false;
			}
		}
	}
}
