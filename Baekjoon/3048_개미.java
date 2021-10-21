package com.ssafy.algorithm.boj_3048_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] dir = new int[A+B];
		
		char[] result = new char[A+B];
		
		String temp = br.readLine();
		
		int ii = 0;
		for (int i = A-1; i >= 0; i--) {
			result[ii] = temp.charAt(i);
			dir[i] = -1;
			ii++;
		}
		
		temp = br.readLine();

		for (int i = 0; i < B; i++) {
			result[ii] = temp.charAt(i);
			ii++;
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			
			char[] tempC = result.clone();
			int[] tempDD = dir.clone();
			
			for (int j = 0; j < result.length - 1; j++) {
				if(dir[j] == -1 && dir[j] != dir[j+1]) {
					int tempD = tempDD[j];
					tempDD[j] = tempDD[j+1];
					tempDD[j+1] = tempD;
					
					char tempS = tempC[j];
					tempC[j] = tempC[j+1];
					tempC[j+1] = tempS;
				}
			}
			
			result = tempC;
			dir = tempDD;
		}
		
		System.out.println(result);
	}
}
