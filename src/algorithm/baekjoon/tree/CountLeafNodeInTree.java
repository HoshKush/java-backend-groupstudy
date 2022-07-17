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
 * 1068
 * 리프 노드의 개수 구하기
 * 실버 I
 */
public class CountLeafNodeInTree {
    static List<Integer>[] tree;
    static boolean[] visit;
    static int root;
    static int child;
    static int D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] parents = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        D = Integer.parseInt(br.readLine());
        child = 0;
        visit = new boolean[N];

        tree = new LinkedList[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++) {
            if(parents[i] == -1) {
                root = i;
                continue;
            }
            tree[i].add(parents[i]);
            tree[parents[i]].add(i);
        }

        if(D == root) {
            bw.write("0");
        } else {
            dfs(root);
            bw.write(String.valueOf(child));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int p) {
        visit[p] = true;
        int c = 0;
        for(int i : tree[p]) {
            if(visit[i] || D == i) continue;
            c++;
            dfs(i);
        }

        if(c == 0) child++;
    }
}
