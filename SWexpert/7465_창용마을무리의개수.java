package com.ssafy.algorithm.swexpert_7465_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] relation;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			relation = new int[N+1];
			for (int i = 0; i <= N; i++) {
				relation[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				union(v1, v2);
			}
			
			ArrayList<Integer> cnt = new ArrayList<>();
			for (int i = 1; i < relation.length; i++) {
				int p = find(relation[i]);
				if(!cnt.contains(p))
					cnt.add(p);
			}
			
			System.out.println("#"+tc+" "+cnt.size());
		}
	}

	private static void union(int v1, int v2) {
		int A = find(v1);
		int B = find(v2);
		if(A < B) relation[B] = A;
		else relation[A] = B;
	}

	private static int find(int v) {
		if(relation[v] == v) return v;
		return find(relation[v]);
	}
}
