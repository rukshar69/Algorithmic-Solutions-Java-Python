import java.util.Scanner;

public class ShiftString {

    static int[] computeLps(String pattern , int n){
        int[] lps = new int[n]; int j=0; int i = 1; lps[0] =0;
        //System.out.println("len of pattern "+pattern.length());
        while (i<n){
            //System.out.println("i "+i);System.out.println("j "+j);
            if (pattern.charAt(i) == pattern.charAt(j)){
                j++;lps[i]= j; i++;
            }
            else{
                if(j==0){
                    lps[i] = 0;i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return  lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();String pattern = sc.nextLine();  String string = sc.nextLine();

        int [] lps = computeLps(pattern,n); int min = 0, ind=-1, i = 0, j =0;

        for(int prefixLen = 1;prefixLen<=n;prefixLen++){
            boolean flag = false;
            while (i<n){
                if(pattern.charAt(j) == string.charAt(i)){
                    i++; j++;
                }
                else{
                    if(j!=0){
                        j = lps[j-1];
                    }else i++;

                }

                if(j == prefixLen){
                    flag = true; ind = i-j; break;
                }
            }
            if (!flag) break;
            else min=ind;
        }

        System.out.println(min);

    }
}
