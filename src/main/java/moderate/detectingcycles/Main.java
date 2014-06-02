package moderate.detectingcycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main detectingcycles = new Main();
        detectingcycles.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] numbersStr = line.split(" ");
            List<Integer> sequence = new ArrayList<Integer>();
            for (String numberS: numbersStr) {
                sequence.add(Integer.parseInt(numberS));
            }
            Collections.reverse(sequence);
            List<Integer> indexes = userTurtleAndHare(sequence);
            int least = indexes.get(0);
            int most = indexes.get(1);
            StringBuilder sb = new StringBuilder();
            String delimiter = "";
            for (int i = most - 1; i >= least; i--) {
                sb.append(delimiter).append(sequence.get(i));
                delimiter = " ";
            }
            System.out.println(sb.toString());
        }
    }

    private List<Integer> userTurtleAndHare(List<Integer> sequence) {
        List<Integer> result = new ArrayList<Integer>();
        int lam, mu = 0;
        int turtle = 1;
        int hare = 2;
        while (sequence.get(turtle) != sequence.get(hare)) {
            turtle++;
            hare += 2;
        }
        turtle = 0;
        while (sequence.get(turtle) != sequence.get(hare)) {
            turtle++;
            hare++;
            mu++;
        }
        lam = 1;
        hare = turtle + 1;
        while (sequence.get(turtle) != sequence.get(hare)) {
            hare++;
            lam++;
        }
        result.add(mu);
        result.add(lam);
        return result;
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
