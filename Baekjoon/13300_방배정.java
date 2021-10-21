package com.ssafy.algorithm.boj_13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int result = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 학생 수
		int sCnt = Integer.parseInt(st.nextToken());
		// 최대인원 수
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[2][7];
		
		// 입력받기
		for (int i = 0; i < sCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			students[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		
		for (int i = 0; i < students.length; i++) {
			for (int j = 1; j < students[0].length; j++) {
				result += students[i][j]/K;
				if(students[i][j]%K>0)
					result += 1;
			
			}
		}
		
		System.out.println(result);
	}
}
