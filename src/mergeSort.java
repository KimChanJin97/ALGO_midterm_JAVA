import java.util.Scanner;

public class mergeSort {
    static int numList[];
    static int answer,size;
    static final int MAX = 100;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            answer = 0;
            size = sc.nextInt();
            numList = new int[MAX];
            for(int j = 0; j < size; j++)
            {
                numList[j] = sc.nextInt();
            }
            merge_sort(numList);
            System.out.println(answer);
        }
    }
    private static void merge_sort(int[] arr){
        sort(arr,0,size-1);
    }
    private static void sort(int[] arr, int l, int r){
        if (l < r){
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void merge(int[] arr, int l, int m, int r) {
        int i, j, k;
        int tmp[] = new int[MAX];
        for(i=l; i<=r; i++)
            tmp[i] = arr[i];
        i = k = l;
        j = m+1;
        while(i<=m && j<=r) {
            if (tmp[i] <= tmp[j]) arr[k++] = tmp[i++];
            else arr[k++] = tmp[j++];
            answer++;
        }
        while(i<=m)
            arr[k++] = tmp[i++];
        while(j<=r)
            arr[k++] = tmp[j++];
    }
}