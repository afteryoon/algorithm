

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());

			// 최대 힙과 최소 힙 선언
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

			// 각 숫자의 개수를 저장하는 맵
			Map<Integer, Integer> countMap = new HashMap<>();

			for(int i = 0; i < k; i++) {
				String[] op = br.readLine().split(" ");
				char command = op[0].charAt(0);
				int n = Integer.parseInt(op[1]);

				if(command == 'I') {
					// 삽입 연산
					minHeap.offer(n);
					maxHeap.offer(n);
					countMap.put(n, countMap.getOrDefault(n, 0) + 1);
				} else if(command == 'D') {
					if(countMap.isEmpty()) continue; // 큐가 비어있으면 무시

					if(n == 1) {
						// 최댓값 삭제
						removeFromHeap(maxHeap, countMap);
					} else if(n == -1) {
						// 최솟값 삭제
						removeFromHeap(minHeap, countMap);
					}
				}

				// 동기화 - 이미 삭제된 값들을 힙에서 제거
				while(!minHeap.isEmpty() && countMap.getOrDefault(minHeap.peek(), 0) == 0) {
					minHeap.poll();
				}
				while(!maxHeap.isEmpty() && countMap.getOrDefault(maxHeap.peek(), 0) == 0) {
					maxHeap.poll();
				}
			}

			// 결과 출력
			if(countMap.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				// 마지막 동기화
				while(!minHeap.isEmpty() && countMap.getOrDefault(minHeap.peek(), 0) == 0) {
					minHeap.poll();
				}
				while(!maxHeap.isEmpty() && countMap.getOrDefault(maxHeap.peek(), 0) == 0) {
					maxHeap.poll();
				}

				sb.append(maxHeap.peek() + " " + minHeap.peek() + "\n");
			}
		}

		System.out.print(sb);
	}

	// 힙에서 요소를 제거하고 맵에서 카운트 감소
	private static void removeFromHeap(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {
		while(!heap.isEmpty()) {
			int value = heap.poll();
			int count = countMap.getOrDefault(value, 0);

			if(count > 0) {
				// 개수 감소 또는 맵에서 제거
				if(count == 1) {
					countMap.remove(value);
				} else {
					countMap.put(value, count - 1);
				}
				break;
			}
		}
	}
}
