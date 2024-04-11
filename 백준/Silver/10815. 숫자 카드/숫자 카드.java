
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 10815 숫자카드
 * 시간 
 * 메모리
 */
	static int [] card;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		card= new int[n];
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		
		int m= Integer.parseInt(br.readLine());
		 st= new StringTokenizer(br.readLine());
		arr=new int[m];
		 
		for (int i = 0; i <m; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			int check=binarySearch(arr[i])?1:0;
			sb.append(check+" ");
		}
	
		System.out.println(sb);
	}
	
	private static boolean binarySearch(int num) {
		boolean flag=false;
		
		int start=0;
		int end=card.length-1;
		
		while(start<=end) {
			int mid= (start+end)/2;
			
			if(card[mid]==num) {
				return true;
			}
			
			if(card[mid]>num)
				end=mid-1;
			else if(card[mid]<num)
				start=mid+1;
		}
		
		return flag;
	}
	

}
