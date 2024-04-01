

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int[][] arr=new int [9][9];
		int max=Integer.MIN_VALUE;

		String answer="";
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < arr[i].length; j++) {
				int num= Integer.parseInt(st.nextToken());
				if(max<num) {
					max=num;
					answer= num+"\n"+(i+1)+" "+(j+1);
				}
				
			}
		}
		System.out.println(answer);
	}
}
