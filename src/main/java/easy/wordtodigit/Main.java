package easy.wordtodigit;

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
        Main wordtodigit = new Main();
        wordtodigit.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
//            System.out.println(line);
            String[] words = line.split(";");
            StringBuilder sb = new StringBuilder();
            for (String word: words) {
                if (word.equals("zero")) {
                    sb.append("0");
                } else if (word.equals("one")) {
                    sb.append("1");
                } else if (word.equals("two")) {
                    sb.append("2");
                } else if (word.equals("three")) {
                    sb.append("3");
                } else if (word.equals("four")) {
                    sb.append("4");
                } else if (word.equals("five")) {
                    sb.append("5");
                } else if (word.equals("six")) {
                    sb.append("6");
                } else if (word.equals("seven")) {
                    sb.append("7");
                } else if (word.equals("eight")) {
                    sb.append("8");
                } else if (word.equals("nine")) {
                    sb.append("9");
                }
            }
            System.out.println(sb.toString());
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
