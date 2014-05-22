package easy.romannumerals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main romannumerals = new Main();
        romannumerals.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            StringBuilder sb = new StringBuilder();
            int number = Integer.parseInt(line);
            int thousands = number / 1000;
            int hundreds = (number / 100) % 10;
            int dozens = (number / 10)  % 10;
            int ones = (number / 1) % 10;

            for (int i = 0 ; i < thousands; i++) {
                sb.append("M");
            }
            add("M", "D", "C", sb, hundreds);
            add("C", "L", "X", sb, dozens);
            add("X", "V", "I", sb, ones);
            System.out.println(sb.toString());
        }
    }

    private void add(String tens, String fives, String ones, StringBuilder sb, int number) {

        if (number == 4) {
            sb.append(ones + fives);
        } else if (number == 9) {
            sb.append(ones + tens);
        } else if (number >= 5) {
            sb.append(fives);
            for (int i = 0; i < (number - 5); i++) {
                sb.append(ones);
            }
        } else {
            for (int i = 0; i < number; i++) {
                sb.append(ones);
            }
        }
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
