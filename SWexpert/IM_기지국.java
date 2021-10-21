package com.ssafy.algorithm.swexpert_IM_기지국;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	static public Map<Character, Integer> KV = new HashMap<>();
	static public int[] dy = {-1, 1, 0, 0};
	static public int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		KV.put('A', 1);
		KV.put('B', 2);
		KV.put('C', 3);
		
		while(tc++ < T) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			// 입력받기
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			} 
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] != 'X' && map[i][j] != 'H') {
						int value = KV.get(map[i][j]);
						for (int k = 1; k <= value; k++) {
							for (int q = 0; q < dx.length; q++) {
								int xx = j + dx[q] * k;
								int yy = i + dy[q] * k;
								
								if(xx >= 0 && xx < N && yy >= 0 && yy < N && map[yy][xx] == 'H') {
									map[yy][xx] = 'X';
								}
							}
						}
					}
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] == 'H')
						result++;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}				
	}
}
