package easy.lowestuniquenumber;

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
        Main lowestuniquenumber = new Main();
        lowestuniquenumber.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] numbers = line.split(" ");
            List<Integer> ints = new ArrayList<Integer>();
            for (String number: numbers) {
                int integer = Integer.parseInt(number);
                ints.add(integer);
            }

            Map<Integer, Integer> repetitions = new HashMap<Integer, Integer>();
            for (Integer integer: ints) {
                if (!repetitions.containsKey(integer)) {
                    repetitions.put(integer, 0);
                }
                repetitions.put(integer, repetitions.get(integer) + 1);
            }
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry: repetitions.entrySet()) {
                if (entry.getValue() == 1) {
                    min = Math.min(min, entry.getKey());
                }
            }
            System.out.println(min == Integer.MAX_VALUE ? "0": ints.indexOf(min) + 1);
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
