package com.ssafy.algorithm.boj_14889_스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N];

		// 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		playGame(0, 0);
		System.out.println(result);
	}

	public static void playGame(int idx, int count) {
		if (count == N / 2) {
			// 만약 선수를 다 뽑았다면?
			// 차이 값을 계산한다.
			calcDiff();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				playGame(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	private static void calcDiff() {
		int startTeam = 0, linkTeam = 0;

		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (visited[i] == true && visited[j] == true) startTeam += map[i][j] + map[j][i];
				else if (visited[i] == false && visited[j] == false) linkTeam += map[i][j] + map[j][i];
			}
		}

		int diff = Math.abs(startTeam - linkTeam);
		
		if (diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}
		
		result = Math.min(result, diff);
	}
}
