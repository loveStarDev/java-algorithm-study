import java.util.*;

class Point{
    public int x, y, dist;
    
    public Point(int y, int x, int dist){
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
    
    public String toString(){
        return "x : " + x + " y : " + y + " dist : " + dist;
    }
}

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(0, 0, maps);
    }
    
    public int bfs(int x, int y, int[][] maps){
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(y, x, 1));
        maps[y][x] = 0;
        
        while(!queue.isEmpty()){
            Point point = queue.poll();            
            if(point.x == m-1 && point.y == n-1) return point.dist;            
            for(int k=0; k<4; k++){
                int xx = point.x + dx[k];
                int yy = point.y + dy[k];
                
                if(xx < 0 || xx >= m || yy < 0 || yy >= n || maps[yy][xx] == 0) continue;
                queue.offer(new Point(yy, xx, point.dist+1));
                maps[yy][xx] = 0;
            }
        }
        
        return -1;
    }
}



// DFS로 풀었지만 효율성에서 0점
// class Solution {
//     int[] dy = {-1, 1, 0, 0};
//     int[] dx = {0, 0, -1, 1};
//     int answer = Integer.MAX_VALUE;
//     int n, m;
    
//     public int solution(int[][] maps) {
//         n = maps.length;
//         m = maps[0].length;
//         dfs(0, 0, 0, maps);
        
//         if(answer == Integer.MAX_VALUE) answer = -1;
        
//         return answer;
//     }
    
//     public void dfs(int x, int y, int dist, int[][] maps){        
//         if(x == m-1 && y == n-1){
//             answer = answer > dist+1 ? dist+1 : answer;
//             return;
//         }
        
//         for(int i = 0; i < 4; i++){
//             int xx = x + dx[i];
//             int yy = y + dy[i];
//             if(xx < 0 || xx >= m || yy < 0 || yy >= n || maps[yy][xx] == 0) continue;
//             maps[y][x] = 0;
//             dfs(xx, yy, dist+1, maps);
//             maps[y][x] = 1;
//         }
//     }
// }
