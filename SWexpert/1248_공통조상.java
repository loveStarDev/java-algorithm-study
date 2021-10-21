package com.ssafy.algorithm.swexpert_1248_공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;

		while (tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 찾아야할 노드
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());

			int tree[][] = new int[V+1][3]; // 0: left, 1:right, 2:parent

			// 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				tree[v][0] = p;
				
				if(tree[p][1] == 0) tree[p][1] = v;
				else tree[p][2] = v;
			}

			LinkedList<Integer> L1P = new LinkedList<>();
			LinkedList<Integer> L2P = new LinkedList<>();

			// N1의 모든 조상노드
			int n = N1;
			while (tree[n][0] != 0) {
				n = tree[n][0];
				L1P.add(n);
			}

			// N2의 모든 조상노드
			n = N2;
			while (tree[n][0] != 0) {
				n = tree[n][0];
				L2P.add(n);
			}
			
			int parent = 1, deep = 0;
			for (int i = 0; i < L1P.size(); i++) {
				int a = L1P.get(i);
				boolean tri = false;
				for (int j = 0; j < L2P.size(); j++) {
					int b = L2P.get(j);
					if(a==b) {
						tri = true;
						parent = a;
						break;
					}
				}
				if(tri)
					break;
			}
			
			deep = preOrder(tree, parent);

			System.out.println("#"+tc+" "+parent + " "+deep);
		}
	}
	
	public static int preOrder(int[][] tree, int p) {
		if(tree[p][1] == 0 && tree[p][2] == 0)
			return 1;
		
		int cnt = 1;
		
		if(tree[p][1] != 0)
			cnt += preOrder(tree, tree[p][1]);
		if(tree[p][2] != 0)
			cnt += preOrder(tree, tree[p][2]);
		
		return cnt;
	}
}
