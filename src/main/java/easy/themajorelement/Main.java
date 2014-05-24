package easy.themajorelement;

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
        Main themajorelement = new Main();
        themajorelement.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(",");
            Map<Integer, Integer> reps = new HashMap<Integer, Integer>();
            int size = 0;
            for (String part: parts) {
                int number = Integer.parseInt(part);
                if (!reps.containsKey(number)) {
                    reps.put(number, 0);
                }
                reps.put(number, reps.get(number) + 1);
                size++;
            }
            int result = -1;
            for (Map.Entry<Integer, Integer> entry: reps.entrySet()) {
                if (entry.getValue() > size/2) {
                    result = entry.getKey();
                    break;
                }
            }
            System.out.println(result == -1 ? "None" : result);
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
