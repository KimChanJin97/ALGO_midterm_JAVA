package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class binarySearch { // main 으로 대체
    static int bs(int[] arr, int left, int right, int val) {
        int mid;
        if (left > right)
            return -1; // not found
        else {
            mid = (left + right) / 2;

            if (arr[mid] == val)
                return mid;
            else if (arr[mid] > val)
                return bs(arr, left, mid - 1, val);
            else
                return bs(arr, mid + 1, right, val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(bs(arr, 0, n - 1, k));
        }

        br.close();
    }
}
