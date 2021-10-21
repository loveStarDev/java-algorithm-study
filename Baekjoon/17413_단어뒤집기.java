package com.ssafy.algorithm.boj_17413_단어뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>(); 
		String s = br.readLine();
		boolean tri = false;
		
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if(tri) {
				if(s.charAt(i) != '>')
					result += s.charAt(i);
				else {
					result += '>';
					tri = false;
				}
				
				continue;
			}
			
			if(s.charAt(i)== '<') {
				
				while(!stack.isEmpty()) {
					result += stack.pop();
				}
				
				tri = true;
				result += '<';
			}
			
			else if(s.charAt(i) == ' ' && !stack.isEmpty()) {
				while(!stack.isEmpty()) {
					result += stack.pop();
				}
				
				result += ' ';
			}
			
			else {
				stack.add(s.charAt(i));
			}
		}
		
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.print(result);
	}
}
