package algorithm.programmers.level2;

/**
 * 프로그래머스 LV2
 * DFS
 * 게임 맵 최단거리
 */

/**
 * 1. 총 몇개의 칸을 거치는 지 (시작지점 포함)
 *
 * 오답
 */
public class Shortcut {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min;
    public int solution(int[][] maps) {
        min = -1;
        dfs(maps, 0, 0, 1);
        return min;
    }

    private void dfs(int[][] maps, int x, int y, int cnt) {
        if(x == maps.length - 1 && y == maps[x].length - 1) {   //목적지 도착 시
            if(min == -1) {                                     //최초 도착 시
                min = cnt;
                return;
            }
            min = Math.min(min, cnt);                          //2번째 도착부터
            return;
        }
        int nx, ny;
        for(int i = 0; i < 4; i++) {                            //4방향 탐색
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[nx].length) continue;
            if(maps[nx][ny] == 0) continue;

            maps[nx][ny] = 0;                                   //기록
            dfs(maps, nx, ny, cnt + 1);
            maps[nx][ny] = 1;
        }
    }
}
