package moderate.stackimplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main stackimplementation = new Main();
        stackimplementation.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] numbersStr = line.split(" ");
            List<Integer> numbers = new ArrayList<Integer>();
            for (String numberStr: numbersStr) {
                numbers.add(Integer.parseInt(numberStr));
            }
            Collections.reverse(numbers);
            StringBuilder stringBuilder = new StringBuilder();
            String delimiter = "";
            for (int i = 0 ; i < numbers.size(); i+= 2) {
                stringBuilder.append(delimiter).append(numbers.get(i));
                delimiter = " ";
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
