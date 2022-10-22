package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class balanceScale { // main 대체
    static final int[] masses = { 100, 50, 20, 10, 5, 2, 1 };

    static int solve(int[] arr, int size) {
        int left, right, diff, cnt;
        left = right = cnt = 0;

        for (int i = 0; i < size; i++) {
            if (left <= right) {
                left += arr[i];
            } else {
                right += arr[i];
            }
        }

        diff = (left > right) ? left - right : right - left;

        for (int i = 0; i < 7; i++) {
            if (diff >= masses[i]) {
                cnt += diff / masses[i];
                diff %= masses[i];
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();

            int[] pebbles = new int[n];
            for (int j = 0; j < n; j++) {
                pebbles[j] = in.nextInt();
            }

            System.out.println(solve(pebbles, n));
        }

        in.close();
    }
}
