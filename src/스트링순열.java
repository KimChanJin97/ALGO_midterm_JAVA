import java.util.Scanner;

// 스트링순열
public class 스트링순열 {
    static int answer = 0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++)
        {
            answer = 0;
            char[] ca = sc.nextLine().toCharArray();
            recursion(0,0,0,ca,0);
            System.out.println(answer * factorial_cal(ca.length / 2 + ca.length % 2) * factorial_cal(ca.length / 2));
        }
    }
    private static void recursion(int a, int b, int sum, char[] ca, int idx)
    {
        if(idx == ca.length)
        {
            if (sum > 0) answer++;
        }
        else {
            if (ca.length / 2 > b && ca.length / 2 + ca.length % 2 > a) {
                recursion(a + 1, b, sum + (ca[idx] - '0' - 49), ca, idx + 1);
                recursion(a, b + 1, sum - (ca[idx] - '0' - 49), ca, idx + 1);
            }
            else if(ca.length /2 <= b && ca.length / 2 + ca.length % 2 > a)
                recursion(a+1, b, sum + (ca[idx] - '0' - 49), ca, idx+1);
            else if(ca.length /2 + ca.length % 2 <= a && ca.length / 2 > b)
                recursion(a, b+1, sum - (ca[idx] - '0' - 49), ca, idx+1);
        }
    }
    private static int factorial_cal(int n)
    {
        if(n <= 1)
        {
            return 1;
        }
        else {
            return factorial_cal(n-1)*n;
        }
    }
}
