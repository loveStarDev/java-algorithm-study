package com.ssafy.algorithm.swexpert_10912_외로운문자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;

		while (tc++ < T) {
			StringBuilder sb = new StringBuilder(br.readLine());

			for (int i = 0; i < sb.length() - 1; i++) {
				int loc = sb.lastIndexOf(Character.toString(sb.charAt(i)));
				if(loc != i) {
					sb.deleteCharAt(loc);
					sb.deleteCharAt(i);
					i = -1;
				}
			}
			
			char[] result = (sb.toString()).toCharArray();
			Arrays.sort(result);
			
			
			if(sb.length() == 0)
				result = "Good".toCharArray();
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		}
	}
}
