package com.ssafy.algorithm.swexpert_7236_저수지의물의총깊이구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static public int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
	static public int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			// 입력받기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			// 깊이 찾기
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'G')
						continue;
					
					int temp = 0;
					for (int k = 0; k < dx.length; k++) {
						if(!isWall(i+dy[k], j+dx[k]) && map[i+dy[k]][j+dx[k]] == 'W') {
							temp++;
						}
					}
					
					if(result < temp)
						result = temp;
				}
			}
			
			if(result == 0)
				result = 1;
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static boolean isWall(int y, int x) {
		if(y >= 0 && y < N && x >= 0 && x < N)
			return false;		
		return true;
	}

}
