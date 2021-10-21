package com.ssafy.algorithm.boj_1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static boolean[] visited;
	static int N, E, res, root;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] == -1) root = i;
		}
		
		E = Integer.parseInt(br.readLine());

		eraser(E);
		countleaf(root);
		
		System.out.println(res);
	}

	private static void countleaf(int n) {
		
		visited[n] = true;
		if(tree[n] != -2) {
			boolean tri = true;
			for (int i = 0; i < tree.length; i++) {
				if(!visited[i] && tree[i] == n) {
					countleaf(i);
					tri = false;
				}
			}
			if(tri) res++;
		}
	}

	private static void eraser(int n) {
		tree[n] = -2;
		for (int i = n; i < tree.length; i++) {
			if(tree[i] == n) {
				eraser(i);
			}
		}
	}
	
	
}
