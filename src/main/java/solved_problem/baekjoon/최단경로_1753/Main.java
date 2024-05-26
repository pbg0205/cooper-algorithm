package solved_problem.baekjoon.최단경로_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int nodeSize = Integer.parseInt(st.nextToken());
		int edgeSize = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		Graph graph = makeGraph(nodeSize, edgeSize);

		graph.dijkstra(start);
	}

	private static Graph makeGraph(int nodeSize, int edgeSize) throws IOException {
		Graph graph = new Graph(nodeSize);

		while (edgeSize-- > 0) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.insertNode(start, end, weight);
		}

		return graph;
	}

}

class Graph {
	class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node other) {
			return this.weight - other.weight;
		}
	}

	private ArrayList<Node>[] edgeList;

	public Graph(int size) {
		this.edgeList = new ArrayList[size + 1];
		for (int index = 0; index <= size; index++) {
			edgeList[index] = new ArrayList<>();
		}
	}

	public int size(){
		return this.edgeList.length - 1;
	}

	public void insertNode(int start, int end, int weight){
		this.edgeList[start].add(new Node(end, weight));
	}

	public void dijkstra(int start){
		boolean[] visited = new boolean[size() + 1];
		int[] distance = initDistance(size() + 1, start);

		distance = minDistance(distance, visited, start);

		print(distance);
	}

	private int[] minDistance(int[] distance,
		boolean[] visited,
		int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while(!pq.isEmpty()){
			Node currentNode = pq.poll();
			int adjacent =  currentNode.end;

			if(!visited[adjacent]){
				visited[adjacent] = true;
			}else{
				continue;
			}

			for (Node node : edgeList[adjacent]){
				if(distance[node.end] > distance[adjacent] + node.weight){
					distance[node.end] = distance[adjacent] + node.weight;
					pq.offer(new Node(node.end, distance[node.end]));
				}
			}
		}

		return distance;
	}

	private void print(int[] distance) {
		final int INF = Integer.MAX_VALUE;

		for (int index = 1; index <= size(); index++){
			if(distance[index] == INF){
				System.out.println("INF");
			}else{
				System.out.println(distance[index]);
			}
		}
	}

	private int[] initDistance(int size, int start) {
		int[] distance = new int[size + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		return distance;
	}
}
