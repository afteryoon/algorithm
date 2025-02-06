

import java.io.*;
import java.util.*;

public class Main {
	static int[] switchNum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		switchNum = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++ ) {
			switchNum[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());

		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (s == 1) male(num);
			else female(num);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<switchNum.length; i++) {
			sb.append(switchNum[i]).append(" ");
			if(i%20 ==0) sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void male(int num){
		for (int i=num; i<switchNum.length; i+=num) {
			switchNum[i] = switchNum[i] == 0 ? 1 : 0;
		}
	}
	public static void female(int num){
		int left= num-1;
		int right= num+1;
		switchNum[num] = switchNum[num] == 0 ? 1 : 0;
		while (left>0 && switchNum.length > right) {
			if(switchNum[left] != switchNum[right]) break;

			switchNum[left] = switchNum[left] == 0 ? 1 : 0;
			switchNum[right] = switchNum[right] == 0 ? 1 : 0;

			left--;
			right++;
		}

	}
}
