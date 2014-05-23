package easy.compressedsequence;

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
        Main compressedsequence = new Main();
        compressedsequence.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(" ");
            List<Integer> ints = new ArrayList<Integer>();
            for (String part: parts) {
                ints.add(Integer.parseInt(part));
            }

            StringBuilder sb = new StringBuilder();
            String delimiter = "";
            Integer current = ints.get(0);
            int count = 0;
            for (Integer number: ints) {
                if (number == current) {
                    count++;
                } else {
                    sb.append(delimiter).append(count);
                    delimiter = " ";
                    sb.append(delimiter).append(current);
                    count = 1;
                    current = number;
                }
            }

            sb.append(delimiter).append(count);
            delimiter = " ";
            sb.append(delimiter).append(ints.get(ints.size() - 1));
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
