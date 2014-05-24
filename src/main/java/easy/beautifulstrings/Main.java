package easy.beautifulstrings;

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
        Main beautifulstrings = new Main();
        beautifulstrings.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line : lines) {
            Map<Character, Integer> chars = new TreeMap<Character, Integer>();
            for (char ch : line.toCharArray()) {
                if (Character.isLetter(ch)) {
                    Character lowerCased = Character.toLowerCase(ch);
                    if (!chars.containsKey(lowerCased)) {
                        chars.put(lowerCased, 0);
                    }
                    chars.put(lowerCased, chars.get(lowerCased) + 1);
                }
            }

            List<Integer> values = new ArrayList<Integer>(chars.values());
            Collections.sort(values, Collections.reverseOrder());
            int sum = 0;
            int beauty = 26;
            for (Integer integer : values) {
                sum += integer * beauty;
                beauty--;
            }
            System.out.println(sum);


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
