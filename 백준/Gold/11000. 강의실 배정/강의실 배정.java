
import java.util.*;
import java.io.*;

public class Main {

	static class Lecture {
		int start;
		int end;

		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Lecture[] lectures = new Lecture[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(start, end);
		}

		Arrays.sort(lectures, (a, b) -> a.start - b.start);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures[0].end);

		for(int i = 1; i < n; i++) {
			if(lectures[i].start >= pq.peek()) {
				pq.poll();
			}
			pq.offer(lectures[i].end);
		}

		System.out.print(pq.size());
	}
}
