package moderate.theministryoftruth;

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
        Main theministryoftruth = new Main();
        theministryoftruth.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(";");
            String utterance = parts[0].replaceAll("  ", " ");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(.+)?");
            for (String word: parts[1].split(" ")) {
                stringBuilder.append(word).append("(.+)?");
            }
            Pattern p = Pattern.compile(stringBuilder.toString());
            Matcher m = p.matcher(utterance);
            if (m.matches()) {
                for (int i = 1; i <= m.groupCount(); i++) {
                    String group = m.group(i);
                    if (null != group) {
                        String trimmedGroup = group.trim();
                        StringBuilder underscores = new StringBuilder();
                        for (int j = 0 ; j < trimmedGroup.length(); j++) {
                            underscores.append("_");
                        }
                        utterance = utterance.replaceAll(trimmedGroup, underscores.toString());
                    }
                }
            }
            System.out.println(utterance);
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
