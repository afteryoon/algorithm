
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 18870번 좌표 압축
 * 시간
 * 메모리
 * -시간복잡도
 * 
 * 문제
 * 여기서 각 원소를 순위 
 * 낮은 값이 순위가 높다는 점
 * 
 * 낮은 값이 높은 순위를 갖는다. (가장 높은 순위는 0순위다.)
 * 중복되는 원소는 같은 순위를 갖는다.
 * 같은 수는 랭크가 같다.
 * 출력값은 입력 받은 순의 rank값이다.
 * 
 * 원본 배열과 정렬 배열을 분리하고
 * 정렬된 배열에서 map에 rank 값을 담은 후
 * 원본 배열을 반복하여 해당 숫자를 키값으로 출력
 * 
 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int k= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] arr= new int[k]; //원본 
		int[] arrSort = new int[k]; //정렬
		
		for (int i = 0; i < k; i++) {
			arr[i]=arrSort[i]=Integer.parseInt(st.nextToken());
		}
		
		//배열 정렬
		Arrays.sort(arrSort);
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int rank=0;
		for(int elem : arrSort) {
			
			//같은 값은 rank가 같음
			if(!map.containsKey(elem)) {
				map.put(elem, rank);
				rank++;
			}
		}
		
		StringBuilder sb= new StringBuilder();
		for(int key : arr) {
			sb.append(map.get(key)+" ");
		}
		
		System.out.println(sb);
	}
}
