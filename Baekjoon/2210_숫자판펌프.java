package com.ssafy.algorithm.boj_2210_숫자판펌프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[5][5];
	static Stack<String> stack = new Stack<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(0, Integer.toString(map[i][j]), j, i);
			}
		}
		
		System.out.println(stack.size());
	}
	
	public static void dfs(int len, String num, int x, int y) {
		if(len == 5) {
			//System.out.println(num);
			if(!stack.contains(num)) stack.add(num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if( xx < 0 || xx >= 5 || yy < 0 || yy >= 5) continue;
			
			dfs(len+1, num+map[yy][xx], xx , yy);
		}
	}
}
