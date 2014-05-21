package easy.hiddendigits;

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
        Main hiddenDigits = new Main();
        hiddenDigits.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            StringBuilder sb = new StringBuilder();
            for (char ch: line.toCharArray()) {
                if (ch >= 48 && ch <= 57) {
                    sb.append(ch);
                } else if (ch >= 97 && ch <= 106) {
                    char digit = (char)(ch - 49);
                    sb.append(digit);
                }
            }
            if (sb.length() <= 0) {
                System.out.println("NONE");
            } else {
                System.out.println(sb.toString());
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
