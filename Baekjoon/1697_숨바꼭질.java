package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        if(N >= K)
            System.out.println(N-K);
        else
            System.out.println(bfs(N, K));
    }
 
    static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] status = new int[100001];
 
        q.offer(n);
        status[n] = 1;
 
        while(!q.isEmpty()) {
            int now = q.poll();
 
            for(int i=0; i<3; i++) {
                int next;
 
                if(i == 0)
                    next = now - 1;
                else if(i == 1)
                    next = now + 1;
                else
                    next = now * 2;
 
                if(next == k)
                    return status[now];                
 
                if(0 <= next && next <= 100000) {
                    if(status[next] == 0) {
                        q.offer(next);
                        status[next] = status[now] + 1;
                    }
                }
            }
        }
 
        return 0;
    }
}
