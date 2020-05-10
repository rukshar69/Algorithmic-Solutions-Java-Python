
import java.util.*;
import java.lang.*;

public class NumfactV2 {

    public static ArrayList<Integer> getPrime(){
        int [] primes = new int[1000001];
        for(int i = 2;i<1000001;i++){
            if(primes[i] ==0){
                for(int j = i*2;j<=1000000;j+=i ){
                    primes[j] = 1;
                }
            }
        }
        ArrayList<Integer>list = new ArrayList<Integer>();
        int primeLen = primes.length;
        for(int i = 2;i<primeLen;i++){
            if(primes[i] == 0){
                list.add(i);
            }
        }
        return  list;
    }

    public static HashMap<Integer, Integer>getFactorMap(ArrayList<Integer> primes, int[] numbers, int n){
        HashMap<Integer, Integer> factorDict = new HashMap<Integer, Integer>();
        for(int i =0;i<n;i++){
            factorDict = populateFactorDict(factorDict, primes,numbers[i]);
        }
        return  factorDict;
    }



    public static HashMap<Integer, Integer> populateFactorDict(HashMap<Integer, Integer>factorDict, ArrayList<Integer>primes, int  number){
        int primesLen = primes.size();
        int tmp = number;
        for(int i = 0;i<primesLen;i++){
            int prime =primes.get(i);
            if(prime>tmp) break;

            while (number%prime==0 && number>= prime){
                if(factorDict.containsKey(prime)){
                    factorDict.put(prime, factorDict.get(prime)+1);
                }
                else{
                    factorDict.put(prime, 1);
                }
                number /= prime;
            }
        }
        return  factorDict;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0;t<test;t++){
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i =0;i<n;i++) a[i] = sc.nextInt();


            HashMap<Integer, Integer>factorDict = getFactorMap(getPrime(), a, n);
            long result = 1;

            // Getting an iterator
            Iterator hmIterator = factorDict.entrySet().iterator();
            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                String freq = mapElement.getValue().toString();
                int numberFactors = Integer.parseInt(freq);

                result *= ((long)numberFactors+1);
                //System.out.println("tmp "+result);
            }
            System.out.println(result);


        }
    }
}
