
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();

		StringBuilder sb = new StringBuilder();

		for (char c : str.toCharArray()){
			sb.append(c);
			boolean flag = true;
			if (sb.length()>=bomb.length()) {
				for (int i = 0; i < bomb.length(); i++) {
					if (sb.charAt(sb.length()-bomb.length()+i) != bomb.charAt(i)){
						flag = false;
						break;
					}
				}
				if(flag){
					sb.setLength(sb.length()-bomb.length());
				}
			}
		}

		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}
}