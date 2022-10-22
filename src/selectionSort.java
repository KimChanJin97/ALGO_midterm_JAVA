import java.util.Scanner;

public class selectionSort {
    static final int MAX_INT = 1000;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++)
        {
            int[] a = new int[MAX_INT];
            int num = sc.nextInt();
            for(int j = 0; j < num; j++) a[j] = sc.nextInt();
            selectionSort(a,num);
        }
    }
    private static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    private static void selectionSort(int arr[], int n)
    {
        int countCmpOps = 0;
        int countSwaps = 0;

        for(int i = 0; i < n-1; i++)
        {
            int min = i;
            for(int j = i + 1; j < n; j++)
            {
                countCmpOps++;
                if(arr[j] < arr[min]) min = j;
            }
            if(min != i){
                countSwaps++;
                swap(arr, min, i);
            }
        }
        System.out.println(countCmpOps + " " + countSwaps);
    }
}