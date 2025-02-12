
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); //목표
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		int left = 0;
		int right = 0;
		int sum = 0;

		while (true){
			if(sum>=m){
				if (sum==m)
					count++;
				sum-=arr[left++];
			} else if (right==n) {
				break;
			}else {
				sum+=arr[right++];
			}
		}

		System.out.print(count);
	}
}
