package easy.setintersection;

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
        Main setintersection = new Main();
        setintersection.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(";");
            Set<Integer> set0 = new LinkedHashSet<Integer>();
            for (String part: parts[0].split(",")) {
                set0.add(Integer.parseInt(part));
            }
            Set<Integer> set1 = new LinkedHashSet<Integer>();
            for (String part: parts[1].split(",")) {
                set1.add(Integer.parseInt(part));
            }

            StringBuilder stringBuilder = new StringBuilder();
            String delimiter = "";
            for (Integer number: set0) {
                if (set1.contains(number)) {
                    stringBuilder.append(delimiter).append(number);
                    delimiter = ",";
                }
            }
            System.out.println(stringBuilder.toString());
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
