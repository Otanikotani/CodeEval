package easy;

import util.LineReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SelfDescribingNumbers extends LineReader {

    public static void main(String[] args) throws IOException {
        SelfDescribingNumbers selfDescribingNumbers = new SelfDescribingNumbers();
        selfDescribingNumbers.solve(args);

    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        System.out.println(Arrays.toString(lines.toArray()));
    }
}
