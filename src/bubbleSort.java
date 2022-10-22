import java.util.Scanner;

class bubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numTestCases = in.nextInt();

        for(int i = 0; i < numTestCases; i++) {

            int num = in.nextInt();
            int[] a = new int[num];
            int[] b = new int[num];
            for(int j = 0; j < num; j++ ) {
                a[j] = in.nextInt();

            }

            copyArray1(a, b, num);
            bubbleSort1(b, num);
            System.out.print(" ");
            copyArray1(a, b, num);
            bubbleSortImproved1(b, num);
            System.out.print(" ");
            copyArray1(a, b, num);
            bubbleSortImproved2(b, num);
            System.out.println();

        }
    }

    static void copyArray1(int a[], int b[], int n) {

        for(int i = 0; i < n; i++) {
            b[i] = a[i];
        }

    }

    static void bubbleSort1(int a[], int n) {
        int pass;
        int compare = 0;
        int swap = 0;
        for(pass = 1; pass < n; pass++) {
            for(int i = 1; i < (n-pass+1); i++) {
                compare += 1;
                if(a[i] < a[i-1]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    swap += 1;
                }
            }
        }

        System.out.print(compare + " " + swap);
    }

    static void bubbleSortImproved1(int a[], int n) {
        int pass;
        int compare = 0;
        int swap = 0;
        boolean swaped;
        for(pass = 1; pass < n; pass++) {
            swaped = false;
            for(int i = 1; i < (n-pass+1); i++) {
                compare += 1;
                if(a[i] < a[i-1]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    swap += 1;
                    swaped = true;
                }
            }
            if(swaped == false) {
                break;
            }
        }
        System.out.print(compare + " " + swap);


    }

    static void bubbleSortImproved2(int a[], int n) {
        int pass = 1;
        int lastSwappedPos = n;
        int compare = 0;
        int swap = 0;
        while(lastSwappedPos > 0) {
            int swappedPos = 0;
            for(int i = 1; i < lastSwappedPos; i++) {
                compare += 1;
                if(a[i] < a[i-1]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    swap += 1;
                    swappedPos = i;
                }
            }
            lastSwappedPos = swappedPos;
        }

        System.out.print(compare + " " + swap);


    }

}
