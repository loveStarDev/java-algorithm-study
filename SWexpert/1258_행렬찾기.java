package com.ssafy.algorithm.swexpert_1258_행렬찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static PriorityQueue<point> queue = new PriorityQueue<>();

	static public class point implements Comparable<point> {

		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(point o) {
			int temp1 = x*y;
			int temp2 = o.x*o.y;
			if (temp1 > temp2)
				return 1;
			else if (temp1 == temp2) {
				if(y > o.y)
					return 1;
				else
					return -1;
			}
			else
				return -1;
		}

		@Override
		public String toString() {
			return " " + y + " " + x;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;

		while (tc++ < T) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			// 입력받기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 행렬 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						int a = i;
						int b = j;
						boolean tri = false;
						while (!tri) {
							int temp = 0;
							if (!isWall(a + 1, b) && map[a + 1][b] != 0) {
								a++;
								temp++;
							}
							if (!isWall(a, b + 1) && map[a][b + 1] != 0) {
								b++;
								temp++;
							}
							if(temp == 0)
								tri = true;
						}
						
						for (int k = i; k < a+1; k++) {
							for (int q = j; q < b+1; q++) {
								map[k][q] = 0;
							}
						}
						
						queue.add(new point(b-j+1, a-i+1));
					}
				}
			}
			
			System.out.print("#" + tc + " " + queue.size());
			while(!queue.isEmpty())
				System.out.print(queue.poll());
			System.out.println();

		}
	}

	static public boolean isWall(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return true;
		return false;
	}
}
