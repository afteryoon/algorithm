
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine()," ");
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][m];
		
		for (int i = 0; i < arr.length; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < arr.length; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+Integer.parseInt(st.nextToken())+" ");
			}
			System.out.println();
		}
		
	}
}
