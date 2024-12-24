
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			String str = br.readLine();
			if (str.equals("0 0 0"))
				break;

			String[] strs = str.split(" ");
			int[] arr = Arrays.stream((Arrays.stream(strs).mapToInt(Integer::parseInt).toArray())).sorted().toArray();
			int max = arr[2];
			int sum = arr[0] + arr[1];
			int count = 1;

			for (int i = 0; i < arr.length; i++) {
				if(i !=0 && arr[i] == arr[i-1])
					count++;
			}
			if (max>=sum)
				sb.append("Invalid");
			else if(count == 3)
				sb.append("Equilateral");
			else if(count == 2)
				sb.append("Isosceles");
			else
				sb.append("Scalene");

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
