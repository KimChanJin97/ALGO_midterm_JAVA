import java.util.Scanner;

// 스트링뒤집기
public class reverseArray {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            char[] charArray = sc.nextLine().toCharArray();
            recursion2(charArray, 0, charArray.length-1);
        }
    }

    public static void recursion2(char[] ca, int first, int last)
    {
        if(last <= first) System.out.println(ca);
        else if (first < last){
            swap(ca,first, last);
            recursion2(ca, first+1, last-1);
        }
    }

    public static void recursion(char[] ca)
    {
        int n = ca.length;
        for(int i = 0; i < n; i++)
        {
            if(i < n - 1 - i)
            {
                swap(ca, i,  n - 1- i);
            }
        }
        System.out.println(ca);
    }

    public static void swap(char[] ca, int a , int b)
    {
        char tmp = ca[a];
        ca[a] = ca[b];
        ca[b] = tmp;
    }
}
