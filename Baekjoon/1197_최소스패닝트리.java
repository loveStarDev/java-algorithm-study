/**
 * MST
 * => 선수 : 가중치를 기준으로 먼저 오름차순 정렬
 * 1. 가장 적은 간선을 선택하여 그래프에 삽입
 * 2. 포함 시킨 그래프가 사이클을 형성하는지 확인 (분기)
 * 3-1. (사이클 형성 시) 간선을 제거하고 다음 간선을 선택
 * 3-2. (사이클 형성 안될 시) 그대로 그래프에 포함 후 다음 간선을 확인
 */
package com.ssafy.algorithm.boj_1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, res;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		public int v1, v2, value;

		public Edge(int v1, int v2, int value) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.value > o.value)
				return 1;
			else if (value < o.value)
				return -1;
			return 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		// 입력받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(v1, v2, value));
		}

		// graph 만들기
		makeGraph();

		System.out.println(res);
	}

	private static void makeGraph() {
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (!isCycle(e.v1, e.v2)) {
				union(e.v1, e.v2);
				res += e.value;
			}
		}
	}
	
	private static void union(int a, int b) {
		int x = getParent(a);
		int y = getParent(b);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}

	private static boolean isCycle(int a, int b) {
		int x = getParent(a);
		int y = getParent(b);
		return x == y;
	}

	private static int getParent(int x) {
		if (parent[x] == x)
			return x;
		return getParent(parent[x]);
	}
}
