import java.util.Scanner;

public class mergeSortIter {
    static final int MAX_SIZE = 100;
    static int a[], answer;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0; i < k; i++)
        {
            a = new int[MAX_SIZE];
            answer = 0;
            int size = sc.nextInt();
            for(int j = 0; j < size; j++)
            {
                a[j] = sc.nextInt();
            }
            mergeSort(size);
            System.out.println(answer);
        }
    }
    private static void mergeSort(int n)
    {
        int size = 1;
        while (size < n)
        {
            for(int i = 0; i < n; i += 2 * size)
            {
                int low = i;
                int mid = low + size - 1;
                int high = (i + 2 * size - 1) <= (n - 1) ? (i + 2 * size - 1) : (n - 1);
                if(mid >= n-1) break;
                merge(low,mid,high);
            }
            size*=2;
        }
    }
    private static void merge(int low, int mid, int high)
    {
        int i, j ,k;
        int tmp[] = new int[MAX_SIZE];

        for(i = low; i <= high; i++) tmp[i] = a[i];
        i = low;
        k = low;
        j = mid + 1;
        while(i <= mid && j <= high){
            if(tmp[i] <= tmp[j]) a[k++] = tmp[i++];
            else a[k++] = tmp[j++];
            answer++;
        }
        if(i>mid) {
            while (j <= high) a[k++] = tmp[j++];
        }
        else {
            while (i <= mid) a[k++] = tmp[i++];
        }
    }
}
