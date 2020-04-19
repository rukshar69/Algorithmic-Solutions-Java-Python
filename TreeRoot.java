import java.util.Scanner;

/**
 * Created by Rukshar Alam on 4/19/2020.
 */
public class TreeRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t=0;t<test;t++){
            int n = sc.nextInt();
            int sum = 0;
            for(int i =0;i<n;i++){
                int id = sc.nextInt(); int sum_children_id = sc.nextInt();
                sum += (id-sum_children_id);

            }
            System.out.println(sum);
        }
    }
}
