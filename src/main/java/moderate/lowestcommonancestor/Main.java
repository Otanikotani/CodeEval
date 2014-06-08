package moderate.lowestcommonancestor;

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

    private static final Map<Integer, Integer> levels;
    private static final Map<Integer, Integer> ancestors;
    static {
        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
        aMap.put(8, 1);
        aMap.put(52, 1);
        aMap.put(3, 2);
        aMap.put(20, 2);
        aMap.put(10, 3);
        aMap.put(29, 3);
        aMap.put(30, 0);
        Map<Integer, Integer> bMap = new HashMap<Integer, Integer>();
        bMap.put(1, 30);
        bMap.put(2, 8);
        bMap.put(3, 20);
        bMap.put(0, 30);
        levels = Collections.unmodifiableMap(aMap);
        ancestors = Collections.unmodifiableMap(bMap);
    }


    public static void main(String[] args) throws IOException {
        Main lowestcommonancestor = new Main();
        lowestcommonancestor.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(" ");
            Integer value1 = Integer.parseInt(parts[0]);
            Integer value2 = Integer.parseInt(parts[1]);
            if (value1 == 20 || value1 == 8) {
                int level2 = levels.get(value2);
                int level1 = levels.get(value1);
                if (level2 > level1) {
                    System.out.println(value1);
                } else if (level2 == level1)  {
                    System.out.println(ancestors.get(level1));
                } else {
                    if (value2 == 8) {
                        System.out.println(value2);
                    } else {
                        System.out.println(ancestors.get(level2));
                    }
                }
            } else if (value2 == 20 || value2 == 8) {
                int level2 = levels.get(value2);
                int level1 = levels.get(value1);
                if (level1 > level2) {
                    System.out.println(value2);
                } else if (level2 == level1)  {
                    System.out.println(ancestors.get(level2));
                } else {
                    System.out.println(ancestors.get(level1));
                }

            } else {
                System.out.println(ancestors.get(Math.min(levels.get(value1), levels.get(value2))));
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
