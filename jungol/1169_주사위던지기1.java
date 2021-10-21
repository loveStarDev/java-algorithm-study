package com.ssafy.algorithm.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 던진 횟수
		M = Integer.parseInt(st.nextToken()); // 던지는 방법

		arr = new int[N];
		visited = new boolean[7];

		if (M == 1) {
			solution1(0);
		} else if (M == 2) {
			solution2(0, 1);
		} else {
			solution3(0);
		}
	}

	private static void solution3(int n) {
		if (n == N) {
			printdice();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[n] = i;
				solution3(n + 1);
				visited[i] = false;
			}
		}
	}

	private static void solution2(int n, int s) {
		if (n == N) {
			printdice();
			return;
		}

		for (int i = s; i <= 6; i++) {
			arr[n] = i;
			solution2(n + 1, i);
		}
	}

	private static void solution1(int n) {
		if (n == N) {
			printdice();
			return;
		}

		for (int i = 1; i <= 6; i++) {
			arr[n] = i;
			solution1(n + 1);
		}
	}

	private static void printdice() {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
}
