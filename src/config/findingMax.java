package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class findingMax { // main으로 대체
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int solve(int[] arr, int left, int right) {
        if (left >= right)
            return arr[left];
        else {
            int half = (left + right) / 2;
            int l = solve(arr, left, half);
            int r = solve(arr, half + 1, right);
            return max(l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solve(arr, 0, n - 1));
        }
        br.close();
    }
}