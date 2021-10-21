package com.ssafy.algorithm.boj_2448_별찍기11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		map = new char[N][N * 2 - 1];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N * 2 - 1; j++)
				map[i][j] = ' ';

		dq(N, N - 1, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void dq(int n, int x, int y) {
		if (n == 3) {
			map[y][x] = '*';
			map[y + 1][x - 1] = map[y + 1][x + 1] = '*';
			map[y + 2][x - 2] = map[y + 2][x - 1] = map[y + 2][x] = map[y + 2][x + 1] = map[y + 2][x + 2] = '*';
			return;
		}

		int div = n / 2;

		dq(div, x, y);
		dq(div, x - (div), y + (div));
		dq(div, x + (div), y + (div));
	}
}
