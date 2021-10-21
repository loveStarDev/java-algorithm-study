package com.ssafy.algorithm.swexpert_1948_날짜계산기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		while (tc++ < T) {
			int result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			
			while(m1 != m2) {
				result += arr[m1++] - d1;
				d1 = 0;
			}
			if(result != 0)
				result++;
			
			result += d2;
						
			System.out.println("#" + tc + " " + result);			
		}
	}
}
