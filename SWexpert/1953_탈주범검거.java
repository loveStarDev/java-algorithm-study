package com.ssafy.algorithm.swexpert_1953_탈주범검거;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Queue<Point> queue = new LinkedList<>();
	static int[][] map;
	static int N, M, R, C, L, res;
	static ArrayList<Point>[] dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		init();

		while (tc++ < T) {
			queue.clear();
			res = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];

			// 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			BFS();
			
			System.out.println("#"+tc+" "+(res));
		}
	}

	private static void init() {
		dir = new ArrayList[8];
		for (int i = 1; i < dir.length; i++) {
			dir[i] = new ArrayList<Point>();
		}

		// 상하좌우
		dir[1].add(new Point(0, -1));
		dir[1].add(new Point(0, 1));
		dir[1].add(new Point(-1, 0));
		dir[1].add(new Point(1, 0));

		// 상하
		dir[2].add(new Point(0, -1));
		dir[2].add(new Point(0, 1));

		// 좌우
		dir[3].add(new Point(-1, 0));
		dir[3].add(new Point(1, 0));

		// 상우
		dir[4].add(new Point(0, -1));
		dir[4].add(new Point(1, 0));

		// 하우
		dir[5].add(new Point(0, 1));
		dir[5].add(new Point(1, 0));

		// 하좌
		dir[6].add(new Point(0, 1));
		dir[6].add(new Point(-1, 0));

		// 상좌
		dir[7].add(new Point(0, -1));
		dir[7].add(new Point(-1, 0));
	}

	private static void BFS() {
		queue.add(new Point(C, R));
		queue.add(new Point(-1, -1));
		int t = 1;
		res++;

		while (t < L && !queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == -1 && p.y == -1) {
				queue.add(new Point(-1, -1));
				t++;
				continue;
			}

			for (Point d : dir[map[p.y][p.x]]) {
				int x = p.x + d.x;
				int y = p.y + d.y;

				if (x < 0 || x >= M || y < 0 || y >= N)
					continue;

				// 상
				if (d.y == -1 && d.x == 0 && (map[y][x] == 1 || map[y][x] == 2 || map[y][x] == 5 || map[y][x] == 6) && !queue.contains(new Point(x, y))) {
					queue.add(new Point(x, y));
					res++;
					continue;
				}

				// 하
				if (d.y == 1 && d.x == 0 && (map[y][x] == 1 || map[y][x] == 2 || map[y][x] == 4 || map[y][x] == 7) && !queue.contains(new Point(x, y))) {
					queue.add(new Point(x, y));
					res++;
					continue;
				}

				// 좌
				if (d.y == 0 && d.x == -1 && (map[y][x] == 1 || map[y][x] == 3 || map[y][x] == 4 || map[y][x] == 5) && !queue.contains(new Point(x, y))) {
					queue.add(new Point(x, y));
					res++;
					continue;
				}

				// 우
				if (d.y == 0 && d.x == 1 && (map[y][x] == 1 || map[y][x] == 3 || map[y][x] == 6 || map[y][x] == 7) && !queue.contains(new Point(x, y))) {
					queue.add(new Point(x, y));
					res++;
					continue;
				}

			}
			
			map[p.y][p.x] = 0;
		}
	}
}
