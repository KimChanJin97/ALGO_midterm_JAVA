import java.util.Scanner;

public class balanceScale {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j = 0; j < t; j++)
        {
            int n = sc.nextInt();
            int left, right, weight;
            left = sc.nextInt();
            right = sc.nextInt();
            for(int i = 0; i < n-2; i++)
            {
                if(left == right) left += sc.nextInt();
                else if(left > right) right += sc.nextInt();
                else left += sc.nextInt();
            }
            weight = (left > right) ? left - right: right - left;
            int weight_list[] = {100,50,20,10,5,2,1};
            int k = 0, answer = 0;
            while (weight != 0)
            {
                if(weight_list[k] > weight) k++;
                else{
                    answer += weight / weight_list[k];
                    weight = weight % weight_list[k];
                }
            }
            System.out.println(answer);
        }
    }
}
