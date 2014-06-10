package moderate.pangrams;

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
        Main pangrams = new Main();
        pangrams.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            boolean[] arr = new boolean[123];
            for (char ch: line.toLowerCase().toCharArray()) {
                if (ch < 123 && ch >= 97)
                    arr[ch] = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 97; i < 123; i++) {
                if (!arr[i]) {
                    stringBuilder.append(Character.valueOf((char)i));
                }
            }
            if (stringBuilder.toString().isEmpty()) {
                System.out.println("NULL");
            } else {
                System.out.println(stringBuilder.toString());
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
