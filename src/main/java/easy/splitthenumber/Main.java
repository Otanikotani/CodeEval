package easy.splitthenumber;

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
        Main splitthenumber = new Main();
        splitthenumber.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(" ");
            char key = 'a';
            char count = 0;
            Map<Character, Character> map = new HashMap<Character, Character>();
            for (char ch: parts[0].toCharArray()) {
                map.put((char)(key + count), ch);
                count++;
            }
            StringBuilder sb = new StringBuilder();
            char sign = '=';
            for (char ch: parts[1].toCharArray()) {
                if (Character.isLetter(ch)) {
                    sb.append(map.get(ch));
                } else {
                    sign = ch;
                    sb.append(sign);
                }
            }
            String[] numbers = sb.toString().split(sign == '-' ? "\\-" : "\\+");
            if (sign == '-') {
                System.out.println(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]));
            } else {
                System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
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
