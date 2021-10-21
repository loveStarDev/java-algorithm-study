package com.ssafy.algorithm.boj_1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] image;
	static int N;
	static String res = "";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		image = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				image[i][j] = sb.charAt(j) - '0';
			}
		}
		
		dq(0,0,N);
		
		System.out.println(res);
	}
	
	public static void dq(int x, int y, int n) {
		if(n == 1) {
			res += Integer.toString(image[y][x]);
			return;
		}
		
		int num = image[y][x];
		
		for (int i = y; i < (y+n>N?N:y+n); i++) {
			for (int j = x; j < (x+n>N?N:x+n); j++) {
				if(image[i][j] != num) {
					res += "(";
					dq(x, y, n/2);
					dq(x+n/2, y, n/2);
					dq(x, y+n/2, n/2);
					dq(x+n/2, y+n/2, n/2);
					res += ")";
					return;
				}
			}
		}
		
		res += Integer.toString(num);
	}
}
