package com.ssafy.algorithm.boj_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static int N, M;

	public static class Point {
		int x, y, d, drill;

		public Point(int x, int y, int d, int drill) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.drill = drill;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// 입력받기
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2];

		queue.add(new Point(0, 0, 1, 0));

		visited[0][0][0] = true;
		visited[0][0][1] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			// 목적지에 도착하였으면 종료
			if (p.x == M - 1 && p.y == N - 1) {
				System.out.println(p.d);
				return;
			}

			// 상하좌우 탐색
			for (int k = 0; k < 4; k++) {
				int xx = p.x + dx[k];
				int yy = p.y + dy[k];

				if (xx < 0 || xx >= M || yy < 0 || yy >= N) continue;

				if (map[yy][xx] == 1) {
					if (p.drill == 0 && !visited[yy][xx][1]) {
						queue.add(new Point(xx, yy, p.d + 1, 1));
						visited[yy][xx][1] = true;
					}
				} else {
					if (!visited[yy][xx][p.drill]) {
						queue.add(new Point(xx, yy, p.d + 1, p.drill));
						visited[yy][xx][p.drill] = true;
					}
				}
			}
		}

		System.out.println(-1);
	}
}
