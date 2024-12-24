import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken()); //행
		int w = Integer.parseInt(st.nextToken()); //열
		int n = Integer.parseInt(st.nextToken()); //세로
		int m = Integer.parseInt(st.nextToken()); //가로

		int col = (h-1)/(n+1)+1;
		int row = (w-1)/(m+1)+1;
		int total = col*row;

		StringBuilder sb = new StringBuilder();
		sb.append(total);
		System.out.println(sb.toString());
	}
}
