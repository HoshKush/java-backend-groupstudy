package algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 11725
 * 트리의 부모 찾기
 * 실버 II
 */
public class Tree {
    static int N;
    static List<Integer>[] tree;
    static int[] parents;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        visit = new boolean[N + 1];

        tree = new LinkedList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            tree[i] = new LinkedList<>();
        }

        int[] edges;
        for(int i = 0; i < N - 1; i++) {
            edges = Arrays.stream(br.readLine().split("\\s")).mapToInt(n -> Integer.parseInt(n)).toArray();
            tree[edges[0]].add(edges[1]);
            tree[edges[1]].add(edges[0]);
        }

        dfs(1);

        for(int i = 2; i < N + 1; i++) {
            bw.write(parents[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int n) {
        visit[n] = true;
        tree[n].forEach(i -> {
            if(!visit[i]) {
                parents[i] = n;
                dfs(i);
            }
        });
    }
}
