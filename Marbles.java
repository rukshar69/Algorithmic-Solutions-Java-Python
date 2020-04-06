import java.util.Scanner;

/**
 * Created by Rukshar Alam on 4/6/2020.
 */
public class Marbles {

    static long combinatorics(int n, int r){
        if(r>n/2) r = n-r;
        long result = 1;

        for(int i =1;i<=r;i++){
            result = result*n;
            n--;
            result = result / i;
        }
        return  result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int t =0;t<test;t++){
            int n = sc.nextInt(); int k = sc.nextInt();
            long answer = combinatorics(n-1,n-k);
            System.out.println(answer);
        }
    }
}
