package com.ssafy.algorithm.boj_10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받기
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for (int a = y; a < y+height; a++) {
				for (int b = x; b < x+width; b++) {
					map[a][b] = i;
				}
			}
		}
		
		// 넓이 구하기 BFS
		for (int i = 1; i <= N; i++) {
			System.out.println(checkSize(map, i));
		}
		
	}
	
	public static int checkSize(int[][] map, int p) {
		int size = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == p)
					size++;
			}
		}
		
		return size;
	}
}
