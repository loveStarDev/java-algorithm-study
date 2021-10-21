package com.ssafy.algorithm.boj_4179_불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static Character[][] map;
	public static int R, C;
	
	public static Queue<Point> queue = new LinkedList<Point>();
	
	static class Point{
		int x, y, dis;
		char s;
		
		public Point(int x, int y, int dis, char s) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new Character[R][C];
		
		// 입력받기
		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = sb.charAt(j);
				if(map[i][j] == 'J') {
					queue.add(new Point(j, i, 0, 'J'));
					continue;
				}
				
				if(map[i][j] == 'F') {
					queue.add(new Point(j, i, 0, 'F'));
					continue;
				}
			}
		}
		
		bfs();
	}


	private static void bfs() {
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			// 지훈이의 현재 위치였던 곳이 불이 번졌다면 다음으로
			if(p.s == 'J' && map[p.y][p.x] == 'F') continue;
			
			for (int i = 0; i < dx.length; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				
				if(xx < 0 || xx >= C || yy < 0 || yy >= R) {
					// 만약 바운더리를 벗어나는 곳을 발견했다면 종료!
					if(p.s == 'J') {
						System.out.println(p.dis+1);
						System.exit(0);
					}else continue;
				}
				
				// 지훈이가 이동 할 때
				if(p.s == 'J') {
					// 벽이거나 불이면 다음으로
					if(map[yy][xx] != '.') continue;
					queue.add(new Point(xx, yy, p.dis+1, p.s));
					map[yy][xx] = 'J';
				}
				
				// 불이 이동할때
				else {
					// 벽에 부딪히면 다음
					if(map[yy][xx] == '#' || map[yy][xx] == 'F') continue;
					map[yy][xx] = 'F';
					queue.add(new Point(xx, yy, p.dis+1, p.s));
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
}
