package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class mergeSortIter { // main으로 대체
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

    static void mergeSortRecursive(int[] arr, int left, int right) {
        int mid;

        if (left >= right)
            return; // base case
        mid = (left + right) / 2;

        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void mergeSortIterative(int[] arr, int size) {
        int i = 1;

        while (i < size) {
            for (int j = 0; j < size; j += 2 * i) {
                int low = j;
                int mid = low + i - 1;
                int high = (j + 2 * i - 1 < size - 1) ? j + 2 * i - 1 : size - 1;

                // if there's just 1 subArr to merge
                if (mid >= size - 1)
                    break;

                merge(arr, low, mid, high);
            }

            i *= 2;
        }
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

            // mergeSortRecursive(arr, 0, n - 1);
            mergeSortIterative(arr, n);
            System.out.println(cnt);
        }

        br.close();
    }
}
