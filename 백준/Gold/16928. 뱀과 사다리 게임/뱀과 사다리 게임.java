
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] map = new int[101];
		int[] dist = new int[101];

		Arrays.fill(dist,-1);

		for (int i=0; i<(u+d); i++ ) {
			 st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		dist[1]=0;

		while(!q.isEmpty()){
			int current = q.poll();

			for(int i=1; i<=6; i++) {
				int next = current+i;
				if(map[next] != 0 ) next =map[next];
				if(next>100 || dist[next] !=-1) continue;

				if(next<=100 && map[next] <=100 && dist[next] ==-1 ){
					q.offer(next);
					dist[next] = dist[current] +1;
					if(next == 100){
						System.out.print(dist[next]);
						return;
					}
				}
			}
		}
	}
}
