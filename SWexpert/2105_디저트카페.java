import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dy = {-1, -1, 1, 1};
	static int[] dx = {-1, 1, -1, 1};
	static int[][] map;
//	static boolean[][] visited;
	static boolean[] dt;
	static boolean[] ate;
	static int N;
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T){
			res = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
//			visited = new boolean[N][N];
			ate = new boolean[101];
			dt = new boolean[4];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 한 좌표에서 투어 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if((i==0 && j == 0)||(i==N-1 && j == 0)||(i==0 && j == N-1)||(i==N-1 && j == N-1)) continue;
					for (int k = 0; k < 4; k++) {
						dfs(i, j, i, j, 0, k);
					}
				}
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void dfs(int sy, int sx, int y, int x, int d, int t) {
		if(sy == y && sx == x && d >= 4) {
			res = res > d ? res : d;
			return;
		}
		
//		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int yy = y + dy[i];
			int xx = x + dx[i];

			if(yy < 0 || yy >= N || xx < 0 || xx >= N) continue;
//			if(visited[yy][xx] || ate[map[yy][xx]]) continue;
			if(ate[map[yy][xx]] || dt[i]) continue;
			
			ate[map[yy][xx]] = true;
			if(t == i) {
				dfs(sy,sx,yy,xx,d+1,t);
			}else {
				dt[t] = true;
				dfs(sy,sx,yy,xx,d+1,i);
				dt[t] = false;
			}
			ate[map[yy][xx]] = false;
		}
	}
}
