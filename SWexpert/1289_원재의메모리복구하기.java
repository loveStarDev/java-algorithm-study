package com.ssafy.algorithm.swexpert_1289_원재의메모리복구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			StringBuilder num = new StringBuilder(br.readLine());
			int now = 0;
			int result = 0;
			
			for (int i = 0; i < num.length(); i++) {
				if(num.charAt(i)-'0' != now) {
					result++;
					now = num.charAt(i)-'0';
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
