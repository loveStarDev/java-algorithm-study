package com.ssafy.algorithm;

public class kakao_keypad {
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(s.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
	}
}


/**
* 전략
* 1,4,7은 무조건 왼손 / 3, 6, 9는 무조건 오른손
* 0, 2, 5, 8 을 사용할 땐 현재 위치에서 가까운 엄지로 => 검사
* 만약 엄지 거리가 같다면 hand 손이 우선
*/

class point{
	int x;
	int y;
	
	public point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Solution3 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        point leftHandLoc = new point(0, 3);
        point rightHandLoc = new point(2, 3);
        
        for (int i = 0; i < numbers.length; i++) {
			switch(numbers[i]) {
			case 1: 
			case 4: 
			case 7:
				answer += "L";
				leftHandLoc.x = 0;
				leftHandLoc.y = numbers[i] / 3;
				break;
			case 3:
			case 6:
			case 9:
				answer += "R";
				rightHandLoc.x = 2;
				rightHandLoc.y = numbers[i] / 4;
				break;
			case 0:
				point tempP1 = new point(1, 3);
				int leftD = twoPointDis(leftHandLoc, tempP1);
				int rightD = twoPointDis(rightHandLoc, tempP1);
				if(leftD>rightD) {
					answer += "R";
					rightHandLoc = tempP1;
				}else if(leftD < rightD) {
					answer += "L";
					leftHandLoc = tempP1;
				}else {
					if(hand.equals("right")) {
						answer += "R";
						rightHandLoc = tempP1;
					}
					else {
						answer += "L";
						leftHandLoc = tempP1;
					}
				}
				break;
			case 2:
			case 5:
			case 8:
				point tempP2 = new point(1, numbers[i]/3);
				int leftD1 = twoPointDis(leftHandLoc, tempP2);
				int rightD1 = twoPointDis(rightHandLoc, tempP2);
				if(leftD1>rightD1) {
					answer += "R";
					rightHandLoc = tempP2;
				}else if(leftD1 < rightD1) {
					answer += "L";
					leftHandLoc = tempP2;
				}else {
					if(hand.equals("right")) {
						answer += "R";
						rightHandLoc = tempP2;
					}
					else {
						answer += "L";
						leftHandLoc = tempP2;
					}
				}
				break;
			}
		}
        
        return answer;
    }
    
    public int twoPointDis(point p1, point p2){
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y - p2.y);
    }
}
