import java.util.*;

public class factorial {
    static void Recursion(int result, int n){
        if(n <= 1) {
            if (result > 999) result = result % 1000;
            System.out.println(result);
        }
        else {
            result = n * result;
            while(result % 10 == 0) result = result / 10;
            if (result > 999999) result = result % 1000000;
            Recursion(result, n-1);
        }
    }
    static void FC(ArrayList<Integer> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            Recursion(1, inputs.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<Integer>();

        for (int i = 0; i < inputnum; i++){
            inputs.add(sc.nextInt());
            //inputs.add(i);
        }

        FC(inputs, inputnum);
    }
}