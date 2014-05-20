package easy.selfdescribingnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main selfDescribingNumbers = new Main();
        selfDescribingNumbers.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<Integer> results = new ArrayList<Integer>();
        List<String> lines = getLines(args);
        for (String line: lines) {
            results.add(isSelfDescribing(line));
        }
        for (Integer result: results) {
            System.out.println(result);
        }
    }

    private Integer isSelfDescribing(final String value) {
        List<Integer> digits = new ArrayList<Integer>();
        for (String digit: value.split("")) {
            if (!digit.isEmpty())
                digits.add(Integer.valueOf(digit));
        }
        Map<Integer, Integer> numberOfDigits = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            numberOfDigits.put(i, 0);
        }

        for (Integer digit: digits) {
            numberOfDigits.put(digit, numberOfDigits.get(digit) + 1);
        }
        for (int position = 0; position < digits.size(); position++) {
            Integer digit = digits.get(position);
            if (numberOfDigits.get(position) != digit) {
                return 0;
            }
        }
        return 1;
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
