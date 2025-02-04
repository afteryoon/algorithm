import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] arr = new int[w];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result =0;
		int left = 0 ,right = w-1;
		int leftMax = arr[left], rightMax = arr[right];

		while(left<right) {
			leftMax = Math.max(arr[left],leftMax);
			rightMax = Math.max(arr[right],rightMax);

			if(leftMax<=rightMax){
				result += leftMax-arr[left];
				left++;
			}else{
				result += rightMax-arr[right];
				right--;
			}
		}

		System.out.print(result);
	}
}
