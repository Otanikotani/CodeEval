package moderate.sumofintegers;

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
        Main sumofintegers = new Main();
        sumofintegers.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] numbersStr = line.split(",");
            List<Integer> integers = new ArrayList<Integer>();
            for (String number: numbersStr) {
                integers.add(Integer.parseInt(number.trim()));
            }
            System.out.println(maxSubArray(integers));
        }
    }

    private int maxSubArray(List<Integer> arr) {
        int maxEndingHere = arr.get(0);
        int maxSoFar = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int x = arr.get(i);
            maxEndingHere = Math.max(x, x + maxEndingHere);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
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
