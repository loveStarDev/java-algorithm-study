package com.ssafy.algorithm.boj2589_보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static public int W, H, D;
	static char[][] map;
	static Queue<point> q = new LinkedList<Main.point>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class point {
		public point(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		int x, y, cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][W];

		// 입력받기
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 보물 생성하기
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') {
					q.add(new point(i, j, 0));
					BFS(deepCopy(map));
				}
			}
		}

		System.out.print(D);
	}

	private static void BFS(char[][] Dmap) {
		int d = 0;

		while (!q.isEmpty()) {
			point p = q.poll();

			int x = p.x;
			int y = p.y;

			Dmap[y][x] = 'W';
			for (int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];

				if (!isWall(xx, yy) && Dmap[yy][xx] == 'L') {
					q.add(new point(yy, xx, p.cnt+1));
					Dmap[yy][xx] = 'W';
				}
			}
			
			if(q.isEmpty())
				d = p.cnt;
		}

		if (D < d)
			D = d;
	}

	public static boolean isWall(int x, int y) {
		if (x >= 0 && x < W && y >= 0 && y < H)
			return false;
		return true;
	}

	// 이차원배열 깊은복사
	public static char[][] deepCopy(char[][] original) {
		char[][] temp = new char[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = original[i][j];
			}
		}
		return temp;
	}

}
