package com.ssafy.algorithm.swexpert_4008_숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] oper = new int[4]; // 순서 : + - * / 
	static int[] nums;
	static int min, max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++<T) {
			min = Integer.MAX_VALUE;
			max = -Integer.MAX_VALUE;
			
			int N = Integer.parseInt(br.readLine());
			nums = new int[N];
			
			// 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			} 
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, nums[0]);
			
			System.out.println("#"+tc+" "+Math.abs(max-min));
		}
	}
	
	private static void dfs(int idx, int num) {
		
		if(idx >= nums.length-1) {
			if(max < num)
				max = num;
			if(min > num)
				min = num;
			return;
		}
		
		// +
		if(oper[0] > 0) {
			oper[0]--;
			int temp = num + nums[idx+1];
			dfs(idx+1, temp);
			oper[0]++;
		}
		
		// -
		if(oper[1] > 0) {
			oper[1]--;
			int temp = num - nums[idx+1];
			dfs(idx+1, temp);
			oper[1]++;
		}
		
		// *
		if(oper[2] > 0) {
			oper[2]--;
			int temp = num * nums[idx+1];
			dfs(idx+1, temp);
			oper[2]++;
		}
		
		// /
		if(oper[3] > 0) {
			oper[3]--;
			int temp = num / nums[idx+1];
			dfs(idx+1, temp);
			oper[3]++;
		}
	}
}
