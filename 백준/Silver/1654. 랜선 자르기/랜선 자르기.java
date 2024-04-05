
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int k=Integer.parseInt(st.nextToken());
		int n= Integer.parseInt(st.nextToken());
		long[] arr= new long [k];
		
		for(int i=0; i<k; i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		
		long max=Arrays.stream(arr).max().orElseThrow();
		
		long start=1;
		long end=max;
		
		while(start<=end) {
			long mid=(start+end)/2;
			
			long sum=Arrays.stream(arr).map(e->e/mid).sum();
			
			if(sum>=n)
				start=mid+1;
			else
				end=mid-1;
			
		}
		System.out.println(end);

	}

}
