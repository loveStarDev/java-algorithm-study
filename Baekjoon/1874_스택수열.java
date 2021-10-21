package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<Integer>();

		String res = "";
		int i = 1;

		int N = Integer.parseInt(br.readLine());

		for (int j = 0; j < N; j++) {
			queue.add(Integer.parseInt(br.readLine()));
		}

		while (!queue.isEmpty()) {
			if (!stack.isEmpty() && stack.peek() == queue.peek()) {
				stack.pop();
				queue.poll();
				res += "-\n";
			} else if (i <= queue.peek()) {
				while (i <= queue.peek()) {
					stack.add(i++);
					res += "+\n";
				}
			} else {
				res = "NO";
				break;
			}
		}

		System.out.print(res);
	}
}
