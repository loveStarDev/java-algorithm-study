package com.ssafy.algorithm.swexpert_2072_홀수만더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while(tc++ < T) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 != 0) res += num;
			}
			
			System.out.println("#"+tc+" "+res);
		}		
	}	
}
