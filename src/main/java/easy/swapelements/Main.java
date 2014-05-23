package easy.swapelements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main swapelements = new Main();
        swapelements.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            int delimiter = line.indexOf(':');
            String[] numbersStr = line.substring(0, delimiter).split(" ");
            String[] swaps = line.substring(delimiter + 2, line.length()).split(", ");
            for (String swap: swaps) {
                String[] indices = swap.split("-");
                int from = Integer.parseInt(indices[0]);
                int to = Integer.parseInt(indices[1]);
                String tmp = numbersStr[from];
                numbersStr[from] = numbersStr[to];
                numbersStr[to] = tmp;
            }
            StringBuilder sb = new StringBuilder();
            String delimiterOutput = "";
            for (String number: numbersStr) {
                sb.append(delimiterOutput).append(number);
                delimiterOutput = " ";
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
