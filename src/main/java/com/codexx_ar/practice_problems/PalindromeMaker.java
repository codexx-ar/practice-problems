package com.codexx_ar.practice_problems;
import java.util.Scanner;

public class PalindromeMaker {

    public static void main(String[] args) {
        // get input
        Scanner scannerInstance = new Scanner(System.in);
        int len = scannerInstance.nextInt();
        String inputRead = scannerInstance.next();
        System.out.print(countPalindromeExtraLetters(len, inputRead));
    }

    public static int countPalindromeExtraLetters(int len, String inputRead) {
        if(len <= 1)    return 0;
        int pos = 1;
        int count = 0;
        // find the first pair
        while(pos < len && !inputRead.substring(0, pos).contains(String.valueOf(inputRead.charAt(pos))))    pos++;
        // no duplicates
        if(pos == 1)    return 0;
        if(pos == len) count = len - 1;
        else {
            int pairsCount = 0;
            // String part 1 of the palindrome around the first pair
            int firstPairDiff = pos - inputRead.indexOf(inputRead.charAt(pos)) > 1 ? 1 : 0;
            String inputReadPart1 = inputRead.substring(0, pos - firstPairDiff);
            for(int j = pos; j < len; j++) {
                if(inputReadPart1.contains(String.valueOf(inputRead.charAt(j)))) pairsCount++;
            }
            // count is the string length minus the number of pairs - the
            count = len - (pairsCount * 2) - firstPairDiff;
        }
        return count;
    }

}
