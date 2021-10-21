package com.ssafy.algorithm.kakao3;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	PriorityQueue<record> list = new PriorityQueue<record>();
	
	class record implements Comparable<record>{
		int start, end, sum;
		String num;
		
		public record(String num, String start) {
			this.num = num;
			this.start = transToMin(start);
			this.end = 1439;
			this.sum = 0;
		}
		
		private int transToMin(String start2) {
			StringTokenizer st = new StringTokenizer(start2, ":");
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			return h*60+m;
		}

		public void setEnd(String end, int[] fees) {			
			sum += transToMin(end) - start;
			this.start = 1439;
			this.end = 1439;
		}

		@Override
		public int compareTo(record o) {
			return this.num.compareTo(o.num);
		}

		@Override
		public String toString() {
			return "record [start=" + start + ", end=" + end + ", num=" + num + ", sum=" + sum + "]";
		}
	}
	
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        System.out.println(records.length);
        for (int i = 0; i < records.length; i++) {
        	
			StringTokenizer st = new StringTokenizer(records[i]);
			String time = st.nextToken();
			String num = st.nextToken();
			String status = st.nextToken();
			
			System.out.printf("%d %d %s %s %s\n",i,records.length, time, num, status);

			if(status.equals("IN")) {
				boolean tri = false;
				
				for (record r : list) {
					if(r.num.equals(num)) {
						tri = true;
						r.start = r.transToMin(time);
						break;
					}
				}
				
				if(tri) {
					continue;
				}else {
					list.add(new record(num, time));
					continue;
				}
				
				
			}
			if(status.equals("OUT")) {
					System.out.println("Q");
				for (record r : list) {
					if(r.num.equals(num)) {
						r.setEnd(time, fees);
					}
				}
			}
		}
        
        answer = new int[list.size()];
        
        int i = 0;
        while(!list.isEmpty()){
        	record r = list.poll();
        	System.out.println(r);
			int mins = r.sum + (r.end - r.start);
			if(mins <= fees[0]) answer[i] = fees[1];
			else {
				System.out.println(Math.ceil((((double)mins-fees[0])/(double)fees[2])));
				answer[i] = (int) (fees[1] + Math.ceil((((double)mins-fees[0])/(double)fees[2])) * fees[3]);  
			}
			i++;
		}
        
        return answer;
    }
}
