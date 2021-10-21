package com.ssafy.algorithm.boj_11581_구호물자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[] visited;
	static LinkedList<Integer> list[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new int[N+1];
		list = new LinkedList[N+1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		// 입력받기
		for (int i = 1; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < t; j++) {
				list[i].add(Integer.parseInt(st.nextToken())); 
			}
		}
		
		dfs(1);
		
		System.out.print("NO CYCLE");
	}

	private static void dfs(int i) {
		if(visited[i] == 1) {
			System.out.print("CYCLE");
			System.exit(0);
		}
		
		visited[i] = 1;
		
		for (int j : list[i]) {
			if(visited[j] != 2) dfs(j); 
		}
		
		visited[i] = 2;
	}
}
