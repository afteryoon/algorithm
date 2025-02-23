
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int count = 0;
	static int[] col;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new int[n];

		backtrack(0);
		System.out.print(count);
	}

	public static void backtrack(int row) {
		if(row == n) {
			count++;
			return;
		}

		for(int i=0; i<n; i++) {
			col[row] = i;
			if(isPossible(row)) {
				backtrack(row+1);
			}
		}
	}

	static boolean isPossible(int row) {
		for(int i=0; i<row; i++) {
			if(col[i] == col[row] || Math.abs(col[i] - col[row]) == Math.abs(i-row)) {
				return false;
			}
		}
		return true;
	}
}
