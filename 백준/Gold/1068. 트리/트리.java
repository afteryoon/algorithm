

import java.util.*;
import java.io.*;

public class Main {
	static int result =0;
	static List<List<Integer>> graph;
	static boolean[] deleted;
	static int deleteNode;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodes = Integer.parseInt(st.nextToken());
		int root = 0;
		deleted = new boolean[nodes];

		graph = new ArrayList<>();
		for(int i = 0; i <nodes; i++){
			graph.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<nodes; i++){
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1){
				root = i;
				continue;
			}
			graph.get(parent).add(i);
		}

		st = new StringTokenizer(br.readLine());
		deleteNode = Integer.parseInt(st.nextToken());
		delete(deleteNode);

		if(!deleted[root] && deleteNode != root) {
			result = countLeafNodes(root);
		}

		System.out.println(result);
	}

	public static int countLeafNodes(int node){
		if(deleted[node]) return 0;
		if(graph.get(node).isEmpty()) return 1;

		int count =0;
		boolean isLeaf = true;

		for(int child : graph.get(node)){
			if(!deleted[child]){
				isLeaf = false;
				count += countLeafNodes(child);
			}
		}

		return isLeaf ? 1 : count;
	}

	public static void delete(int node){
		deleted[node] = true;
		for(int child : graph.get(node)){
			delete(child);
		}
	}


}
