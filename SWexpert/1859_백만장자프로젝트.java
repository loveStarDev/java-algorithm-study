package com.ssafy.algorithm.swexpert_1859_백만장자프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {			
			int days = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[days];
			
			// 입력받기
			for(int i = 0 ; i < days ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long now = arr[days-1];
			long cnt = 0;
			long money = 0l;
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[days-i-1] <= now) {
					cnt++;
					money -= arr[days-i-1];
				}else {
					money += cnt * now;
					cnt = 0;
					now = arr[days-i-1];
				}
			}
			
			if(cnt != 0) {
				money += cnt * now;
			}
			
			System.out.println("#" + tc + " "+ String.valueOf(money));
		}
	}
}
