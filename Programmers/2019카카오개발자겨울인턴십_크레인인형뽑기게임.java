import java.util.*;

class Solution {
    
    public Stack<Integer> stack = new Stack<Integer>();
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        for(int k : moves){
            
            for(int i = 0; i < board[0].length; i++){
                int temp = board[i][k-1];
                if(temp != 0){
                    if(!stack.isEmpty() && stack.peek() == temp){
                        stack.pop();
                        answer += 2;
                        board[i][k-1] = 0;
                        break;
                    }
                    stack.add(temp);
                    board[i][k-1] = 0;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}
