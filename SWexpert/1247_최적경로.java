package com.ssafy.algorithm.swexpert_1247_최적경로;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int T, N, result;
    static Point customers[], Org, Home;
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            customers = new Point[N];
            visited = new boolean[N];
            
            Org = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < N; i++) 
                customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            result = Integer.MAX_VALUE;
            process(0, Org, 0);
            
            System.out.println("#" + tc + " " + result);
        }
    }
    
    public static void process(int cnt, Point prev, int dist) {
        if(dist >= result) return;
        if(cnt == N) {
            dist += Math.abs(prev.x - Home.x) + Math.abs(prev.y - Home.y);
            result = Math.min(result, dist);
        }
        
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                process(cnt + 1, customers[i], dist + Math.abs(prev.x - customers[i].x) + Math.abs(prev.y - customers[i].y));
                visited[i] = false;
            }
        }
    }
 
}
