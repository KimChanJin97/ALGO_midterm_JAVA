package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class mergeSort { // main으로 대체
    static final int MAX_SIZE = 100;
    static int cnt;

    static void merge(int[] arr, int left, int center, int right) {
        int[] temp = new int[MAX_SIZE];

        int i, j, k;
        for (i = left; i <= right; i++)
            temp[i] = arr[i];

        i = k = left;
        j = center + 1;

        while (i <= center && j <= right) {
            arr[k++] = (temp[i] <= temp[j]) ? temp[i++] : temp[j++];
            cnt++;
        }

        while (i <= center)
            arr[k++] = temp[i++];
        while (j <= right)
            arr[k++] = temp[j++];
    }

    static void mergeSort(int[] arr, int left, int right) {
        int mid;

        if (left >= right)
            return; // base case
        mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            cnt = 0;

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            mergeSort(arr, 0, n - 1);
            System.out.println(cnt);
        }

        br.close();
    }
}
