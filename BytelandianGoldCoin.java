import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rukshar Alam on 3/29/2020.
 */
public class BytelandianGoldCoin {


    static Map<Long, Long> dpMap = new HashMap<Long, Long>();

    private static Long dpSolution(Long n) {

        if (dpMap.containsKey(n))
            return dpMap.get(n);

        Long temp = dpSolution(n/ 2) + dpSolution(n/ 3) + dpSolution(n/ 4);
        Long value = Math.max(n, temp);
        dpMap.put(n, value);
        return value;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String string = null;

        while (true) {
            string= in.readLine();
            if (string == null)
                return;
            dpMap.put(0L,0L);
            dpMap.put(1L,1L);
            Long number = Long.parseLong(string);
            System.out.println(dpSolution(number));
        }
    }


}
