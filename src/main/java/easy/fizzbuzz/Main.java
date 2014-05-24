package easy.fizzbuzz;

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
        Main fizzbuzz = new Main();
        fizzbuzz.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(" ");
            Integer a = Integer.parseInt(parts[0]);
            Integer b = Integer.parseInt(parts[1]);
            Integer n = Integer.parseInt(parts[2]);
            StringBuilder sb = new StringBuilder();
            String delimiter = "";
            for (int i = 1; i <= n; i++) {
                sb.append(delimiter);
                if (i % a == 0 || i % b == 0) {
                    if (i % a == 0) {
                        sb.append("F");
                    }
                    if (i % b == 0) {
                        sb.append("B");
                    }
                } else {
                    sb.append(i);
                }
                delimiter = " ";
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
