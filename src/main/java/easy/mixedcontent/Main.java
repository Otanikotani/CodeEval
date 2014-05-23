package easy.mixedcontent;

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
        Main mixedcontent = new Main();
        mixedcontent.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(",");
            List<String> numbers = new ArrayList<String>();
            List<String> words = new ArrayList<String>();
            for (String part: parts) {
                try {
                    Integer.parseInt(part);
                    numbers.add(part);
                } catch (NumberFormatException nfe) {
                    words.add(part);
                }
            }
            StringBuilder sb = new StringBuilder();
            String delimiter = "";
            for (String word: words) {
                sb.append(delimiter).append(word);
                delimiter = ",";
            }
            delimiter = "";
            if (sb.length() > 0 && !numbers.isEmpty()) {
                sb.append("|");
            }
            for (String number: numbers) {
                sb.append(delimiter).append(number);
                delimiter = ",";
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
