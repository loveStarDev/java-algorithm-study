package com.ssafy.algorithm.swexpert_1259_금속막대;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static public ArrayList<Point> arr;
	static public ArrayList<Point> arr2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr = new ArrayList<>();
			arr2 = new ArrayList<>();
			// 입력받기
			for (int i = 0; i < N; i++) {
				Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				arr.add(p);
				arr2.add(p);
			}
			
			// 첫째 찾기
			Point now = null;
			for (int i = 0; i < arr2.size(); i++) {
				boolean find = false;
				now = arr2.get(i);
				
				for (int j = 0; j < arr2.size(); j++) {
					if(now.x == arr2.get(j).y) {
						find = true;
						break;
					}
				}
				
				if(!find)
					break;		
			}
			
			arr.remove(now);
			System.out.print("#"+tc+" "+now.x+" "+now.y+" ");
			while(!arr.isEmpty()) {
				for (int i = 0; i < arr.size(); i++) {
					if(now.y == arr.get(i).x) {
						now = arr.remove(i);
						break;
					}
				}
				System.out.print(now.x + " " + now.y + " ");
			}
			System.out.println();
		}
	}
}
