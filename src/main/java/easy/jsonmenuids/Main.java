package easy.jsonmenuids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main jsonmenuids = new Main();
        jsonmenuids.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        Pattern pattern = Pattern.compile(".+id.: (\\d+).+");
        for (String line: lines) {
            int sum = 0;
            if (!line.isEmpty()) {
                int startIndex = line.indexOf("[");
                int endIndex = line.indexOf("]");
                String[] elements = line.substring(startIndex + 1, endIndex).split("},|l,");
                for (String element: elements) {
                    if (!element.equals("nul")) {
                        element = element.trim();
                        if (element.indexOf("label") != -1) {
                            Matcher m = pattern.matcher(element);
                            if (m.matches())
                                sum += Integer.parseInt(m.group(1));
                        }
                    }
                }
                System.out.println(sum);
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
