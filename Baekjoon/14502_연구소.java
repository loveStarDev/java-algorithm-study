package com.ssafy.algorithm.boj_14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int[][] map;
	static Stack<point> stack = new Stack<point>();
	static int[] dy = { -1,1,0,0 };
	static int[] dx = { 0,0,-1,1 };
	
	public static class point{
		int x, y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int result = 0;
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		// 입력받기
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					stack.add(new point(j,i));
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				int[][] temp = deepCopy(map);
				
				if(temp[i][j] == 0) {
					temp[i][j] = 1; // 첫번째 벽 세우기
					
					for (int i2 = 0; i2 < H; i2++) {
						for (int j2 = 0; j2 < W; j2++) {
							int[][] temp2 = deepCopy(temp);
							
							if(temp2[i2][j2] == 0) {
								temp2[i2][j2] = 1; // 두번째 벽 세우기
								
								for (int i3 = 0; i3 < H; i3++) {
									for (int j3 = 0; j3 < W; j3++) {
										int[][] temp3 = deepCopy(temp2);
										
										if(temp3[i3][j3] == 0) {
											temp3[i3][j3] = 1; // 세번째 벽 세우기
											
											for (int k = 0; k < stack.size() ; k++) {
												point p = stack.get(k);
												
												DFS(p.x, p.y, temp3);
											}
											
											int cnt = 0;
											for (int k = 0; k < temp3.length; k++) {
												for (int k2 = 0; k2 < temp3[0].length; k2++) {
													if(temp3[k][k2] == 0)
														cnt++;
												}
											}
											
											if(result < cnt)
												result = cnt;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void DFS(int x, int y, int[][] temp) {
		temp[y][x] = 2;
		
		for (int i = 0; i < dx.length; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(!isWall(xx, yy) && temp[yy][xx] == 0)
				DFS(xx, yy, temp);
		}
		
	}

	public static int[][] deepCopy(int[][] org){
		int[][] temp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = org[i][j];
			}
		}
		
		return temp;
	}
	
	public static boolean isWall(int x, int y) {
		if(x>=0 && x < W && y>=0 && y< H)
			return false;
		return true;
	}
}
