package com.ssafy.algorithm.kakao2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	Queue<Double> q = new LinkedList<Double>();

	public int solution(int n, int k) {
		int result = -1;

		// 진수 변환
		StringBuilder sb = new StringBuilder();
		if (n == 0)
			sb.insert(0, '0');
		while (n != 0) {
			long r = n % k;
			sb.insert(0, r);
			n /= k;
		}

		// 소수찾기
		StringTokenizer st = new StringTokenizer(sb.toString(), "0");
		while (st.countTokens() > 0) {
			double num = Double.parseDouble(st.nextToken());
			if (num > 1 && isPrime(num)) {
				q.add(num);
			}
		}
		result = q.size();

		return result;
	}

	public boolean isPrime(double num) {
		int cnt = 0;
		for (cnt = 2; cnt <= Math.sqrt(num); cnt++) {
			if ((num % cnt) == 0) {
				return false;
			}
		}
		return true;
	}
}
