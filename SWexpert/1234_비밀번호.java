package com.ssafy.algorithm.swexpert_1234_비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 0;

		while (T++ < 10) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder(st.nextToken());
			boolean tri = false;

			while (!tri) {
				for (int i = 0; i < sb.length(); i++) {
					if (i == sb.length() - 1) {
						tri = true;
						break;
					}

					if (sb.charAt(i) == sb.charAt(i + 1)) {
						sb.delete(i, i+2);
						i = 0;
						if (sb.charAt(i) == sb.charAt(i + 1)) {
							sb.delete(i, i+2);
						}
					}
				}
			}
			
			System.out.printf("#%d %s\n", T, sb);
		}
	}
}
