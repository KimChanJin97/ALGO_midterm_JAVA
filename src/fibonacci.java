import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int k = sc.nextInt();
            System.out.println(fibonacci(k));
        }
    }
    private static int fibonacci(int k)
    {
        if(k <= 1)
            return k;
        else{
            return fibonacci(k-1) + fibonacci(k-2);
        }
    }
}
