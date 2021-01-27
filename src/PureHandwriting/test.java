package PureHandwriting;

import java.util.*;

class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String N = input.next();
            int result = monaIncreasingDigits(N);
            System.out.println(""+result);
        }
    }


    public static int monaIncreasingDigits(String N) {
        char[] S = String.valueOf(N).toCharArray();

        int i = 1;
        while (i < S.length && S[i-1] <= S[i])
            i++;


        int j = i;
        char currVal = S[j-1];
        while (0 < j && j < S.length && S[j-1] > S[j]) {
            j--;
            S[j] = --currVal;
        }


        for (j = i; j < S.length; ++j)
            S[j] = '9';


        return Integer.parseInt(String.valueOf(S));
    }

}