package com.ssafy.algorithm.swexpert_1949_등산로조성;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int N, K, res;
	static boolean[][] visited;
	static int[][] map;
	
	
	public static class Point{
		int x, y;
		boolean chance;
		
		public Point(int y, int x, boolean c) {
			this.y = y;
			this.x = x;
			this.chance = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			// 초기화
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			res = 0;
			
			map = new int[N][N];
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = max > map[i][j] ? max : map[i][j]; 
				}
			}
			
			// for문을 돌면서 max 값을 발견하면 그 시점부터 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						visited = new boolean[N][N];
						dfs(i, j, true, 1);
					}
				}
			}
			
			// 출력
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void dfs(int y, int x, boolean chance, int h) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int yy = y + dy[i];
			int xx = x + dx[i];
			
			if(xx < 0 || xx >= N || yy < 0 || yy >= N || visited[yy][xx]) continue;
			
			// 만약 가려는 방향에 높이가 크다면
			if(map[y][x] <= map[yy][xx]){
				// 지형을 깎을 수 있는지 확인한다
				if(chance && (map[yy][xx] - K + 1 <= map[y][x]) ) {
					int cuth = map[yy][xx] - map[y][x] + 1;
					map[yy][xx] -= cuth;
					dfs(yy, xx, false, h+1);
					map[yy][xx] += cuth;
				}
			}
			
			else dfs(yy, xx, chance, h+1);
			
		}
		res = res > h ? res : h;
		visited[y][x] = false;
	}
}
