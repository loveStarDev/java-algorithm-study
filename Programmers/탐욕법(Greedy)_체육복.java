import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 전체 학생 수 - lost 갯수 + lost 돌면서 reserve에서 받을 수 있는 친구들
        
        answer = n - lost.length;
        
        // 만약 자기가 잃어버렸다면 자기것이 있는지 확인한다.
        for(int i = 0 ; i < lost.length; i++){
            int cur = lost[i];
            for(int j = 0 ; j < reserve.length; j++){
                if(cur == reserve[j]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++;
                }
            }
        }
        
        // 없다면 빌릴 수 있는지 확인한다.
        for(int i = 0 ; i < lost.length; i++){
            if(lost[i] == -1)
                continue;
            
            int cur = lost[i];
            
            for(int j = 0 ; j < reserve.length; j++){
                // 왼쪽 번호 친구
                if(cur - 1 == reserve[j]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++;
                    break;
                }
                
                // 오른쪽 번호 친구
                if(cur + 1 == reserve[j]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
