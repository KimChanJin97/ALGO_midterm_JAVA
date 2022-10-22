import java.util.Scanner;

public class quickSort {
    static final int MAX_INT = 1000;
    static int arr1[], arr2[];
    static int h_swap, l_swap, h_comp, l_comp;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0; i < k; i++)
        {
            int size = sc.nextInt();
            arr1 = new int[MAX_INT];
            arr2 = new int[MAX_INT];
            h_swap=0; l_swap=0; h_comp=0; l_comp=0;
            for(int j = 0; j < size; j++)
            {

                arr1[j] = sc.nextInt();
                arr2[j] = arr1[j];
            }
            HoareQuickSort(0,size-1);
            LomutoQuickSort(0,size-1);
            System.out.printf("%d %d %d %d\n",h_swap,l_swap,h_comp,l_comp);
        }
    }
    public static void LomutoQuickSort(int low, int high)
    {
        if(high <= low) return;
        int pivotPos;

        pivotPos = LomutoPartition(low, high);
        LomutoQuickSort(low, pivotPos-1);
        LomutoQuickSort(pivotPos+1, high);

    }
    public static void HoareQuickSort(int low, int high)
    {
        if (low >= high) return;
        int pivotPos;

        pivotPos = HoarePartition(low, high);
        HoareQuickSort(low, pivotPos);
        HoareQuickSort(pivotPos+1, high);
    }
    public static int HoarePartition(int low, int high)
    {
        int tmp;
        int pivot = arr2[low];
        int i = low - 1;
        int j = high + 1;
        while (true)
        {
            while (true) {
                h_comp++;
                if (arr2[++i] >= pivot) break;
            }
            while (true){
                h_comp++;
                if (arr2[--j] <= pivot) break;
            }
            if(i < j){
                tmp = arr2[i]; arr2[i] = arr2[j]; arr2[j] = tmp;
                h_swap++;
            }
            else return j;
        }
    }
    public static int LomutoPartition(int low, int high)
    {
        int j, pivot, pivotPos, tmp;
        pivot = arr1[low];
        j = low;
        for(int i = low+1; i <= high; i++)
        {
            if(arr1[i] < pivot)
            {
                j++;
                tmp = arr1[i]; arr1[i] = arr1[j]; arr1[j] = tmp;
                l_swap++;
            }
            l_comp++;
        }
        pivotPos = j;
        tmp = arr1[pivotPos]; arr1[pivotPos] = arr1[low]; arr1[low] = tmp;
        l_swap++;
        return pivotPos;
    }
}
