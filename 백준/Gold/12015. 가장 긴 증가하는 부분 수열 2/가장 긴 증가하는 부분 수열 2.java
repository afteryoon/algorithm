

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);

		for(int i=1; i<n; i++) {
			if(arr[i] > list.get(list.size()-1)) {
				list.add(arr[i]);
			} else {
				int pos = Collections.binarySearch(list,arr[i]);
				if(pos < 0) {
					pos = -(pos + 1);
					list.set(pos, arr[i]);
				}
			}
		}
		System.out.print(list.size());
	}
}
