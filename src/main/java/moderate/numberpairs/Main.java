package moderate.numberpairs;

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
        Main numberpairs = new Main();
        numberpairs.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line : lines) {
            String[] parts = line.split(";");
            Integer number = Integer.parseInt(parts[1]);
            String[] arrStr = parts[0].split(",");
            List<Integer> arr = new ArrayList<Integer>();
            for (String str : arrStr) {
                arr.add(Integer.parseInt(str));
            }
            List<String> result = new ArrayList<String>();
            for (int i = 0; i < arr.size(); i++) {
                int first = arr.get(i);
                int sum = -1;
                for (int j = i + 1; j < arr.size(); j++) {
                    int second = arr.get(j);
                    sum = first + second;
                    if (sum > number) {
                        sum = -1;
                        break;
                    } else if (sum == number) {
                        String expr = String.valueOf(first) +
                                "," +
                                String.valueOf(second);
                        result.add(expr);
                    }
                }
            }
            if (result.isEmpty()) {
                System.out.println("NULL");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                String delimiter = "";
                for (String res: result) {
                    stringBuilder.append(delimiter).append(res);
                    delimiter = ";";
                }
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
