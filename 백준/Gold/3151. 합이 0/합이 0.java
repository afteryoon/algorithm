
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long result = 0;

		for (int i=0; i<n; i++) {
			int left = i+1;
			int right = n-1;

			while(left<right) {
				int sum = arr[i] +arr[left] + arr[right];
				if(sum == 0){

					if(arr[left] == arr[right]) {
						result += (right - left + 1) * (right - left) / 2;
						break;
					}

					int leftCount = 1;
					int rightCount = 1;

					while(left<right && arr[left] == arr[left+1]) {
						leftCount++;
						left++;
					}

					while(left<right && arr[right] == arr[right-1]) {
						rightCount++;
						right--;
					}
					result += leftCount*rightCount;
					right--;
					left++;
				}
				else if( sum < 0 ) left++;
				else right--;
			}
		}
		System.out.print(result);
	}
}
