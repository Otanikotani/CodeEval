package easy.happynumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    Set<Integer> repetitions  = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        Main happynumbers = new Main();
        happynumbers.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            repetitions.clear();
            findHappyNumber(Integer.parseInt(line));
        }
    }

    private void findHappyNumber(int number) {
        if (number == 1) {
            System.out.println("1");
            return;
        }
        List<Integer> digits = getDigits(number);
        int sum = 0;
        for (Integer digit: digits) {
            sum += digit * digit;
        }
        if (repetitions.contains(sum)) {
            System.out.println("0");
        } else {
            repetitions.add(sum);
            findHappyNumber(sum);
        }
    }

    public List<Integer> getDigits(int number) {
        List<Integer> result = new ArrayList<Integer>();
        while (number > 0) {
            result.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(result);
        return result;
    }



    public List<String> getLines(String[] args) throws IOException {
        if (args.length > 0) {
            return Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset());
        } else {
            String className = getClass().getSimpleName();
            String packageName = getClass().getPackage().getName();
            packageName = packageName.replaceAll(Pattern.quote("."), "/");
            InputStream is = this.getClass().getResourceAsStream("/" + packageName + "/" + className + "Sample.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            List<String> result = new ArrayList<String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            return result;
        }
    }
}
