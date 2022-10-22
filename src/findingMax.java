import java.util.Scanner;

public class findingMax {
    static int[] binaryList;
    static final int MAX_SIZE = 100;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size;
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            size = sc.nextInt();
            binaryList = new int[MAX_SIZE];
            for(int j = 0; j < size; j++){
                binaryList[j] = sc.nextInt();
            }
            System.out.println(recursiveFind(0, size-1));
        }
    }
    private static int recursiveFind(int start, int end)
    {
        if (start == end){
            return binaryList[start];
        }
        int middle = (end - start) / 2;
        return maxInt(recursiveFind(start,start+middle),recursiveFind(start + middle + 1,end));
    }
    private static int maxInt(int a, int b){
        if(a >= b) return a;
        return b;
    }
}

