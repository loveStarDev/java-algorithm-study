package com.ssafy.algorithm.swexpert_1204_최빈수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			int[] scores = new int[101];
			
			int res = 0;
			int max = 0;
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			for(int i = 0 ; i < 1000 ; i++) {
				int s = Integer.parseInt(st.nextToken());
				scores[s]++;
				
				if(max < scores[s]) {
					max = scores[s];
					res = s;
				}else if(max == scores[s] && res < s) {
					res = s;
				}
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
}
