package swexpert_1244_최대상금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] num;
	static int N;
	static int C;
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			String temp = Integer.toString(n);
			N = temp.length();
			num = new int[N];
			
			for (int i = 0; i < temp.length(); i++) {
				num[i] = temp.charAt(i) - '0';
			}
			
			if(C > N) { 
				if(C%2 == 0)C = N;
				else C = N+1;
			}
			
			dfs(0);
			System.out.println("#"+tc+" "+res);
		}
	}

	private static void dfs(int d) {
		if(d==C) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				temp *= 10;
				temp += num[i];
			}
			res = res > temp ? res : temp;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				
				dfs(d+1);
				
				num[j] = num[i];
				num[i] = temp;
			}
		}
	}
}
