
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int test = 0; test < testN; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int an = Integer.parseInt(st.nextToken());
			int bn = Integer.parseInt(st.nextToken());
			int[] arra = new int[an];
			int[] arrb = new int[bn];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arra.length; i++) {
				arra[i]=  Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arrb.length; i++) {
				arrb[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arrb);
			Arrays.sort(arra);


			System.out.println(count(arrb, arra));
		}

	}

	private static int count(int[] arrb, int[] arra) {
		int count = 0;
		int start = 0;

		for (int i = 0; i < arra.length; i++) {
			start = bs(arrb, arra[i], start);
			count += start;
		}

		return count;
	}

	private static int bs(int[] arrb, int n, int start) {
		int left = start;
		int right = arrb.length;

		while (left < right){
			int mid = left + (right - left) / 2;

			if(arrb[mid]<n){
				left = mid+1;
			}else{
				right = mid;
			}
		}

		return left;

	}

}
