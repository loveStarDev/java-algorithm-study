package com.ssafy.algorithm.swexpert_4012_요리사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int[][] S;
	static ArrayList<Integer> A = new ArrayList<>(), B = new ArrayList<>();
	static int N, res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			res = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			
			// 입력받기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			
			BFS(0);
			
			System.out.println("#"+tc+" "+res);
		}
	}

	private static void BFS(int idx) {
		if(A.size() == N/2) {
			B.clear();
			// B 재료 선택
			for (int i = 0; i < N; i++) {
				if(!A.contains(i))
					B.add(i);
			}
			
			int a = eval(A);
			int b = eval(B);
			res = Math.min(res, Math.abs(a-b));			
			return;
		}
		
		for (int i = idx; i < N; i++) {
			A.add(i);
			BFS(i+1);
			A.remove((Object)i);
		}
	}
	
	private static int eval(ArrayList<Integer> arr) {
		int temp = 0;
		
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if( i == j ) continue;
				temp += S[arr.get(i)][arr.get(j)];
			}
		}
		
		return temp;
	}
}
