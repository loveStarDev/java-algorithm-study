package com.ssafy.algorithm.boj_11721_열개씩끊어출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			if((i+1)%10 == 0) {
				System.out.println(s.charAt(i));
			}else {
				System.out.print(s.charAt(i));
			}
		}
	}
}
