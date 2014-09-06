package easy.niceangles;

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
        Main niceangles = new Main();
        niceangles.solve(args);
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            Float angle = Float.valueOf(line);
            StringBuilder sb = new StringBuilder();
            sb.append((new Integer(angle.intValue())).toString());
            int minutes = convertToMinutesStr(angle);
            int seconds = convertToSecondsStr(angle);
            sb.append(".").append(String.format("%02d", minutes)).append("'").append(String.format("%02d", seconds)).append("\"");
            System.out.println(sb.toString());
        }
    }

    private int convertToMinutesStr(float angle) {
        return (int)((angle - (int)angle) * 60);
    }

    private int convertToSecondsStr(float angle) {
        return (int)((angle - (int)angle - convertToMinutesStr(angle)/60f) * 3600);
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
