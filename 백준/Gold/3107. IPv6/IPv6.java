
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ip= br.readLine();
		
		if(ip.contains("::"))
			ip=ip.replace("::", ":check:");
		
		String[] arr=ip.split(":");
		ArrayList<String> al= new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length()<4) {
				while(arr[i].length()<4) {
					arr[i]="0"+arr[i];
				}
			}
			al.add(arr[i]);
		}
		
		String[] fullIp= new String[8];
		int count=8-al.size()+1;
		int index=0;
		
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).equals("check")) {
				while(count > 0) {
						fullIp[index] = "0000";
						index++;
						count--;
				   }
			}
			else {
				fullIp[index] = al.get(i);
				index++;
			}
		}
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < fullIp.length-1; i++) {
			sb.append(fullIp[i]).append(":");
		}
		sb.append(fullIp[7]);
		System.out.println(sb);
	}
}
