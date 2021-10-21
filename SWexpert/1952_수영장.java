/**
 * 중복순열문제
 */
package com.ssafy.algorithm.swexpert_1952_수영장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] tPrice = new int[4]; // 0: 1d, 1: 1m, 2: 3m, 4: 1y	
	static int[] plan = new int[13];
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {		
			res = Integer.MAX_VALUE;
			
			// 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				tPrice[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1,0);
			
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void dfs(int month, int money) {
		if(month > 12) {
			res = Math.min(res, money);
			return;
		}
		
		if(plan[month] == 0) {
			dfs(month+1, money);
		}else {
			// 1일권으로 모두 계산
			dfs(month+1, money + tPrice[0] * plan[month]);
			
			// 1달권으로 모두 계산
			dfs(month+1, money + tPrice[1]);
		}
		
		//3달권을 사용하여 계산
		if(month+3 <= 15) {
			dfs(month+3, money+tPrice[2]);
		}
		
		//1년권을 사용하여 계산
		if(month == 1) {
			dfs(month+12, money+tPrice[3]);
		}
	}
}
