package moderate.longestlines;

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
        Main longestlines = new Main();
        longestlines.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        int N = Integer.parseInt(lines.get(0));
        List<String> sortedLines = new ArrayList<String>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!line.isEmpty()) {
                sortedLines.add(line);
            }
        }
        Collections.sort(sortedLines, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new Integer(o1.length()).compareTo(o2.length());
            }
        });
        Collections.reverse(sortedLines);
        for (int i = 0; i < N; i++ ) {
            System.out.println(sortedLines.get(i));
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
