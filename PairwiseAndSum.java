import java.util.Scanner;


public class PairwiseAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n]; int nonZero[] = new int[30];
        for(int i =0;i<n;i++){
            a[i] = sc.nextInt();

        }


        for(int i =0;i<n;i++){
            int num = a[i];
            for(int j =0;j<30;j++){
                int bit = num & (1<<j);
                if(bit != 0) nonZero[j]++;
            }

        }

        long answer=0;
        for(int j =0;j<30;j++){
            answer += ((long)nonZero[j]*((long)nonZero[j]-1L)*(1L<<j));
        }

        System.out.println(answer/2L);

    }
}
