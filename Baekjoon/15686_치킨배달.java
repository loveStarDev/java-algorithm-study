package com.ssafy.algorithm.boj_15686_치킨배달;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, res = Integer.MAX_VALUE;
	static ArrayList<Point> shop = new ArrayList<Point>();
	static ArrayList<Point> home = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 2)
					shop.add(new Point(j, i));
				if (value == 1)
					home.add(new Point(j, i));
			}
		}
		visited = new boolean[shop.size()];

		DFS(0, 0);

		System.out.println(res);
	}

	private static void DFS(int idx, int size) {
		if (size == M) {
			int dis = 0;
			for (int i = 0; i < home.size(); i++) {
				Point h = home.get(i);
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < shop.size(); j++) {
					if (visited[j]) {
						Point s = shop.get(j);
						int temp = Math.abs(h.x - s.x) + Math.abs(h.y - s.y);
						min = Math.min(min, temp);
					}
				}
				dis += min;
			}

			res = Math.min(dis, res);
			return;
		}

		for (int i = idx; i < shop.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(i, size + 1);
				visited[i] = false;
			}
		}
	}
}
