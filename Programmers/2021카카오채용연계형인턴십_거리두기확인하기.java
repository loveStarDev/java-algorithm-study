public class Solution {
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public int[] solution(String[][] places) {
		int[] answer = { 1, 1, 1, 1, 1 };

		for (int i = 0; i < places.length; i++) {
			char[][] map = new char[5][5];

			for (int a = 0; a < map.length; a++) {
				for (int b = 0; b < map.length; b++) {
					map[a][b] = places[i][a].charAt(b);
				}
			}

			boolean tri = false;
			for (int a = 0; a < map.length; a++) {
				for (int b = 0; b < map[0].length; b++) {
					if (map[a][b] == 'P') {

						// 4방향 검색
						for (int k = 0; k < 4; k++) {
							int xx = b + dx[k];
							int yy = a + dy[k];

							if (xx >= 0 && xx < 5 && yy >= 0 && yy < 5 && map[yy][xx] == 'P') {
								answer[i] = 0;
								tri = true;
								break;
							}
						}

						if (tri)
							break;

						// 4방 2배 탐색
						for (int k = 0; k < 4; k++) {
							if (b + (dx[k] * 2) >= 0 && b + (dx[k] * 2) < 5 && a + (dy[k] * 2) >= 0
									&& a + (dy[k] * 2) < 5) {
								if (map[a + dy[k]][b + dx[k]] == 'O' && map[a + (dy[k] * 2)][b + (dx[k] * 2)] == 'P') {
									answer[i] = 0;
									tri = true;
									break;
								}
							}
						}

						if (tri)
							break;

						// 대각선 검색
						for (int k = 4; k < 8; k++) {
							int xx = b + dx[k];
							int yy = a + dy[k];
							if (xx >= 0 && xx < 5 && yy >= 0 && yy < 5) {
								if (map[yy][xx] == 'P') {
									if (map[yy - dy[k]][xx] != 'X' || map[yy][xx - dx[k]] != 'X') {
										answer[i] = 0;
										tri = true;
										break;
									}
								}
							}
						}
					}

					if (tri)
						break;
				}
				if (tri)
					break;
			}
		}

		return answer;
	}
}
