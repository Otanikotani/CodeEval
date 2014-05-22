package easy.shortestrepetition;

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

    public static void main(String[] args) throws IOException {
        Main shortestrepetition = new Main();
        shortestrepetition.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            int answer = line.length();
            for (Integer divisor: findAllDivisors(line.length())) {
                StringBuilder regex = new StringBuilder();
                regex.append("(?<=\\G");
                for (int i = 0; i < divisor; i++ ) {
                    regex.append(".");
                }
                regex.append(")");
                String[] splitStrings = line.split(regex.toString());
                HashSet<String> repetitions = new HashSet<String>();
                repetitions.add(splitStrings[0]);
                boolean noMatch = false;
                for (String splitString: splitStrings) {
                    if (!repetitions.contains(splitString)) {
                        noMatch = true;
                        break;
                    }
                }
                if (!noMatch) {
                    answer = Math.min(divisor, answer);
                }
            }
            System.out.println(answer);
        }
    }

    public static Set<Integer> findAllDivisors(int number) {
        Set<Integer> factors = new LinkedHashSet<Integer>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
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
