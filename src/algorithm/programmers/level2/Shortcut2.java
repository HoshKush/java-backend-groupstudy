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
public class Shortcut2 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        Shortcut2 s = new Shortcut2();
        s.solution(maps);
    }
    public int solution(int[][] maps) {
        dfs(maps, 0, 0);
        return maps[maps.length - 1][maps[0].length - 1];
    }

    private void dfs(int[][] maps, int x, int y) {
        if(x == maps.length - 1 && y == maps[x].length - 1) return;
        int nx, ny;
        for(int i = 0; i < 4; i++) {                            //4방향 탐색
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx == 0 && ny == 0) continue;
            if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[nx].length) continue;
            if(maps[nx][ny] == 0) continue;
            if(maps[nx][ny] != 1 || maps[nx][ny] >= maps[x][y] + 1) continue;
            maps[nx][ny] = maps[x][y] + 1;                                   //기록
            dfs(maps, nx, ny);
        }
    }
}
