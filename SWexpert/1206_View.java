package com.ssafy.algorithm.swexpert_1206_view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] building;
	static int N;
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		int tc = 0;
		
		while(tc++ < T) {
			res = 0;
			N = Integer.parseInt(br.readLine());
			building = new int[N];
			
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			
			calc();
			
			System.out.println("#"+tc+" "+res);
		}
	}

	private static void calc() {
		
		for (int i = 2; i < building.length-2; i++) {
			// 조명권이 아예 확보되지 않는 경우
			if((building[i-2] >= building[i]) || (building[i+2] >= building[i])) continue;
			if((building[i-1] >= building[i]) || (building[i+1] >= building[i])) continue;
			
			int[] temp = new int[4];
			temp[0] = building[i-2];
			temp[1] = building[i-1];
			temp[2] = building[i+2];
			temp[3] = building[i+1];
			Arrays.sort(temp);
			
			res += building[i] - temp[3];
		}
		
	}
}
