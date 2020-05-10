import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.lang.*;

public class Numfact {



    public  static HashMap<Integer, Integer> populateFactorDictionary(int[] list, int n){
        HashMap<Integer, Integer> factorDict = new HashMap<Integer, Integer>();
        for(int i =0;i<n;i++){
            factorDict = factors(list[i], factorDict);
        }
        return  factorDict;
    }
    public  static HashMap<Integer, Integer> factors( int number,HashMap<Integer, Integer> factorMap ){
        int[] tmp = factorCount(number,2);
        int count = tmp[0];  number = tmp[1];
        factorMap = addFactorMap(factorMap, 2, count);
        int limit = (int)(Math.sqrt(number)) + 1; int factor = 3;
        while (factor<=limit){
            tmp = factorCount(number,factor);
            count = tmp[0];  number = tmp[1];
            factorMap = addFactorMap(factorMap, factor, count);
            factor+=2;
        }

        if (number>2){
            if(factorMap.containsKey(number)){
                factorMap.put(number, factorMap.get(number)+1);
            }
            else{
                factorMap.put(number, 1);
            }
        }
        return  factorMap;
    }


    public  static HashMap<Integer, Integer> addFactorMap(HashMap<Integer, Integer>factorMap, int factor, int frequency){
        if (frequency!=0){
            if(factorMap.containsKey(factor)){
                //map.put(key, map.get(key) + 1);
                factorMap.put(factor, factorMap.get(factor)+frequency);
            }
            else{
                factorMap.put(factor, frequency);
            }
        }
        return factorMap;
    }


    public  static  int[] factorCount(int number, int divisor){
        int count =0;
        while (number%divisor==0){
            number /= divisor; count++;
        }
        int [] result = {count,number};
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0;t<test;t++){
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i =0;i<n;i++) a[i] = sc.nextInt();


            HashMap<Integer, Integer>factorDict = populateFactorDictionary(a,n);
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
