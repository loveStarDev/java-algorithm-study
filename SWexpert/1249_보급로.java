package com.ssafy.algorithm.swexpert_1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	static int N, res;
	static int[][] map, ans;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1}; 
	static boolean[][] visited;
	
	public static class point implements Comparable<point>{
		int x, y, d;
		
		public point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	    @Override
	    public int compareTo(point p){
	        if(this.d > p.d)
	            return 1;
	        else if(this.d < p.d)
	            return -1;
	        return 0;
	    }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = new int[N][N];
			visited = new boolean[N][N];
			
			// 입력받기
			for (int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = sb.charAt(j) - '0';
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			
			BFS(0, 0);
			
			System.out.println("#"+tc+" "+res);						
		}
	}
	
	public static void BFS(int x, int y) {
		PriorityQueue<point> queue = new PriorityQueue<point>();
		
		res = Integer.MAX_VALUE;
		queue.offer(new point(0,0,0));
		
		while(!queue.isEmpty()) {
			point p = queue.poll();

			// 도착지에 왔다면
			if(p.x == N-1 && p.y == N-1) {
				res = Math.min(p.d, res);
				continue;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= N || visited[yy][xx] || p.d + map[yy][xx] >= ans[yy][xx]) continue;
				
				visited[yy][xx] = true;
				ans[yy][xx] = p.d + map[yy][xx];
				queue.offer(new point(xx, yy, ans[yy][xx]));
			}
		}
	}
}
