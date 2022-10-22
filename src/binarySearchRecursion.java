import java.util.Scanner;

public class binarySearchRecursion {
    static int[] binaryList;
    static int answer = -1;
    static final int MAX_SIZE = 100;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size, findN;
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            size = sc.nextInt();
            findN = sc.nextInt();
            binaryList = new int[MAX_SIZE];
            for(int j = 0; j < size; j++){
                binaryList[j] = sc.nextInt();
            }
            answer = -1;
            recursiveFind(findN, 0, size-1);
            System.out.println(answer);
        }
    }
    private static void recursiveFind(int findN, int start, int end)
    {
        if (start == end){
            if(binaryList[start] == findN) {
                answer = start;
                return;
            }
        }
        else{
            int middle = (end - start) / 2;
            recursiveFind(findN,start,start+middle);
            recursiveFind(findN,start + middle + 1,end);
        }
    }
}