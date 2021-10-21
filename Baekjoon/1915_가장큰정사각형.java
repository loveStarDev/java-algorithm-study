package com.ssafy.algorithm.boj_1915_가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수정
public class Main {
	static int[][] map;
	static int N, M, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		// 입력받기
		for (int i = 1; i <= N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = sb.charAt(j - 1) - '0';
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 0) {
					int[] arr = new int[3];
					arr[0] = map[i - 1][j];
					arr[1] = map[i][j - 1];
					arr[2] = map[i - 1][j - 1];
					Arrays.sort(arr);

					map[i][j] = arr[0] + 1;

					if (res < map[i][j])
						res = map[i][j];
				}
			}
		}

		System.out.println(res*res);
	}
}

//public class Main {
//	static int[][] map;
//	static int N, M;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		map = new int[N][M];
//		
//		// 입력받기
//		for (int i = 0; i < N; i++) {
//			StringBuilder sb = new StringBuilder(br.readLine());
//			for (int j = 0; j < M; j++) {
//				map[i][j] = sb.charAt(j) - '0';
//			}
//		}
//		
//		int winSize = Math.min(N, M);
//		
//		// 커다란 슬라이딩 윈도우를 만든 후 크기를 줄여가며 확인한다.
//		for (int s = winSize; s > 0; s--) {
//			for (int i = 0; i < N - s; i++) {
//				for (int j = 0; j < M - s; j++) {
//					if(map[i][j] == 1)
//						check(i,j, s);
//				}
//			}
//		}
//		
//		System.out.println(0);
//	}
//
//	private static void check(int y, int x, int size) {
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				if(map[y+i][x+j] == 0)
//					return;
//			}
//		}
//		
//		System.out.println(size*size);
//		System.exit(0);
//	}
//}
