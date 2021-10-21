package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class printContent{
	int order, priority, done;
	
	public printContent(int order, int priority) {
		super();
		this.order = order;
		this.priority = priority;
	}
}

public class BOJ_1966_프린터큐 {	
	static List<printContent> q = new LinkedList<printContent>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int TC = 0;
		
		while(TC++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			printContent target = null;
			
			// 입력받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				printContent pc = new printContent(i, Integer.parseInt(st.nextToken()));
				q.add(pc);
				
				if(i == M)
					target = pc;
			}
			
			
			int done = 1;
			
            while(!q.isEmpty()) {
                int p = q.get(0).priority;
                for(int i = 0; i < q.size(); i++) {
                    if(q.get(i).priority > p) {
                        q.add(q.get(0));
                        q.remove(0);
                        break;
                    }

                    if(i == q.size() - 1) {
                        q.get(0).done = done++;
                        q.remove(0);
                    }
                }
            }
            System.out.println(target.done);
		}
	}
}
