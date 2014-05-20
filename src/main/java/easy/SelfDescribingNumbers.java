package easy;

import util.LineReader;

import java.io.IOException;
import java.util.*;

public class SelfDescribingNumbers extends LineReader {

    public static void main(String[] args) throws IOException {
        SelfDescribingNumbers selfDescribingNumbers = new SelfDescribingNumbers();
        selfDescribingNumbers.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<Integer> results = new ArrayList<Integer>();
        List<String> lines = getLines(args);
        for (String line: lines) {
            results.add(isSelfDescribing(Long.valueOf(line)));
        }
        for (Integer result: results) {
            System.out.println(result);
        }
    }

    private Integer isSelfDescribing(final Long value) {
        long temp = value;
        Map<Integer, Integer> numberOfDigits = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            numberOfDigits.put(i, 0);
        }
        List<Integer> digits = new ArrayList<Integer>();
        while (temp != 0) {
            int digit = (int)(temp % 10);
            temp = temp / 10;
            digits.add(digit);
            numberOfDigits.put(digit, numberOfDigits.get(digit) + 1);
        }
        Collections.reverse(digits);
        for (int position = 0; position < digits.size(); position++) {
            Integer digit = digits.get(position);
            if (numberOfDigits.get(position) != digit) {
                return 0;
            }
        }
        return 1;
    }
}
