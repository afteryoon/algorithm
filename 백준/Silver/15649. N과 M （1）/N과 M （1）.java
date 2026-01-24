
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	static boolean[] isUse;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		result = new int[M];
		isUse = new boolean[N+1];
		bk(0);
		System.out.println(sb);
	}

	static void bk(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) sb.append(result[i]).append(" ");
			sb.append('\n');
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!isUse[i]){
				isUse[i] = true;
				result[depth] = i;
				bk(depth + 1);
				isUse[i] = false;
			}
		}
	}
}
