import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromeMaker {

    public static void main(String[] args) {
        //input
        Scanner scannerInstance = new Scanner(System.in);
        int len = scannerInstance.nextInt();
        String inputRead = scannerInstance.next();
        String[] input = inputRead.split("");


        Map<String, Integer> map = new HashMap<String, Integer>();
        int pos = 0;
        int count = 0;
        // find the first pair
        while(!map.containsKey(input[pos])) {
            map.put(input[pos], pos);
            if(pos + 1 == input.length) count = input.length - 1; else pos++;
        }
        int pairsCount = 0;
        int lastPosFound = 0;
        if(count == 0) {
            for(int j = pos; j < input.length; j++) {
                 if(map.containsKey(input[j])) {
                    count = j - map.get(input[j]) - (pairsCount * 2) - 1;
                    if(pairsCount == 0 && (j - map.get(input[j]) > 1))  count -= 1;
                    pairsCount++;
                    lastPosFound = map.get(input[j]);
                }
                else    count++;
                if(j + 1 == input.length && lastPosFound != 0)
                    count += lastPosFound;
            }
        }
        System.out.print(count);
    }

}
