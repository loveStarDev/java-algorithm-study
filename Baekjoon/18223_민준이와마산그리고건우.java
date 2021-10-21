/**
 * 다익스트라
 */
package com.ssafy.algorithm.boj_18223_민준이와마산그리고건우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<chainEdge>[] link;
	static int V, E, P;
	
	public static class chainEdge implements Comparable<chainEdge>{
		int nv, value;
		
		public chainEdge(int nv, int value) {
			super();
			this.nv = nv;
			this.value = value;
		}

		@Override
		public int compareTo(chainEdge o) {
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		link = new LinkedList[V+1];
		
		for (int i = 1; i <= V; i++) {
			link[i] = new LinkedList<chainEdge>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			link[v1].add(new chainEdge(v2, value));
			link[v2].add(new chainEdge(v1, value));
		}
		
		int san = dst(1, V);
		int woo = dst(1, P) + dst(P, V);
		
//		System.out.printf("%d %d", san, woo);
		
		if(woo <= san) System.out.print("SAVE HIM");
		else System.out.print("GOOD BYE");
	}

	private static int dst(int start, int end) {
		int[] values = new int[V+1];
		Arrays.fill(values, Integer.MAX_VALUE);
		values[start] = 0;
		
		PriorityQueue<chainEdge> q = new PriorityQueue<chainEdge>();
		q.addAll(link[start]);
		
		while(!q.isEmpty()) {
			chainEdge edge = q.poll();
			if(edge.nv == end) return edge.value;
			
			for(chainEdge e: link[edge.nv] ) {
				if(values[e.nv] >= e.value + edge.value) {
 					values[e.nv] = e.value + edge.value;
					q.add(new chainEdge(e.nv, values[e.nv]));
				}
			}
		}
		return -1;
	}
}
