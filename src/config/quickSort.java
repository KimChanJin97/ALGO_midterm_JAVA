package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class quickSort { // main으로 대체
    static int swapLomuto, swapHoare, compLomuto, compHoare;

    static void swap(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

    static int[] copyArr(int[] arr, int size) {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    static int partitionLomuto(int[] arr, int low, int high) {
        int i, j; // greater than pivot item, less than pivot item
        int pivot, pivotPos;

        // int mid = (low + high) / 2;

        // pivot(low) / i / j / not decided yet(high)
        pivot = arr[low];
        i = low;
        for (j = low + 1; j <= high; j++) {
            compLomuto++;
            if (arr[j] < pivot) {
                swapLomuto++;
                swap(arr, ++i, j);
            }
        }

        // pivot(low) / i / j(high)
        pivotPos = i;

        // swap
        swapLomuto++;
        swap(arr, low, pivotPos);

        // i(low) / pivot(pivotPos) / j(high)
        return pivotPos;
    }

    static int partitionHoare(int[] arr, int low, int high) {
        int i, j; // less than pivot, greater than pivot
        int pivot;

        pivot = arr[low];

        i = low - 1;
        j = high + 1;

        // i(low - 1) / pivot(low) / not decided yet / j(high + 1)
        while (true) {
            // move idx markers i, j toward center
            // until we find a pair of mis-partitioned elem

            compHoare++;
            while (arr[++i] < pivot) {
                compHoare++;
            } // pivot(low) / i
            compHoare++;
            while (arr[--j] > pivot) {
                compHoare++;
            }

            if (i < j) {
                swapHoare++;
                swap(arr, i, j);
            } else {
                return j;
            }
        }
    }

    static void quickSortLomuto(int[] arr, int low, int high) {
        int pivotPos;

        if (high > low) { // arr's length > 1, base case
            // pivotPos = partitionLomuto(arr, low, high);
            pivotPos = partitionLomuto(arr, low, high);
            quickSortLomuto(arr, low, pivotPos - 1);
            quickSortLomuto(arr, pivotPos + 1, high);
        }
    }

    static void quickSortHoare(int[] arr, int low, int high) {
        int pivotPos;

        if (high > low) { // arr's length > 1, base case
            pivotPos = partitionHoare(arr, low, high);
            quickSortHoare(arr, low, pivotPos);
            quickSortHoare(arr, pivotPos + 1, high);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr1[j] = num;
                arr2[j] = num;
            }

            swapLomuto = swapHoare = compLomuto = compHoare = 0;

            quickSortHoare(arr1, 0, n - 1);
            quickSortLomuto(arr2, 0, n - 1);

            System.out.println(String.format("%d %d %d %d", swapHoare, swapLomuto, compHoare, compLomuto));
        }

        br.close();
    }
}
