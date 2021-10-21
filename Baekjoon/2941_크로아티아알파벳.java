package com.ssafy.algorithm.boj_2941_크로아티아알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		
		String s = br.readLine();
		String[] table = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < table.length; i++) {
			while(s.contains(table[i])) {
				result++;
 				s = s.replaceFirst(table[i], "!");
			}
		}
		
		s = s.replace("!", "");
		
		result += s.length();
		
		System.out.println(result);
	}
}
