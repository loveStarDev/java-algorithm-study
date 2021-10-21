package com.ssafy.algorithm.boj_2477_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int largeWidth = 0;
		int largeHeight = 0;
		int largeWI = 0;
		int largeHI = 0;
		int[] arr = new int[6];
		
		// 입력받기
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			arr[i] = dis;
			if(dir < 3 && dis > largeWidth) {largeWidth = dis; largeWI = i;}
			else if(dir >= 3 && dis > largeHeight) {largeHeight = dis; largeHI = i;}
		}
		
		
		// 빈공간 빼주기
		int smallWidth = 0;
		if(largeWI == 0) smallWidth = Math.abs(arr[1] - arr[5]);
		else if(largeWI == 5) smallWidth = Math.abs(arr[0] - arr[4]);
		else smallWidth = Math.abs(arr[largeWI-1] - arr[largeWI+1]);
		
		int smallHeight = 0;
		if(largeHI == 0) smallHeight = Math.abs(arr[1] - arr[5]);
		else if(largeHI == 5) smallHeight = Math.abs(arr[0] - arr[4]);
		else smallHeight = Math.abs(arr[largeHI-1] - arr[largeHI+1]);
		
		System.out.println((largeHeight * largeWidth - smallHeight * smallWidth)*K);
	}
}
