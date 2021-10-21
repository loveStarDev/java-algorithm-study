package com.ssafy.algorithm.kakao1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {	
	Map<String, Integer> hashMap = new HashMap<>();
	Map<Integer, String> hashMap2 = new HashMap<>();
	
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] cnt = new int[id_list.length];
        int[][] map = new int[id_list.length][id_list.length];

        for (int i = 0; i < id_list.length; i++) {
			hashMap.put(id_list[i], i);
			hashMap2.put(i, id_list[i]);
		}
        
        for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);
			String a = st.nextToken();
			String b = st.nextToken();
			
			if(map[hashMap.get(a)][hashMap.get(b)] == 0) {
				map[hashMap.get(a)][hashMap.get(b)] = 1;
				cnt[hashMap.get(b)]++;
			}
		}
        
        for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] >= k) {				
				for (int j = 0; j < map.length; j++) {
					if(map[j][i] == 1) {
						answer[j]++;
					}
				}
			}
		}

        return answer;
    }
}
