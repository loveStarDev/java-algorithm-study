package com.ssafy.algorithm.swexpert_5603_건초더미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			
			// 입력받기
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sum += arr[i];
			}
			
			int avg = sum / N;
			int result = 0;
			for (int i = 0; i < arr.length; i++) {
				result += Math.abs(avg - arr[i]);
			}
			
			System.out.printf("#%d %d\n", tc, result/2);
		}		
	}
}
