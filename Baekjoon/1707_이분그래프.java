package com.ssafy.algorithm.boj_1707_이분그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] visited;
	static int V, E;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int tc = 0;

		while (tc++ < K) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList[V + 1];
			visited = new int[V + 1];

			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			// 입력받기
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				graph[v1].add(v2);
				graph[v2].add(v1);
			}

			// 색칠
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0)
					DFS(i, 1);
			}
			
			System.out.println(result());			
		}
	}

	private static void DFS(int x, int c) {
		visited[x] = c;
		for (int y : graph[x])
			if (visited[y] == 0)
				DFS(y, 3 - c);
	}
	
	private static String result(){
		for (int i = 1; i <= V; i++) {
			for (int j : graph[i]) {
				if (visited[j] == visited[i]) {
					return "NO";
				}
			}
		}
		return "YES";
	}
}
