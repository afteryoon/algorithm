
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meet implements Comparable<Meet>{
	int start;
	int end;

	public Meet(int start, int end) {
		this.start = start;
		this.end = end;
	}


	@Override
	public int compareTo(Meet o) {
        if (this.end == o.end) {
			return this.start - o.start; // 끝나는 시간이 같으면 시작하는 시간 오름차순 정렬
		}
		return this.end - o.end;
	}
}
public class Main {
/*
* 	회의실 배정 괄호 1541
* 	메모리
* 	시간
*
*/
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		ArrayList<Meet> meet = new ArrayList<>();
		for (int i=0; i<n; i++){
			StringTokenizer st= new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			meet.add(new Meet(start,end));
		}

		Collections.sort(meet);

		int count=0;
		int temp=0;
		for(Meet elem : meet ){
			if(elem.start>=temp){
				count++;
				temp=elem.end;
			}
		}

		System.out.println(count);


	}

}
