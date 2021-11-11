package com.ssafy.algorithm.boj_14395_4연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int s, t;
	static String[] dr = {"*", "+", "-", "/"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		if (s == t) {
			System.out.println(0);
			return;
		}

		bfs();
		System.out.println(-1);
	}

	private static void bfs() {
		Set<Long> set = new HashSet<Long>();
		
		Queue<AbstractMap.SimpleEntry<Long, String>> q = new LinkedList<>();
		q.add(Pair(Long.valueOf(s), ""));
		set.add(Long.valueOf(s));

		while (!q.isEmpty()) {
			if (q.peek().getKey() == t) {
				System.out.println(q.peek().getValue());
				System.exit(0);
			}

			AbstractMap.SimpleEntry<Long, String> m = q.poll();
			Long k = m.getKey();

			for(int i = 0; i < 4; i++) {
				Long value = check(i, k);
				if(value < 1) continue;
				if(set.contains(value)) continue;
				set.add(value);
				q.add(Pair(value, m.getValue() + dr[i]));
			}
		}
	}
	
	static Long check(int i, Long v) {
		if(i == 0) return v*v;
		else if(i==1) return v+v;
		else if(i==2) return v-v;
		else return v/v;
	}

	static AbstractMap.SimpleEntry<Long, String> Pair(Long a, String b) {
		return new AbstractMap.SimpleEntry<Long, String>(a, b);
	}
}
