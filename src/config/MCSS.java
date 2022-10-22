package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MCSS { // main으로 대체
    static int mcssDC(int[] arr, int low, int high) {
        if (low == high)
            return arr[low];

        int mid = (low + high) / 2;

        int centerLeft, centerRight, center, temp;
        centerLeft = centerRight = 0;

        temp = 0;
        for (int i = mid; i >= low; i--) {
            temp += arr[i];
            centerLeft = (centerLeft > temp) ? centerLeft : temp;
        }

        temp = 0;
        for (int j = mid + 1; j <= high; j++) {
            temp += arr[j];
            centerRight = (centerRight > temp) ? centerRight : temp;
        }

        center = centerLeft + centerRight;

        int left, right, side;

        left = mcssDC(arr, low, mid);
        right = mcssDC(arr, mid + 1, high);
        side = (left > right) ? left : right;

        return (center > side) ? center : side;
    }

    static int mcssKadane(int[] arr) {
        int localMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            localMax = (arr[i] > localMax + arr[i]) ? arr[i] : localMax + arr[i];
            if (localMax > globalMax)
                globalMax = localMax;
        }

        return globalMax;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(mcssDC(arr, 0, n - 1));
            // System.out.println("Kadane: " + mcssKadane(arr));
        }

        br.close();
    }
}
