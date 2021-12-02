package com.ssafy.algorithm.swexpert_2112_보호필름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int D, W, K;
	static int res = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			// 초기화
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			res = 0;
			
			visited = new boolean[D];
			map = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 품질검증
			if(!check(map) && K > 1) {
				// 불통과시, 약품 투입을 진행한다.
				res = Integer.MAX_VALUE;
				int[][] copyM = new int[D][W];
				for (int i = 0; i < copyM.length; i++) {
					copyM[i] = map[i].clone();
				}
				insertMap(copyM, 0, 0);
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void insertMap(int[][] m, int cnt, int start) {	
		// 현재 찾은 값 보다 많은 경우에는 탐색 할 필요 없음
		if(cnt >= res) return;
		
		if(cnt >= 1) {
			if(check(m)) {
				res = res > cnt ? cnt : res;
				return;
			}
		}
		
		for (int i = start; i < D; i++) {
			if(!visited[i]) {
				// A약을 넣었을 때
				visited[i] = true;
				fill(m, i, 0);
				insertMap(m, cnt+1, i+1);
				
				// B약을 넣었을 때
				fill(m, i, 1);
				insertMap(m, cnt+1, i+1);
				
				// 복구
				recovery(m, i);
				visited[i] = false;
			}
		}
	}
	
	public static void fill(int[][] m, int idx, int v) {
		for (int i = 0; i < W; i++) {
			m[idx][i] = v;
		}
	}
	
	public static void recovery(int[][] m, int idx) {
		for (int i = 0; i < W; i++) {
			m[idx][i] = map[idx][i];
		}
	}
	
	public static boolean check(int[][] m) {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			int prev = m[0][j];
			boolean trigger = false;
			for (int i = 1; i < D; i++) {
				if(m[i][j] == prev) {
					cnt++;
					if(cnt >= K) {
						trigger = true;
						break; 
					}
				}else {
					cnt = 1;
					prev = m[i][j];
				}
			}
			
			if(!trigger) return false; 
		}
		return true;
	}
}
